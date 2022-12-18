package database;

import furniture_production.furnitures.Sofa;
import furniture_production.furnitures.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface KoszykInterface {
    public void add_sofa(Sofa value);
    public void add_stol(Table value);
    public ArrayList<Sofa> getSofy();
    public ArrayList<Table> getStoly();
    public void deleteSofy(int value);
    public void deleteStoly(int value);
}
