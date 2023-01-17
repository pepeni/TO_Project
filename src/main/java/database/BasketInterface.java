package database;

import furniture_production.furnitures.Sofa;
import furniture_production.furnitures.Table;

import java.util.ArrayList;

public interface BasketInterface {
    void addSofa(Sofa value);

    void addTable(Table value);

    ArrayList<Sofa> getSofas();

    ArrayList<Table> getTables();

    void deleteSofas(int value);

    void deleteTables(int value);
}
