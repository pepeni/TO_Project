package furniture_production.factories;

import furniture_production.furnitures.*;
import furniture_production.styles.FrenchStyle;
import furniture_production.styles.GreekStyle;
import furniture_production.styles.Style;

import java.util.Objects;


public class ModernFurnitureFactory implements FurnitureFactory {
    ModernSofa modernSofa;
    ModernTable modernTable;


    public ModernFurnitureFactory() {
        this.modernSofa = new ModernSofa();
        this.modernTable = new ModernTable();
    }

    public Sofa createSofa(String style, int numberOfSeats) {
        ModernSofa modernSofa1 = new ModernSofa();
        modernSofa1.setStyle(getChosenStyle(style));
        modernSofa1.setNumberOfSeats(numberOfSeats);
        return modernSofa1;
    }

    public void getDetailsAboutSofaStyle(String style) {
        modernSofa.setStyle(getChosenStyle(style));
        modernSofa.getDetailsAboutStyle();
    }


    public Table createTable(String style, String type, String shape) {
        ModernTable modernTable1 = new ModernTable();
        modernTable1.setStyle(getChosenStyle(style));
        modernTable1.setTypeOfTable(type.toLowerCase());
        modernTable1.setShapeOfTable(shape.toLowerCase());
        return modernTable1;
    }

    public void getDetailsAboutTableStyle(String style) {
        modernTable.setStyle(getChosenStyle(style));
        modernTable.getDetailsAboutStyle();
    }

    public void showSofaOptions() {
        modernSofa.showInformationAboutSofa();
        System.out.println();

    }

    public void showTableOptions() {
        modernTable.showInformationAboutTable();
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
