package views;

import models.Animal;

import java.util.List;

public interface View {
    Integer inputInt();
    String inputString();
    void printAnimals(List<Animal> animals, String count);
    void printMenu(List<String> stringList);
    void printString(String str);
}
