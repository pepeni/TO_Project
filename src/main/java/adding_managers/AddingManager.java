package adding_managers;

import database.BasketProxy;
import furniture_production.factories.ModernFurnitureFactory;
import furniture_production.factories.TraditionalFurnitureFactory;

import java.util.Objects;
import java.util.Scanner;

public abstract class AddingManager {
    boolean adding;
    Scanner myObj;
    ModernFurnitureFactory modernFurnitureFactory;
    TraditionalFurnitureFactory traditionalFurnitureFactory;
    BasketProxy basket;

    public AddingManager(BasketProxy basket) {
        this.basket = basket;
        myObj = new Scanner(System.in);
        modernFurnitureFactory = new ModernFurnitureFactory();
        traditionalFurnitureFactory = new TraditionalFurnitureFactory();
    }

    public void steps() {
        setVariables();
        showInformation();
        String option = getOption();
        if (option != null) {
            createFurniture(option);
            addFurniture();
        }

    }

    public void setVariables() {
        adding = true;

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

    public void setMyObj(Scanner myObj) {
        this.myObj = myObj;
    }

    public void setModernFurnitureFactory(ModernFurnitureFactory modernFurnitureFactory) {
        this.modernFurnitureFactory = modernFurnitureFactory;
    }

    public void setTraditionalFurnitureFactory(TraditionalFurnitureFactory traditionalFurnitureFactory) {
        this.traditionalFurnitureFactory = traditionalFurnitureFactory;
    }
}
