package option_managers;

import database.KoszykProxy;
import furnitures_production.factories.ModernFurnituresFactory;
import furnitures_production.factories.TraditionalFurnituresFactory;

import java.util.Objects;
import java.util.Scanner;

public abstract class OptionManager {
    boolean dodawanie;
    Scanner myObj;
    ModernFurnituresFactory modernFurnituresFactory;
    TraditionalFurnituresFactory traditionalFurnituresFactory;
    KoszykProxy basket;

    public OptionManager(KoszykProxy basket) {
        this.basket= basket;
    }

    public void steps() {
        setVariables();
        showInformation();
        String option= getOption();
        while(option!=null)
        {
            createFurniture(option);
            addFurniture();
            showInstruction();
            option=getOption();
        }

    }

    public void setVariables() {
        dodawanie = true;
        myObj = new Scanner(System.in);
        modernFurnituresFactory = new ModernFurnituresFactory();
        traditionalFurnituresFactory = new TraditionalFurnituresFactory();

    }
    public void showInstruction()
    {
        System.out.println("\nWpisz poprawnie nazwe przedmiotu, który chcesz dodać do koszyka\nwyjdz - wyjdź z tego trybu");
    }
    public abstract void showInformation();
    public String getOption()
    {
            String choice = myObj.nextLine();
            if(Objects.equals(choice, "wyjdz")){return null;}
            else return choice;

    }
    abstract public void createFurniture(String option);
    abstract public void addFurniture();


}
