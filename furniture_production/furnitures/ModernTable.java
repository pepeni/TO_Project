package furniture_production.furnitures;

import furniture_production.styles.Style;

import java.util.Arrays;
import java.util.HashSet;

public class ModernTable implements Table {

    Style style;
    String typeOfTable;
    String shape;
    float price = 124;
    HashSet<String> possibleStyle;
    HashSet<String> possibleTypesOfTable;
    HashSet<String> possibleShapesOfTable;

    public ModernTable() {
        possibleShapesOfTable = new HashSet<>(Arrays.asList("rectangular", "circle", "square"));
        possibleStyle = new HashSet<>(Arrays.asList("Greek", "French"));
        possibleTypesOfTable = new HashSet<>(Arrays.asList("accent table", "dinning table", "coffee table"));
    }

    @Override
    public void setTypeOfTable(String type) {
        if (possibleTypesOfTable.contains(type))
            this.typeOfTable = type;
        else
            throw new IllegalArgumentException("Podano bledny rodzaj");
    }

    @Override
    public void setStyle(Style style) {
        if (possibleStyle.contains(style.getName()))
            this.style = style;
        else
            throw new IllegalArgumentException("Podano bledny styl");
    }

    @Override
    public void setShapeOfTable(String shape) {
        if (possibleShapesOfTable.contains(shape))
            this.shape = shape;
        else
            throw new IllegalArgumentException("Podano bledny ksztalt");
    }

    public void showInformationAboutTable() {
        System.out.println("Nazwa:   Modern Table");
        System.out.println("Ksztalt:");
        possibleShapesOfTable.forEach(p -> System.out.print(p + ", "));
        System.out.println();
        System.out.println("Rodzaj:");
        possibleTypesOfTable.forEach(p -> System.out.print(p + ", "));
        System.out.println();
        System.out.println("Mozliwe style:");
        possibleStyle.forEach(p -> System.out.print(p + ", "));
        System.out.println();
    }

    @Override
    public void newsletter() {
        System.out.println("W ofercie posiadamy również Modern Table");
    }

    @Override
    public HashSet<String> getPossibleStyles() {
        return possibleStyle;
    }

    @Override
    public String getDetailsAboutStyle() {
        return style.getDescriptionForTable();
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getInformationAboutTable() {
        return "Modern Table: " +  "    cena: " + price + "     rodzaj: " + typeOfTable + "     styl: " + style.getName() + "     ksztalt: " + shape;
    }

    @Override
    public String getInformationForFacture() {
        return "Modern Table. " + typeOfTable + ", " + style.getName() + ", " + shape;
    }

}

