package View;

import Controller.AnimalController;
import Model.Animal;
import Services.Counter;
import Services.Validator;

import java.util.List;
import java.util.Scanner;

public class ViewAnimal {
    public static AnimalController animalController;

    public ViewAnimal(AnimalController animalController) {
        this.animalController = animalController;
    }

    public static void run() throws RuntimeException {
        try (Scanner in = new Scanner(System.in, "ibm866");
             Counter counter = new Counter()) {       // кастомный счетчик

            boolean flag = true;
//            int id;
            while (flag) {
                System.out.println("Список команд:\n" +
                        "1 - Завести новое животное \n" +
                        "2 - вывести список всех животных \n" +
                        "3 - вывести данные животного по ID \n" +
                        "4 - обучить животное новым командам\n" +
                        "5 - увидеть список команд, которое выполняет животное(ID)\n" +
                        "6 - удалить животное \n" +
                        "7 - показать количество животных \n" +
                        "8 - выход \n");

                String command = in.next();
                try {
                    switch (command) {
                        case "1":           //Завести новое животное
                            System.out.println("Выберите вид животного:\n" +
                                    "1 - кот\n" +
                                    "2 - собака\n" +
                                    "3 - хомяк\n" +
                                    "4 - лошадь\n" +
                                    "5 - верблюд\n" +
                                    "6 - осел\n");


                            String animalType = in.next();
                            System.out.println("Введите имя: ");
                            String name = in.next();
                            String birthday = inputBirthday();

                            switch (animalType) {
                                case "1":
                                    animalController.addCat(counter.getSum(), name, birthday);
                                    counter.add();
                                    break;
                                case "2":
                                    animalController.addDog(counter.getSum(), name, birthday);
                                    counter.add();
                                    break;
                                case "3":
                                    animalController.addHamster(counter.getSum(), name, birthday);
                                    counter.add();
                                    break;
                                case "4":
                                    animalController.addHorse(counter.getSum(), name, birthday);
                                    counter.add();
                                    break;
                                case "5":
                                    animalController.addCamel(counter.getSum(), name, birthday);
                                    counter.add();
                                    break;
                                case "6":
                                    animalController.addDonkey(counter.getSum(), name, birthday);
                                    counter.add();
                                    break;
                                default:
                                    System.out.println("такого у нас не предусмотрено");
                                    break;
                            }
                            break;
                        case "2": // вывести список всех животных
                            List<Animal> animals = animalController.getAll();
                            for (int i = 0; i < animals.toArray().length; i++) {
                                System.out.println(animals.get(i).toString());
                            }
                            break;
                        case "3": //вывести данные животного по ID
                            System.out.println("Введите id:");
                            int id = Integer.parseInt(in.next());
                            System.out.println(animalController.getAnimal(id).toString());
                            break;
                        case "4": //обучить животное новым командам
                            System.out.println("Введите ID животного: ");
                            int ID = Integer.parseInt(in.next());
                            System.out.println("Введите команду: ");
                            String commandForAnimal = in.next();
                            animalController.addCommand(ID, commandForAnimal);
                            System.out.println("Добавлено");
                            break;
                        case "5":  //увидеть список команд, которое выполняет животное(ID)
                            System.out.println("Введите ID животного: ");
                            int Id = Integer.parseInt(in.next());
                            System.out.println(animalController.getCommands(Id));
                            break;
                        case "6": //удалить животное
                            System.out.println("Введите ID животного: ");
                            id = Integer.parseInt(in.next());
                            animalController.deleteAnimal(id);
                            System.out.println("Удалено");
                            break;
                        case "7":
                            System.out.println(counter.getSum());
                            break;
                        case "8":
                            System.out.println("До свидания");
                            flag = false;
                            break;
                        default:
                            System.out.println("такого варианта нет");
                            break;
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static String inputBirthday() throws Exception {
        try {
            Scanner in = new Scanner(System.in);
            Validator validator = new Validator();
            while (true) {
                System.out.println("Введите дату рождения в формате yyyy-mm-dd");
                String date = in.next();
                if (validator.isValidDate(date)) {
                    String birthday = date;
                    return birthday;
                }
            }
        } catch (Exception e) {
            System.out.println("неверная дата" + e.getMessage());
        }
        return null;
    }
}
