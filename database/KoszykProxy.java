package database;

import database.Koszyk;
import database.KoszykInterface;
import furniture_production.furnitures.Sofa;
import furniture_production.furnitures.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KoszykProxy implements KoszykInterface {
    private Koszyk db;

    public KoszykProxy(Koszyk db) {
        this.db = db;
    }

    @Override
    public void add_sofa(Sofa value) {
        db.add_sofa(value);
    }

    @Override
    public void add_stol(Table value) {
        db.add_stol(value);
    }

    @Override
    public ArrayList<Sofa> getSofy() {
        return db.getSofy();
    }

    @Override
    public ArrayList<Table> getStoly() {
        return db.getStoly();
    }

    @Override
    public void deleteSofy(int value) {
        this.db.deleteSofy(value);
    }

    @Override
    public void deleteStoly(int value) {
        this.db.deleteStoly(value);
    }
}
