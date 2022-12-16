package furnitures_production.furnitures;

import furnitures_production.styles.Style;

import java.util.HashSet;

public class ModernTable implements  Table{

    Style style;
    String typeOfTable;
    String shape;
    float price = 124;
    HashSet<String> possibleStyle;
    HashSet<String> possibleTypesOfTable;
    HashSet<String> possibleShapesOfTable;
    public ModernTable() {
        possibleShapesOfTable=new HashSet<>();
        possibleShapesOfTable.add("rectangular");
        possibleShapesOfTable.add("circle");
        possibleShapesOfTable.add("square");
        possibleStyle=new HashSet<>();
        possibleStyle.add("Greek");
        possibleStyle.add("French");
        possibleTypesOfTable=new HashSet<>();
        possibleTypesOfTable.add("accent table");
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

    public  void getInformationAboutTable()
    {
        System.out.println("Modern Table");
        System.out.println("Shapes:");
        possibleShapesOfTable.forEach(p-> System.out.print(p+", "));
        System.out.println();
        System.out.println("Types:");
        possibleTypesOfTable.forEach(p-> System.out.print(p+", "));
        System.out.println();
        System.out.println("Possible styles:");
        possibleStyle.forEach(p-> System.out.print(p+", "));
        System.out.println();
    }

    @Override
    public HashSet<String> getPossibleStyles() {
        return  possibleStyle;
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
