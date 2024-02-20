package models;

import java.util.Date;
import java.util.List;

public class Donkey extends PackAnimal{
    public Donkey(String name, Date birthDate, List<String> commands) {
        super(name, birthDate, commands);
    }
}
