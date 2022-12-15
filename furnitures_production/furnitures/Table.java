package furniture_production.furnitures;

import furniture_production.styles.Style;

import java.util.HashSet;

public interface  Table {

    void getInformationAboutTable();
    void setStyle(Style style);
    void setShapeOfTable(String shape);
    void setTypeOfTable(String type);
    HashSet<String> getPossibleStyles();
    void  getDetailsAboutStyle();

}
