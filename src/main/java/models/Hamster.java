package models;

import java.util.Date;
import java.util.List;

public class Hamster extends Pet{
    public Hamster(String name, Date birthDate, List<String> commands) {
        super(name, birthDate, commands);
    }
}
