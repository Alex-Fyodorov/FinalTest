package repositories;

import models.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class InMemoryAnimalRepository implements AnimalRepository {

    private final List<Animal> animals;
    private Integer index;

    public InMemoryAnimalRepository() {
        animals = new ArrayList<>();
        index = 0;
        init();
    }

    private void init() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Animal> animalsList = null;
        try {
            animalsList = new ArrayList<>(List.of(
                    new Dog("Fido", dateFormat.parse("2020-01-01"), List.of("Sit", "Stay", "Fetch")),
                    new Cat("Whiskers", dateFormat.parse("2019-05-15"), List.of("Sit", "Pounce")),
                    new Hamster("Hammy", dateFormat.parse("2021-03-10"), List.of("Roll", "Hide")),
                    new Dog("Buddy", dateFormat.parse("2018-12-10"), List.of("Sit", "Paw", "Bark")),
                    new Cat("Smudge", dateFormat.parse("2020-02-20"), List.of("Sit", "Pounce", "Scratch")),
                    new Hamster("Peanut", dateFormat.parse("2021-08-01"), List.of("Roll", "Spin")),
                    new Dog("Bella", dateFormat.parse("2019-11-11"), List.of("Sit", "Stay", "Roll")),
                    new Cat("Oliver", dateFormat.parse("2020-06-30"), List.of("Meow", "Scratch", "Jump")),
                    new Horse("Thunder", dateFormat.parse("2015-07-21"), List.of("Trot", "Canter", "Gallop")),
                    new Camel("Sandy", dateFormat.parse("2016-11-03"), List.of("Walk", "Carry Load")),
                    new Donkey("Eeyore", dateFormat.parse("2017-09-18"), List.of("Walk", "Carry Load", "Bray")),
                    new Horse("Storm", dateFormat.parse("2014-05-05"), List.of("Trot", "Canter")),
                    new Camel("Dune", dateFormat.parse("2018-12-12"), List.of("Walk", "Sit")),
                    new Donkey("Burro", dateFormat.parse("2019-01-23"), List.of("Walk", "Bray", "Kick")),
                    new Horse("Blaze", dateFormat.parse("2016-02-29"), List.of("Trot", "Jump", "Gallop")),
                    new Camel("Sahara", dateFormat.parse("2015-08-14"), List.of("Walk", "Run"))
            ));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (animalsList == null) return;
        for (Animal animal : animalsList) {
            addNewAnimal(animal);
        }
    }

    @Override
    public Animal addNewAnimal(Animal animal) {
        index++;
        animal.setId(index);
        animals.add(animal);
        return animal;
    }

    @Override
    public List<Animal> findByClass(String className) {
        List<Animal> result = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getClass().getSimpleName().equals(className)) {
                result.add(animal);
            }
        }
        return result;
    }

    @Override
    public List<Animal> findByType(String className) {
        List<Animal> result = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getClass().getSuperclass().getSimpleName().equals(className)) {
                result.add(animal);
            }
        }
        return result;
    }

    @Override
    public Animal addNewCommand(Animal animal, String newCommand) {
        List<String> animalCommands = new ArrayList<>(animal.getCommands());
        animalCommands.add(newCommand);
        animal.setCommands(animalCommands);
        return animal;
    }

    @Override
    public Animal findById(Integer id, List<Animal> animalList) {
        return animalList.stream().filter(a -> a.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Animal not found, id: %d", id)));
    }

    @Override
    public List<Animal> findAll() {
        return animals;
    }
}
