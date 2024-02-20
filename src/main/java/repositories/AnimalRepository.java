package repositories;

import models.Animal;

import java.util.List;

public interface AnimalRepository {
    List<Animal> findAll();
    Animal findById(Integer id, List<Animal> animalList);
    List<Animal> findByClass(String className);
    List<Animal> findByType(String className);
    Animal addNewAnimal(Animal animal);
    Animal addNewCommand(Animal animal, String newCommand);
}
