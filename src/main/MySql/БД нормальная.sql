-- База данных, какой она должна быть в моём представлении.
CREATE SCHEMA `human friends 2` ;
USE `human friends 2` ;
CREATE TABLE IF NOT EXISTS `animals` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NULL,
`type` VARCHAR(45) NULL,
`birth_date` DATE NULL,
`commands` VARCHAR(255) NULL,
PRIMARY KEY (`id`));
INSERT INTO `animals` 
(`name`, `type`, `birth_date`, `commands`) 
VALUES
('Fido', 'dog', '2020-01-01', 'Sit, Stay, Fetch'),
('Buddy', 'dog', '2018-12-10', 'Sit, Paw, Bark'), 
('Bella', 'dog', '2019-11-11', 'Sit, Stay, Roll'),
('Whiskers', 'cat', '2019-05-15', 'Sit, Pounce'),
('Smudge', 'cat', '2020-02-20', 'Sit, Pounce, Scratch'), 
('Oliver', 'cat', '2020-06-30', 'Meow, Scratch, Jump'),
('Hammy', 'hamster', '2021-03-10', 'Roll, Hide'),
('Peanut', 'hamster', '2021-08-01', 'Roll, Spin'),
('Thunder', 'horse', '2015-07-21', 'Trot, Canter, Gallop'),
('Storm', 'horse', '2014-05-05', 'Trot, Canter'), 
('Blaze', 'horse', '2016-02-29', 'Trot, Jump, Gallop'),
('Sandy', 'camel', '2016-11-03', 'Walk, Carry Load'),
('Dune', 'camel', '2018-12-12', 'Walk, Sit'), 
('Sahara', 'camel', '2015-08-14', 'Walk, Run'),
('Eeyore', 'donkey', '2017-09-18', 'Walk, Carry Load, Bray'),
('Burro', 'donkey', '2019-01-23', 'Walk, Bray, Kick');
CREATE TABLE IF NOT EXISTS `pets` (
`id` INT NOT NULL AUTO_INCREMENT,
`animal_id` INT NOT NULL,  
PRIMARY KEY (`id`),
FOREIGN KEY (`animal_id`) REFERENCES `animals`(`id`));
INSERT INTO `pets` (`animal_id`) 
SELECT `id` FROM `animals` 
WHERE type = 'dog' OR type = 'cat' OR type = 'hamster';
CREATE TABLE IF NOT EXISTS `pack_animals` (
`id` INT NOT NULL AUTO_INCREMENT,
`animal_id` INT NOT NULL,  
PRIMARY KEY (`id`),
FOREIGN KEY (`animal_id`) REFERENCES `animals`(`id`));
INSERT INTO `pack_animals` (`animal_id`) 
SELECT `id` FROM `animals` 
WHERE type = 'horse' OR type = 'camel' OR type = 'donkey';
  
  
  