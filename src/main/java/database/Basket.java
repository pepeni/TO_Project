package database;

import java.util.ArrayList;

import furniture_production.furnitures.Sofa;
import furniture_production.furnitures.Table;


public class Basket implements BasketInterface {
    private static Basket instance;
    private final ArrayList<Table> basketTables;
    private final ArrayList<Sofa> basketSofas;

    private Basket() {
        // initialize database
        this.basketTables = new ArrayList<>();
        this.basketSofas = new ArrayList<>();
    }

    public static Basket getInstance() {
        if (instance == null) {
            instance = new Basket();
        }
        return instance;
    }


    @Override
    public void addSofa(Sofa value) {
        basketSofas.add(value);
    }

    @Override
    public void addTable(Table value) {
        basketTables.add(value);
    }

    @Override
    public ArrayList<Sofa> getSofas() {
        return basketSofas;
    }

    @Override
    public ArrayList<Table> getTables() {
        return basketTables;
    }

    @Override
    public void deleteSofas(int value) {
        this.basketSofas.remove(value);
    }

    @Override
    public void deleteTables(int value) {
        this.basketTables.remove(value);
    }
}
