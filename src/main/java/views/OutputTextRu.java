package views;

import java.util.List;

public class OutputTextRu implements OutputText {

    @Override
    public List<String> mainMenu() {
        return List.of(
                "1. Вывести полный список животных.",
                "2. Вывести животных определённого вида.",
                "3. Добавить в список новое животное.",
                "4. Выход."
        );
    }

    @Override
    public String incorrectInput() {
        return "Вы ввели число большее или меньшее, чем необходимо.\nПопробуйте ещё раз.";
    }

    @Override
    public List<String> typeOfAnimal() {
        return List.of(
                "1. Вывести домашних животных.",
                "2. Вывести вьючных животных.",
                "3. Вывести список собак.",
                "4. Вывести список кошек.",
                "5. Вывести список хомяков.",
                "6. Вывести список лошадей.",
                "7. Вывести список верблюдов.",
                "8. Вывести список ослов.",
                "9. Вернуться в главное меню."
        );
    }

    @Override
    public List<String> postList() {
        return List.of(
                "1. Выбрать животное из списка и добавить ему команду.",
                "2. Отсортировать список по датам рождения.",
                "3. Вернуться в главное меню."
        );
    }

    @Override
    public String changeCommand() {
        return "Введите id животного, которому хотите добавить команду.";
    }

    @Override
    public String notFound(Integer id) {
        return String.format(
                "Животное с id: %d не найдено в этом списке.\nПопробуйте ещё раз.",
                id);
    }

    @Override
    public String countString(Integer count) {
        return String.format("В данном списке %d животных.", count);
    }

    @Override
    public String newCommand() {
        return "Введите новую команду для выбранного животного.";
    }

    @Override
    public String inputType() {
        return "Введите тип нового животного:";
    }

    @Override
    public List<String> typeList() {
        return List.of(
                "1. Собака.",
                "2. Кошка.",
                "3. Хомяк.",
                "4. Лошадь.",
                "5. Верблюд.",
                "6. Осёл."
        );
    }

    @Override
    public String inputName() {
        return "Введите имя нового животного.";
    }

    @Override
    public String inputBirthDate() {
        return "Введите дату рождения нового животного в формате \"yyyy-MM-dd\".";
    }

    @Override
    public String incorrectDate() {
        return "Дата введена некорректно.\nПопробуйте ещё раз.";
    }

    @Override
    public String futureDate() {
        return "Вы ввели дату, превышающую текущую.\nПопробуйте ещё раз.";
    }

    @Override
    public String inputCommands() {
        return "Введите через запятую набор команд для нового животного.";
    }
}
