package models;

import java.util.Date;
import java.util.List;

public abstract class Pet extends Animal {
    public Pet(String name, Date birthDate, List<String> commands) {
        super(name, birthDate, commands);
    }
}
