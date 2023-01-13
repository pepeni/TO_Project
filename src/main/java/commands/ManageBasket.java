package commands;

import adding_managers.AddingSofaManager;
import adding_managers.AddingTableManager;
import database.BasketProxy;
import furniture_production.furnitures.Sofa;
import furniture_production.furnitures.Table;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ManageBasket implements Command {

    BasketProxy basket;

    public ManageBasket(BasketProxy basket) {
        this.basket = basket;
    }

    @Override
    public void execute() {
        boolean manage = true;
        Scanner myObj = new Scanner(System.in);
        while (manage) {


            System.out.println("\nKomendy:\n\tdodaj do koszyka - przejdz do trybu wyboru mebli\n\tusun z koszyka - przejdz do trybu usuwania mebli z koszyka\n\twyjdz - konczy tryb zarzadzania koszykiem");
            String pick = myObj.nextLine();

            if (Objects.equals(pick.toLowerCase(), "wyjdz")) {
                manage = false;
            }
            if (Objects.equals(pick.toLowerCase(), "dodaj do koszyka")) {
                addToBasket();
            }
            if (Objects.equals(pick.toLowerCase(), "usun z koszyka")) {
                DeleteFromBasket();
            }
        }
    }

    public void addToBasket() {
        boolean adding = true;
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nCo chcesz wybierać?");

        while (adding) {
            System.out.println("\nsofy - przejdź do wyboru sofy\nstoly - przedź do wyboru stołów\nwyjdz - wyjdź");
            String wybor = myObj.nextLine();
            if (Objects.equals(wybor.toLowerCase(), "wyjdz")) {
                adding = false;
            }
            if (Objects.equals(wybor.toLowerCase(), "sofy")) {
                AddingSofaManager addingSofaManager = new AddingSofaManager(basket);
                addingSofaManager.steps();
            }
            if (Objects.equals(wybor.toLowerCase(), "stoly")) {
                AddingTableManager addingTableManager = new AddingTableManager(basket);
                addingTableManager.steps();
            }
        }

    }


    public void DeleteFromBasket() {
        ArrayList<Sofa> sofas = basket.getSofas();
        ArrayList<Table> tables = basket.getTables();

        boolean deleteItem = true;
        Scanner myObj = new Scanner(System.in);


        while (deleteItem) {
            System.out.println("\n\nWpisz poprawnie indeks pezedmiotu, który chcesz usunąć z koszyka\nAby wyjść wpisz: 0\n");
            int id = 1;

            for (Sofa sofa : sofas) {
                System.out.println(id + " " + sofa.getInformationAboutSofa());
                id += 1;
            }
            for (Table table : tables) {
                System.out.println(id + " " + table.getInformationAboutTable());
                id += 1;
            }

            int pick = Integer.parseInt(myObj.nextLine());
            if (Objects.equals(pick, 0)) {
                deleteItem = false;
            } else if (pick - 1 < sofas.size()) {
                basket.deleteSofas(pick - 1);
                System.out.println("\nWyrzucono pomyślnie :)");
            } else if (pick - sofas.size() - 1 < tables.size()) {
                basket.deleteTables(pick - sofas.size() - 1);
                System.out.println("\nWyrzucono pomyślnie :)");
            } else {
                System.out.println("Wpisano zły indeks");
            }
        }
    }
}
