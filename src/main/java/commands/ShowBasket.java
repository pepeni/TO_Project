package commands;

import database.BasketProxy;
import furniture_production.furnitures.Sofa;
import furniture_production.furnitures.Table;

import java.util.ArrayList;

public class ShowBasket implements Command {

    BasketProxy basket;

    public ShowBasket(BasketProxy basket) {
        this.basket = basket;
    }

    @Override
    public void execute() {

        ArrayList<Sofa> sofas = basket.getSofas();
        ArrayList<Table> tables = basket.getTables();

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
