package furnitures_production.factories;

import furnitures_production.furnitures.Sofa;
import furnitures_production.furnitures.Table;

public interface FurnituresFactory {
    Table createTable(String style, String type, String shape);
    Sofa createSofa(String style, int numberOfSeats);
     void showPossibilities();
}
