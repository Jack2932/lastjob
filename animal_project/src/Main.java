import Controller.AnimalController;
import Services.AnimalRepository;
import View.ViewAnimal;

public class Main {
    public static void main(String[] args) throws Exception {
        AnimalRepository myFarm = new AnimalRepository();
        AnimalController animalController = new AnimalController(myFarm);
        ViewAnimal viewAnimal = new ViewAnimal(animalController);
        animalController.start();
   }
}