package furnitures_production.furnitures;

import furnitures_production.styles.Style;

import java.util.HashSet;

public interface  Table {

    void showInformationAboutTable();
    String getInformationAboutTable();
    void setStyle(Style style);
    void setShapeOfTable(String shape);
    void setTypeOfTable(String type);
    HashSet<String> getPossibleStyles();
    void  getDetailsAboutStyle();
    double getPrice() ;

}
