package furniture_production.factories;

import furniture_production.furnitures.*;
import furniture_production.styles.FrenchStyle;
import furniture_production.styles.GreekStyle;
import furniture_production.styles.Style;

import java.util.Objects;

public class TraditionalFurnituresFactory implements  FurnituresFactory {
    TraditionalSofa traditionalSofa;
    TraditionalTable traditionalTable;

    public TraditionalFurnituresFactory() {
        this.traditionalSofa = new TraditionalSofa();
        this.traditionalTable = new TraditionalTable();
    }

    @Override
    public Sofa createSofa( String style, int numberOfSeats) {

            traditionalSofa.setStyle(getChoosenStyle(style));
            traditionalSofa.setNumberOfSeats(numberOfSeats);
            return traditionalSofa;

    }
    public void getDetailsAboutSofaStyle(String style)
    {
        traditionalSofa.setStyle(getChoosenStyle(style));
        traditionalSofa.getDetailsAboutStyle();
    }
    @Override
    public Table createTable(String style, String type, String shape) {
        traditionalTable.setStyle(getChoosenStyle(style));
        traditionalTable.setTypeOfTable(type);
        traditionalTable.setShapeOfTable(shape);
        return traditionalTable;
    }
    public void getDetailsAboutTableStyle(String style)
    {
        traditionalTable.setStyle(getChoosenStyle(style));
        traditionalTable.getDetailsAboutStyle();
    }

    @Override
    public void showSofaOptions()
    {
        traditionalSofa.showInformationAboutSofa();
        System.out.println();

    }
    public void showTableOptions()
    {
        traditionalTable.showInformationAboutTable();
        System.out.println();
    }
    public Style getChoosenStyle(String s)
    {
        if(Objects.equals(s, "Greek"))
        {
            return new GreekStyle();
        } else if (Objects.equals(s, "French")) {
            return new FrenchStyle();
        }
        else
            throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        TraditionalFurnituresFactory factory= new TraditionalFurnituresFactory();
        factory.showSofaOptions();
        factory.createSofa("French", 3);
        factory.getDetailsAboutSofaStyle("French");
        factory.createTable("French", "coffe table", "rectangular");
        factory.getDetailsAboutTableStyle("French");
    }
}
