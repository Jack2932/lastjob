package Services;

import Model.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalRepository implements IRepository {
    private List<Animal> animals;

    public AnimalRepository() {
        this.animals = new ArrayList<Animal>();
    }

    @Override
    public List<Animal> getAll() {
        return animals;
    }

    @Override
    public Animal getById(int id) {
        if(id >= 0 && id < animals.size()) {
            return animals.get(id);
        }
        return null;
    }

    @Override
    public void add(Animal animal) {
        animals.add(animal);

    }
    @Override
    public void delete(Animal animal) {
        animals.remove(animal);
    }
}
