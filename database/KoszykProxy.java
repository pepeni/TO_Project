package database;

import database.Koszyk;
import database.KoszykInterface;
import furnitures_production.furnitures.Furniture;

import java.util.HashMap;
import java.util.List;

public class KoszykProxy implements KoszykInterface {
    private Koszyk db;

    public KoszykProxy(Koszyk db) {
        this.db = db;
    }

    public void add(Furniture value) {
        // add caching or logging functionality here
        this.db.add(value);
    }

    public HashMap<Integer,Furniture> get() {
        // add caching or logging functionality here
        return this.db.get();
    }

    public void delete(int value) {
        // add caching or logging functionality here
        this.db.delete(value);
    }
}
