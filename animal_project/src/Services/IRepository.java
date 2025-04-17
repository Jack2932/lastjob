package Services;

import Model.Animal;

import java.util.List;

public interface IRepository <T>{

    List<Animal> getAll();
    T getById(int id);

    void add(Animal animal);

    void delete (Animal animal);
}
