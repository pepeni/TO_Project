package commands;

import database.KoszykProxy;
import furniture_production.furnitures.Sofa;
import furniture_production.furnitures.Table;

import java.util.ArrayList;

public class PrzegladajKoszyk implements Command {

    KoszykProxy basket;

    public PrzegladajKoszyk(KoszykProxy basket) {
        this.basket = basket;
    }

    @Override
    public void execute() {

        ArrayList<Sofa> sofas = basket.getSofy();
        ArrayList<Table> tables = basket.getStoly();

        int id = 1;

        for (Sofa sofa : sofas) {
            System.out.println(id + " " + sofa.getInformationAboutSofa());
            id += 1;
        }
        for (Table table : tables) {
            System.out.println(id + " " + table.getInformationAboutTable());
            id += 1;
        }
    }
}
