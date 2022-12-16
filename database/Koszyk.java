package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import furnitures_production.furnitures.Furniture;


public class Koszyk implements KoszykInterface {
    private static Koszyk instance;
    private HashMap<Integer,Furniture> koszyk;
    private int id;

    private Koszyk() {
        // initialize database
        this.koszyk = new HashMap<>();
    }

    public static Koszyk getInstance() {
        if (instance == null) {
            instance = new Koszyk();
        }
        return instance;
    }

    public void add(Furniture value) {
        this.koszyk.put(id,value);
        id+=1;
    }

    public HashMap<Integer,Furniture> get() {
        return this.koszyk;
    }

    public void delete(int value) {
        this.koszyk.remove(value);
    }
}
