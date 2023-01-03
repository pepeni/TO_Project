package database;

import furniture_production.furnitures.Sofa;
import furniture_production.furnitures.Table;

import java.util.ArrayList;


public class BasketProxy implements BasketInterface {
    private Basket db;

    public BasketProxy(Basket db) {
        this.db = db;
    }

    @Override
    public void addSofa(Sofa value) {
        if (value != null) {
            db.addSofa(value);
        }
    }

    @Override
    public void addTable(Table value) {
        if (value != null) {
            db.addTable(value);
        }
    }

    @Override
    public ArrayList<Sofa> getSofas() {
        return db.getSofas();
    }

    @Override
    public ArrayList<Table> getTables() {
        return db.getTables();
    }

    @Override
    public void deleteSofas(int value) {
        this.db.deleteSofas(value);
    }

    @Override
    public void deleteTables(int value) {
        this.db.deleteTables(value);
    }
}
