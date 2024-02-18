package models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public abstract class Animal implements Comparable<Animal> {

    private Integer id;
    private String name;
    private Date birthDate;
    private List<String> commands;

    public Animal(String name, Date birthDate, List<String> commands) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {
        return  id + ", " +
                this.getClass().getSimpleName() + " {" +
                "name: " + name +
                ", birthDate: " + new SimpleDateFormat("dd-MM-yyyy").format(birthDate) +
                ", commands: " + commands +
                '}';
    }

    @Override
    public int compareTo(Animal o) {
        return this.getBirthDate().after(o.getBirthDate()) ? -1 :
                o.getBirthDate().after(this.getBirthDate()) ? 1 : 0;
    }
}
