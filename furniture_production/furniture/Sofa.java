package furniture_production.furniture;

import furniture_production.styles.Style;

import java.util.HashSet;

public interface Sofa {

    void setNumberOfSeats(int numberOfSeats);
    void getInformationAboutSofa();

    void setStyle(Style style);
    HashSet<String> getPossibleStyles();
    void  getDetailsAboutStyle();
}
