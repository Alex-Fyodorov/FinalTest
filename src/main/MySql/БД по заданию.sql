-- База данных, созданная согласно заданию.

-- Создаём саму базу данных.
CREATE SCHEMA `human friends` ;
USE `human friends` ;

-- Создаём таблицу собак.
CREATE TABLE IF NOT EXISTS `dogs` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NULL,
`birth_date` DATE NULL,
`commands` VARCHAR(255) NULL,
PRIMARY KEY (`id`));

-- Создаём таблицу кошек.
CREATE TABLE IF NOT EXISTS `cats` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NULL,
`birth_date` DATE NULL,
`commands` VARCHAR(255) NULL,
PRIMARY KEY (`id`));

-- Создаём таблицу хомяков.
CREATE TABLE IF NOT EXISTS `hamsters` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NULL,
`birth_date` DATE NULL,
`commands` VARCHAR(255) NULL,
PRIMARY KEY (`id`));

-- Создаём таблицу лошадей.
CREATE TABLE IF NOT EXISTS `horses` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NULL,
`birth_date` DATE NULL,
`commands` VARCHAR(255) NULL,
PRIMARY KEY (`id`));

-- Создаём таблицу верблюдов.
CREATE TABLE IF NOT EXISTS `camels` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NULL,
`birth_date` DATE NULL,
`commands` VARCHAR(255) NULL,
PRIMARY KEY (`id`));

-- Создаём таблицу ослов.
CREATE TABLE IF NOT EXISTS `donkeys` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NULL,
`birth_date` DATE NULL,
`commands` VARCHAR(255) NULL,
PRIMARY KEY (`id`));

-- Заполняем таблицу собак.
INSERT INTO `dogs` 
(`name`, `birth_date`, `commands`) 
VALUES 
('Fido', '2020-01-01', 'Sit, Stay, Fetch'),
('Buddy', '2018-12-10', 'Sit, Paw, Bark'), 
('Bella', '2019-11-11', 'Sit, Stay, Roll');

-- Заполняем таблицу кошек.
INSERT INTO `cats` 
(`name`, `birth_date`, `commands`) 
VALUES 
('Whiskers', '2019-05-15', 'Sit, Pounce'),
('Smudge', '2020-02-20', 'Sit, Pounce, Scratch'), 
('Oliver', '2020-06-30', 'Meow, Scratch, Jump');

-- Заполняем таблицу хомяков.
INSERT INTO `hamsters` 
(`name`, `birth_date`, `commands`) 
VALUES 
('Hammy', '2021-03-10', 'Roll, Hide'),
('Peanut', '2021-08-01', 'Roll, Spin');

-- Заполняем таблицу лошадей.
INSERT INTO `horses` 
(`name`, `birth_date`, `commands`) 
VALUES 
('Thunder', '2015-07-21', 'Trot, Canter, Gallop'),
('Storm', '2014-05-05', 'Trot, Canter'), 
('Blaze', '2016-02-29', 'Trot, Jump, Gallop');

-- Заполняем таблицу верблюдов.
INSERT INTO `camels` 
(`name`, `birth_date`, `commands`) 
VALUES 
('Sandy', '2016-11-03', 'Walk, Carry Load'),
('Dune', '2018-12-12', 'Walk, Sit'), 
('Sahara', '2015-08-14', 'Walk, Run');

-- Заполняем таблицу ослов.
INSERT INTO `donkeys` 
(`name`, `birth_date`, `commands`) 
VALUES 
('Eeyore', '2017-09-18', 'Walk, Carry Load, Bray'),
('Burro', '2019-01-23', 'Walk, Bray, Kick');

-- Создаём таблицу домашних животных.
CREATE TABLE IF NOT EXISTS `pets` (
`id` INT NOT NULL AUTO_INCREMENT,
`animal_id` INT NOT NULL,  
`type` VARCHAR(45) NULL,
PRIMARY KEY (`id`));

-- Заполняем таблицу домашних животных.
INSERT INTO `pets` (`animal_id`, `type`)
SELECT `id`, 'dog' FROM `dogs`
UNION
SELECT `id`, 'cat' FROM `cats`
UNION
SELECT `id`, 'hamster' FROM `hamsters`;

-- Создаём таблицу вьючных животных.
CREATE TABLE IF NOT EXISTS `pack_animals` (
`id` INT NOT NULL AUTO_INCREMENT,
`animal_id` INT NOT NULL,  
`type` VARCHAR(45) NULL,
PRIMARY KEY (`id`));

-- Заполняем таблицу вьючных животных.
INSERT INTO `pack_animals` (`animal_id`, `type`)
SELECT `id`, 'horse' FROM `horses`
UNION
SELECT `id`, 'camel' FROM `camels`
UNION
SELECT `id`, 'donkey' FROM `donkeys`;

-- Удаляем верблюдов из всех таблиц.
SET SQL_SAFE_UPDATES = 0;
DELETE FROM `camels`;
DELETE FROM `pack_animals` WHERE type = 'camel';

-- Объединяем лошадей и ослов в одном представлении.
CREATE VIEW `horses_&_donkeys` AS
SELECT `id`, `name`, 'horse' AS `type`, 
`birth_date`, `commands` FROM `horses`
UNION
SELECT `id`, `name`, 'donkey' AS `type`, 
`birth_date`, `commands` FROM `donkeys`;

-- Создаём представление, в котором
-- перечислены животные возрастом 1-3 года.
CREATE VIEW `1-3_age_animals` AS
SELECT * FROM (
SELECT `id`, `name`, 'horse' AS `type`, 
TIMESTAMPDIFF(MONTH, `birth_date`, NOW()) AS `age`
FROM `horses`
UNION
SELECT `id`, `name`, 'donkey' AS `type`, 
TIMESTAMPDIFF(MONTH, `birth_date`, NOW()) AS `age`
FROM `donkeys`
UNION
SELECT `id`, `name`, 'camel' AS `type`, 
TIMESTAMPDIFF(MONTH, `birth_date`, NOW()) AS `age`
FROM `camels`
UNION
SELECT `id`, `name`, 'dog' AS `type`, 
TIMESTAMPDIFF(MONTH, `birth_date`, NOW()) AS `age`
FROM `dogs`
UNION
SELECT `id`, `name`, 'cat' AS `type`, 
TIMESTAMPDIFF(MONTH, `birth_date`, NOW()) AS `age`
FROM `cats`
UNION
SELECT `id`, `name`, 'hamster' AS `type`, 
TIMESTAMPDIFF(MONTH, `birth_date`, NOW()) AS `age`
FROM `hamsters`
) as `temp` WHERE `age` > 12 AND `age` <= 36;

-- Создаём представление, в котором
-- перечислены все животные.
CREATE VIEW `all_animals` AS
SELECT `id`, `name`, 'horse' AS `type`, 
`birth_date`, `commands`
FROM `horses`
UNION
SELECT `id`, `name`, 'donkey' AS `type`, 
`birth_date`, `commands`
FROM `donkeys`
UNION
SELECT `id`, `name`, 'camel' AS `type`, 
`birth_date`, `commands`
FROM `camels`
UNION
SELECT `id`, `name`, 'dog' AS `type`, 
`birth_date`, `commands`
FROM `dogs`
UNION
SELECT `id`, `name`, 'cat' AS `type`, 
`birth_date`, `commands`
FROM `cats`
UNION
SELECT `id`, `name`, 'hamster' AS `type`, 
`birth_date`, `commands`
FROM `hamsters`;

