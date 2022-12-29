package furniture_production.factories;

import furniture_production.furnitures.*;
import furniture_production.styles.FrenchStyle;
import furniture_production.styles.GreekStyle;
import furniture_production.styles.Style;

import java.util.Objects;

public class TraditionalFurnitureFactory implements FurnitureFactory {
    TraditionalSofa traditionalSofa;
    TraditionalTable traditionalTable;

    public TraditionalFurnitureFactory() {
        this.traditionalSofa = new TraditionalSofa();
        this.traditionalTable = new TraditionalTable();
    }

    @Override
    public Sofa createSofa(String style, int numberOfSeats) {
        TraditionalSofa traditionalSofa1 = new TraditionalSofa();
        traditionalSofa1.setStyle(getChosenStyle(style));
        traditionalSofa1.setNumberOfSeats(numberOfSeats);
        return traditionalSofa1;

    }

    public void getDetailsAboutSofaStyle(String style) {
        traditionalSofa.setStyle(getChosenStyle(style));
        traditionalSofa.getDetailsAboutStyle();
    }

    @Override
    public Table createTable(String style, String type, String shape) {
        TraditionalTable traditionalTable1 = new TraditionalTable();
        traditionalTable1.setStyle(getChosenStyle(style));
        traditionalTable1.setTypeOfTable(type.toLowerCase());
        traditionalTable1.setShapeOfTable(shape.toLowerCase());
        return traditionalTable1;
    }

    public void getDetailsAboutTableStyle(String style) {
        traditionalTable.setStyle(getChosenStyle(style));
        traditionalTable.getDetailsAboutStyle();
    }

    @Override
    public void showSofaOptions() {
        traditionalSofa.showInformationAboutSofa();
        System.out.println();

    }

    public void showTableOptions() {
        traditionalTable.showInformationAboutTable();
        System.out.println();
    }

    public Style getChosenStyle(String s) {
        if (Objects.equals(s.toLowerCase(), "greek")) {
            return new GreekStyle();
        } else if (Objects.equals(s.toLowerCase(), "french")) {
            return new FrenchStyle();
        } else
            throw new IllegalArgumentException("Podano bledny styl");
    }
}
