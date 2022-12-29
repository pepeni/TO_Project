package commands;

import adding_managers.AddingSofaManager;
import adding_managers.AddingTableManager;
import database.KoszykProxy;
import furniture_production.furnitures.Sofa;
import furniture_production.furnitures.Table;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ZarzadzajKoszykiem implements Command {

    KoszykProxy basket;

    public ZarzadzajKoszykiem(KoszykProxy basket) {
        this.basket = basket;
    }

    @Override
    public void execute() {
        boolean zarzadzanie = true;
        Scanner myObj = new Scanner(System.in);
        while (zarzadzanie) {


            System.out.println("\nKomendy:\n\tdodaj do koszyka - przejdz do trybu wyboru mebli\n\tusun z koszyka - przejdz do trybu usuwania mebli z koszyka\n\twyjdz - konczy tryb zarzadzania koszykiem");
            String wybor = myObj.nextLine();

            if (Objects.equals(wybor.toLowerCase(), "wyjdz")) {
                zarzadzanie = false;
            }
            if (Objects.equals(wybor.toLowerCase(), "dodaj do koszyka")) {
                dodawania_do_koszyka();
            }
            if (Objects.equals(wybor.toLowerCase(), "usun z koszyka")) {
                usuwanie_z_koszyka();
            }
        }
    }

    public void dodawania_do_koszyka() {
        boolean dodawanie = true;
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nCo chcesz wybierać?");

        while (dodawanie) {
            System.out.println("\nsofy - przejdź do wyboru sofy\nstoly - przedź do wyboru stołów\nwyjdz - wyjdź");
            String wybor = myObj.nextLine();
            if (Objects.equals(wybor.toLowerCase(), "wyjdz")) {
                dodawanie = false;
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


    public void usuwanie_z_koszyka() {
        ArrayList<Sofa> sofas = basket.getSofy();
        ArrayList<Table> tables = basket.getStoly();

        boolean wyrzucanie = true;
        Scanner myObj = new Scanner(System.in);


        while (wyrzucanie) {
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

            int wybor = Integer.parseInt(myObj.nextLine());
            if (Objects.equals(wybor, 0)) {
                wyrzucanie = false;
            } else if (wybor - 1 < sofas.size()) {
                basket.deleteSofy(wybor - 1);
                System.out.println("\nWyrzucono pomyślnie :)");
            } else if (wybor - sofas.size() - 1 < tables.size()) {
                basket.deleteStoly(wybor - sofas.size() - 1);
                System.out.println("\nWyrzucono pomyślnie :)");
            } else {
                System.out.println("Wpisano zły indeks");
            }
        }
    }
}
