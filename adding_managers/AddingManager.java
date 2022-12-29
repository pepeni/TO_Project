package adding_managers;

import database.KoszykProxy;
import furniture_production.factories.ModernFurnitureFactory;
import furniture_production.factories.TraditionalFurnitureFactory;

import java.util.Objects;
import java.util.Scanner;

public abstract class AddingManager {
    boolean adding;
    Scanner myObj;
    ModernFurnitureFactory modernFurnituresFactory;
    TraditionalFurnitureFactory traditionalFurnituresFactory;
    KoszykProxy basket;

    public AddingManager(KoszykProxy basket) {
        this.basket = basket;
    }

    public void steps() {
        setVariables();
        showInformation();
        String option = getOption();
        while (option != null) {
            createFurniture(option);
            addFurniture();
            showInstruction();
            option = getOption();
        }

    }

    public void setVariables() {
        adding = true;
        myObj = new Scanner(System.in);
        modernFurnituresFactory = new ModernFurnitureFactory();
        traditionalFurnituresFactory = new TraditionalFurnitureFactory();

    }

    public void showInstruction() {
        System.out.println("\nWpisz poprawnie nazwe przedmiotu, który chcesz dodać do koszyka\nwyjdz - wyjdź z tego trybu");
    }

    public abstract void showInformation();

    public String getOption() {
        String choice = myObj.nextLine();
        if (Objects.equals(choice.toLowerCase(), "wyjdz")) {
            return null;
        } else return choice;

    }

    abstract public void createFurniture(String option);

    abstract public void addFurniture();
}
