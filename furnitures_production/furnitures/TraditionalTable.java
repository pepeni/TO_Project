package furnitures_production.furnitures;

import furnitures_production.styles.Style;

import java.util.HashSet;

public class TraditionalTable implements Table {
    Style style;
    String typeOfTable;
    float price;
    String shape;
    HashSet<String> possibleStyle;
    HashSet<String> possibleTypesOfTable;
    HashSet<String> possibleShapesOfTable;

    public TraditionalTable() {
        possibleShapesOfTable = new HashSet<>();
        possibleShapesOfTable.add("rectangular");
        possibleShapesOfTable.add("circle");
        possibleStyle = new HashSet<>();
        possibleStyle.add("French");
        possibleTypesOfTable = new HashSet<>();
        possibleTypesOfTable.add("dinning table");
        possibleTypesOfTable.add("coffe table");
    }

    @Override
    public void setTypeOfTable(String type) {
        if (possibleTypesOfTable.contains(type))
            this.typeOfTable = type;
        else
            throw new IllegalArgumentException();
    }

    @Override
    public void setStyle(Style style) {
        if (possibleStyle.contains(style.getName()))
            this.style = style;
        else
            throw new IllegalArgumentException();
    }

    @Override
    public void setShapeOfTable(String shape) {
        if (possibleShapesOfTable.contains(shape))
            this.shape = shape;
        else
            throw new IllegalArgumentException();
    }

    public void getInformationAboutTable() {
        System.out.println("Traditional Table");
        System.out.println("Shapes:");
        possibleShapesOfTable.forEach(p -> System.out.print(p + ", "));
        System.out.println();
        System.out.println("Types:");
        possibleTypesOfTable.forEach(p -> System.out.print(p + ", "));
        System.out.println();
        System.out.println("Possible styles:");
        possibleStyle.forEach(p -> System.out.print(p + ", "));
        System.out.println();

    }

    @Override
    public HashSet<String> getPossibleStyles() {
        return possibleStyle;
    }

    @Override
    public void getDetailsAboutStyle() {
        style.getDescriptionForTable();
    }
    @Override
    public float getPrice() {
        return price;
    }


}

