package Controller;

import Model.*;
import Services.AnimalRepository;
import View.ViewAnimal;

import java.util.List;

public class AnimalController {
    private static AnimalRepository animalRepository;
    List<Animal> animals;

    public AnimalController(AnimalRepository animalRepository) {

        this.animalRepository = animalRepository;
        this.animals = animalRepository.getAll();

    }


    public static void start() throws Exception {

        ViewAnimal.run();
    }


    public void addCat(int id, String name, String birthday) {
        Cat cat = new Cat(id, name, birthday);
        animals.add(cat);
    }

    public void addDog(int id, String name, String birthday) {
        Dog dog = new Dog(name, birthday);
        animals.add(dog);
    }

    public void addHamster(int id, String name, String birthday) {
        Hamster hamster = new Hamster(name, birthday);
        animals.add(hamster);
    }

    public void addHorse(int id, String name, String birthday) {
        Horse horse = new Horse(name, birthday);
        animals.add(horse);
    }

    public void addDonkey(int id, String name, String birthday) {
        Donkey donkey = new Donkey(name, birthday);
        animals.add(donkey);
    }

    public void addCamel(int id, String name, String birthday) {
        Camel camel = new Camel(id, name, birthday);
        animals.add(camel);
    }

    public List<Animal> getAll() {
        return animals;
    }

    public Animal getAnimal(int id) {
        return searchForID(id);
    }

    public void addCommand(int id, String command) { // добавляем команду
        Animal item = searchForID(id);
        animals.remove(item);
        item.addCommand(command);
        animals.add(item);

    }

    public Animal searchForID(int id) {  //поиск по id
        for (int i = 0; i < animals.size(); i++) {
            if (id == animals.get(i).getId()) {
                Animal animal = animals.get(i);
                return animal;
            }
        }
        return null;
    }

    public String getCommands(int id) {
        return searchForID(id).getAnimalCommands();
    }

    public void deleteAnimal(int id) {
        animals.remove(searchForID(id));
    }
}
