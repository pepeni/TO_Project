package furniture_production.factories;

import furniture_production.furnitures.Sofa;
import furniture_production.furnitures.Table;

public interface FurnituresFactory {
    Table createTable(String style, String type, String shape);
    Sofa createSofa(String style, int numberOfSeats);
     void showSofaOptions();
     void showTableOptions();
}
