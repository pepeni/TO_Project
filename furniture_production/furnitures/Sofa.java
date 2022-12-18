package furniture_production.furnitures;

import furniture_production.styles.Style;

import java.util.HashSet;

public interface Sofa {

    void setNumberOfSeats(int numberOfSeats);
    void showInformationAboutSofa();

    void setStyle(Style style);
    HashSet<String> getPossibleStyles();
    String  getDetailsAboutStyle();
    public String getInformationAboutSofa();
    double getPrice() ;
}
