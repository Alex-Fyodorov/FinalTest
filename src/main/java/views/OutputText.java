package views;

import java.util.List;

public interface OutputText {
    String incorrectInput();
    List<String> mainMenu();
    List<String> typeOfAnimal();
    List<String> postList();
    String changeCommand();
    String notFound(Integer id);
    String countString(Integer count);
    String newCommand();
    String inputType();
    List<String> typeList();
    String inputName();
    String inputBirthDate();
    String incorrectDate();
    String futureDate();
    String inputCommands();
}
