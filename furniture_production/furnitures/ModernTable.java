package furniture_production.furnitures;

import furniture_production.styles.Style;

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

    public  void showInformationAboutTable()
    {
        System.out.println("name:   Modern Table");
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
    public  String getDetailsAboutStyle() {
        return style.getDescriptionForTable();
    }
    @Override
    public double getPrice() {
        return price;
    }
    public String getInformationAboutTable()
    {
        return "Modern Table: "+"    price: "+price+"     type of table: "+typeOfTable+ "     style: "+style.getName()+"     shape: "+ shape;
    }

}

