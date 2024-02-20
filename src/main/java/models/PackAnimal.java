package models;

import java.util.Date;
import java.util.List;

public abstract class PackAnimal extends Animal{
    public PackAnimal(String name, Date birthDate, List<String> commands) {
        super(name, birthDate, commands);
    }
}
