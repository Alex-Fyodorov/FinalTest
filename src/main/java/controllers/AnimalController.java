package controllers;

import models.*;
import repositories.AnimalRepository;
import views.OutputText;
import views.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AnimalController {

    private final AnimalRepository repository;
    private final View view;
    private final OutputText text;

    public AnimalController(AnimalRepository repository, View view, OutputText text) {
        this.repository = repository;
        this.view = view;
        this.text = text;
    }

    public void start() {
        boolean flag = true;
        while (flag) {
            Integer input = printMenu(text.mainMenu());
            switch (input) {
                case 1 -> getAllAnimals();
                case 2 -> findByTypeMenu();
                case 3 -> addNewAnimal();
                case 4 -> flag = false;
            }
        }
    }

    public Integer printMenu(List<String> menu) {
        view.printMenu(menu);
        Integer input = view.inputInt();
        while (input < 1 || input > menu.size()) {
            view.printString(text.incorrectInput());
            input = view.inputInt();
        }
        return input;
    }

    public void getAllAnimals() {
        List<Animal> animals = repository.findAll();
        view.printAnimals(animals, text.countString(animals.size()));
        postListMenu(animals);
    }

    public void findByTypeMenu() {
        List<Animal> animals = List.of();
        Integer input = printMenu(text.typeOfAnimal());
        switch (input) {
            case 1 -> animals = repository.findByType("Pet");
            case 2 -> animals = repository.findByType("PackAnimal");
            case 3 -> animals = repository.findByClass("Dog");
            case 4 -> animals = repository.findByClass("Cat");
            case 5 -> animals = repository.findByClass("Hamster");
            case 6 -> animals = repository.findByClass("Horse");
            case 7 -> animals = repository.findByClass("Camel");
            case 8 -> animals = repository.findByClass("Donkey");
            case 9 -> {
                return;
            }
        }
        view.printAnimals(animals, text.countString(animals.size()));
        postListMenu(animals);
    }

    public void postListMenu(List<Animal> animals) {
        Integer input = printMenu(text.postList());
        switch (input) {
            case 1 -> changeCommand(selectAnimal(animals));
            case 2 -> view.printAnimals(sortByBirthDate(animals), text.countString(animals.size()));
        }
    }

    public List<Animal> sortByBirthDate(List<Animal> animalList) {
        Collections.sort(animalList);
        return animalList;
    }

    public Animal selectAnimal(List<Animal> animals) {
        view.printString(text.changeCommand());
        Integer input = view.inputInt();
        Animal animal = null;
        while (animal == null) {
            try{
                animal = repository.findById(input, animals);
            } catch (RuntimeException e) {
                view.printString(text.notFound(input));
                input = view.inputInt();
            }
        }
        return animal;
    }

    public void changeCommand(Animal animal) {
        view.printString(text.newCommand());
        String newCommand = view.inputString();
        while (newCommand == null || newCommand.equals("")) {
            newCommand = view.inputString();
        }
        view.printAnimals(List.of(repository.
                addNewCommand(animal, newCommand)), null);
    }

    public void addNewAnimal() {
        view.printString(text.inputType());
        Integer type = printMenu(text.typeList());
        view.printString(text.inputName());
        String name = view.inputString();
        while (name == null || name.equals("")) {
            name = view.inputString();
        }
        view.printString(text.inputBirthDate());
        String birthDate = view.inputString();
        Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        while (date == null) {
            try {
                date = dateFormat.parse(birthDate);
            } catch (ParseException e) {
                view.printString(text.incorrectDate());
                birthDate = view.inputString();
            }
            if (date != null && date.after(new Date())) {
                view.printString(text.futureDate());
                date = null;
                birthDate = view.inputString();
            }
        }
        List<String> commands = new ArrayList<>();
        view.printString(text.inputCommands());
        String commandString = view.inputString();
        while (commandString == null || commandString.equals("")) {
            commandString = view.inputString();
        }
        String[] commandArray = commandString.split(",");
        for (String str : commandArray) {
            commands.add(str.strip());
        }
        Animal animal = repository.addNewAnimal(createNewAnimal(type, name, date, commands));
        view.printAnimals(List.of(animal), null);
    }

    public Animal createNewAnimal(Integer type, String name,
                                  Date birthDate, List<String> commands) {
        Animal animal = null;
        switch (type) {
            case 1 -> animal = new Dog(name, birthDate, commands);
            case 2 -> animal = new Cat(name, birthDate, commands);
            case 3 -> animal = new Hamster(name, birthDate, commands);
            case 4 -> animal = new Horse(name, birthDate, commands);
            case 5 -> animal = new Camel(name, birthDate, commands);
            case 6 -> animal = new Donkey(name, birthDate, commands);
        }
        return animal;
    }
}
