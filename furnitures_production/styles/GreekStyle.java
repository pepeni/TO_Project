package furnitures_production.styles;

public class GreekStyle implements Style {

    public String getName()
    {
        return "Greek";
    }
    public void getDescriptionForSofa()
    { System.out.println("Greek style");
        System.out.println("Colors:");
        System.out.println("white, blue");
        System.out.println("Cover:");
        System.out.println("white and blue strips");
        System.out.println();
    }
    public void getDescriptionForTable()
    {System.out.println("Greek style");
        System.out.println("Colors:");
        System.out.println("white");
        System.out.println("Material:");
        System.out.println("birch");
        System.out.println();
    }


}
