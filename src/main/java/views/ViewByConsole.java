package views;

import models.Animal;

import java.util.List;
import java.util.Scanner;

public class ViewByConsole implements View {
    private final Scanner scanner;

    public ViewByConsole() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Integer inputInt() {
        return scanner.nextInt();
    }

    @Override
    public String inputString() {
        return scanner.nextLine();
    }

    @Override
    public void printAnimals(List<Animal> animals, String count) {
        breakLine();
        for (Animal animal : animals) {
            System.out.println(animal);
        }
        breakLine();
        if (count != null) {
            System.out.println(count);
            breakLine();
        }
    }

    @Override
    public void printMenu(List<String> stringList) {
        for (String str : stringList) {
            System.out.println(str);
        }
        breakLine();
    }

    @Override
    public void printString(String str) {
        System.out.println(str);
    }

    private void breakLine() {
        System.out.println("===================================================");
    }
}
