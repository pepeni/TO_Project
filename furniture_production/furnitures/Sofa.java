package furniture_production.furnitures;

import furniture_production.styles.Style;

import java.util.HashSet;

public interface Sofa {

    void setNumberOfSeats(int numberOfSeats);
    void showInformationAboutSofa();
    String getInformationForFacture();
    void setStyle(Style style);
    HashSet<String> getPossibleStyles();
    String  getDetailsAboutStyle();
    String getInformationAboutSofa();
    double getPrice() ;
    void newsletter();
}
