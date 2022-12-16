package furnitures_production.styles;

public class FrenchStyle implements Style {
    public void getDescriptionForSofa()
    {
        System.out.println("French style");
        System.out.println("Colors:");
        System.out.println("green, ecru");
        System.out.println("Cover:");
        System.out.println("floral");
        System.out.println("Wooden elements:");
        System.out.println("dark oak");
        System.out.println();

    }
    public void getDescriptionForTable()
    {
        System.out.println("French style");
        System.out.println("Colors:");
        System.out.println("dark brown");
        System.out.println("Material:");
        System.out.println("oak");
        System.out.println();
    }
    public String getName()
    {
        return "French";
    }
}
