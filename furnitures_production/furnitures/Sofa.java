package furnitures_production.furnitures;

import furnitures_production.styles.Style;

import java.util.HashSet;

public interface Sofa extends Furniture {

    void setNumberOfSeats(int numberOfSeats);
    void getInformationAboutSofa();

    void setStyle(Style style);
    HashSet<String> getPossibleStyles();
    void  getDetailsAboutStyle();
}
