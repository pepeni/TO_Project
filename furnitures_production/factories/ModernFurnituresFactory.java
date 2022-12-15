package furniture_production.factories;

import furniture_production.furnitures.*;
import furniture_production.styles.FrenchStyle;
import furniture_production.styles.GreekStyle;
import furniture_production.styles.Style;


public class ModernFurnituresFactory implements FurnituresFactory {
    ModernSofa modernSofa;
    ModernTable modernTable;


    public ModernFurnituresFactory() {
        this.modernSofa = new ModernSofa();
        this.modernTable = new ModernTable();
    }

    public Sofa createSofa(String style, int numberOfSeats) {

        modernSofa.setStyle(getChoosenStyle(style));
        modernSofa.setNumberOfSeats(numberOfSeats);
        return modernSofa;
    }

    public void getDetailsAboutSofaStyle(String style)
    {
        modernSofa.setStyle(getChoosenStyle(style));
        modernSofa.getDetailsAboutStyle();
    }


    public Table createTable(String style, String type, String shape) {
        modernTable.setStyle(getChoosenStyle(style));
        modernTable.setTypeOfTable(type);
        modernTable.setShapeOfTable(shape);
        return modernTable;
    }
    public void getDetailsAboutTableStyle(String style)
    {
        modernTable.setStyle(getChoosenStyle(style));
        modernTable.getDetailsAboutStyle();
    }

    public void showPossibilities() {
        modernSofa.getInformationAboutSofa();
        System.out.println();
        modernTable.getInformationAboutTable();
        System.out.println();

    }


    public Style getChoosenStyle(String s)
    {
        if(s=="Greek")
        {
            return new GreekStyle();
        } else if (s=="French") {
            return new FrenchStyle();
        }
        else
            throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        ModernFurnituresFactory factory= new ModernFurnituresFactory();
        factory.showPossibilities();
        factory.createSofa("Greek", 2);
        factory.getDetailsAboutSofaStyle("Greek");
        factory.createTable("Greek", "accent table", "circle");
        factory.getDetailsAboutTableStyle("Greek");
    }

}
