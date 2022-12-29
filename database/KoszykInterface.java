package database;

import furniture_production.furnitures.Sofa;
import furniture_production.furnitures.Table;

import java.util.ArrayList;

public interface KoszykInterface {
    void add_sofa(Sofa value);

    void add_stol(Table value);

    ArrayList<Sofa> getSofy();

    ArrayList<Table> getStoly();

    void deleteSofy(int value);

    void deleteStoly(int value);
}
