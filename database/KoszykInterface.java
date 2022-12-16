package database;

import furnitures_production.furnitures.Furniture;

import java.util.HashMap;
import java.util.List;

public interface KoszykInterface {
    public void add(Furniture value);
    public HashMap<Integer,Furniture> get();
    public void delete(int value);
}
