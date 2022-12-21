package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import furniture_production.furnitures.Sofa;
import furniture_production.furnitures.Table;


public class Koszyk implements KoszykInterface {
    private static Koszyk instance;
    private ArrayList<Table> koszykStoly;
    private ArrayList<Sofa> koszykSofy;

    private Koszyk() {
        // initialize database
        this.koszykStoly = new ArrayList<>();
        this.koszykSofy = new ArrayList<>();
    }

    public static Koszyk getInstance() {
        if (instance == null) {
            instance = new Koszyk();
        }
        return instance;
    }


    @Override
    public void add_sofa(Sofa value) {
        koszykSofy.add(value);
    }

    @Override
    public void add_stol(Table value) {
        koszykStoly.add(value);
    }

    @Override
    public ArrayList<Sofa> getSofy() {
        return koszykSofy;
    }

    @Override
    public ArrayList<Table> getStoly() {
        return koszykStoly;
    }

    @Override
    public void deleteSofy(int value) {
        this.koszykSofy.remove(value);
    }

    @Override
    public void deleteStoly(int value) {
        this.koszykStoly.remove(value);
    }
}
