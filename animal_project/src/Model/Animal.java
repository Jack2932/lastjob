package Model;

import java.util.ArrayList;

public abstract class Animal {
    protected static int id;
    public String name;
    public String  birthday;
    public ArrayList <String> commands;


    public Animal(int id, String name, String  birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAnimalCommands() {
        return commands.toString();
    }

    public void addCommand(String command){
        commands.add(command);

    }
    @Override
    public String toString() {
        return String.format("ID: "+ getId(), "name: " + getName(), "birthday:" + getBirthday());
    }

}
