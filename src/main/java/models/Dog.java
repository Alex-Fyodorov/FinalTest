package models;

import java.util.Date;
import java.util.List;

public class Dog extends Pet{
    public Dog(String name, Date birthDate, List<String> commands) {
        super(name, birthDate, commands);
    }
}
