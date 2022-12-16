package furnitures_production.furnitures;

import furnitures_production.styles.Style;

import java.util.HashSet;

public interface Sofa {

    void setNumberOfSeats(int numberOfSeats);
    void showInformationAboutSofa();

    void setStyle(Style style);
    HashSet<String> getPossibleStyles();
    void  getDetailsAboutStyle();
    public String getInformationAboutSofa();
}
