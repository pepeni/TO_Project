package furniture_production.factories;

import furniture_production.furniture.Sofa;
import furniture_production.furniture.Table;

public interface FurnitureFactory {
    Table createTable(String style, String type, String shape);
    Sofa createSofa(String style, int numberOfSeats);
     void showPossibilities();
}
