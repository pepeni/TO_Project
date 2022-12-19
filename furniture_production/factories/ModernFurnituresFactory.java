package furniture_production.factories;

import furniture_production.furnitures.*;
import furniture_production.styles.FrenchStyle;
import furniture_production.styles.GreekStyle;
import furniture_production.styles.Style;

import java.util.Objects;


public class ModernFurnituresFactory implements FurnituresFactory {
    ModernSofa modernSofa;
    ModernTable modernTable;


    public ModernFurnituresFactory() {
        this.modernSofa = new ModernSofa();
        this.modernTable = new ModernTable();
    }

    public Sofa createSofa(String style, int numberOfSeats) {
        ModernSofa modernSofa1 = new ModernSofa();
        modernSofa1.setStyle(getChoosenStyle(style));
        modernSofa1.setNumberOfSeats(numberOfSeats);
        return modernSofa1;
    }

    public void getDetailsAboutSofaStyle(String style)
    {
        modernSofa.setStyle(getChoosenStyle(style));
        modernSofa.getDetailsAboutStyle();
    }


    public Table createTable(String style, String type, String shape) {
        ModernTable modernTable1 = new ModernTable();
        modernTable1.setStyle(getChoosenStyle(style));
        modernTable1.setTypeOfTable(type);
        modernTable1.setShapeOfTable(shape);
        return modernTable1;
    }
    public void getDetailsAboutTableStyle(String style)
    {
        modernTable.setStyle(getChoosenStyle(style));
        modernTable.getDetailsAboutStyle();
    }

    public void showSofaOptions() {
        modernSofa.showInformationAboutSofa();
        System.out.println();

    }
    public void showTableOptions()
    {
        modernTable.showInformationAboutTable();
        System.out.println();
    }


    public Style getChoosenStyle(String s)
    {
        if(Objects.equals(s, "Greek"))
        {
            return new GreekStyle();
        }
        else if (Objects.equals(s, "French")) {
            return new FrenchStyle();
        }
        else
            throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        ModernFurnituresFactory factory= new ModernFurnituresFactory();
        factory.showSofaOptions();
        factory.createSofa("Greek", 2);
        factory.getDetailsAboutSofaStyle("Greek");
        factory.createTable("Greek", "accent table", "circle");
        factory.getDetailsAboutTableStyle("Greek");
    }

}
