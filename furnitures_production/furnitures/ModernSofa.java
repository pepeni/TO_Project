package furniture_production.furnitures;

import furniture_production.styles.Style;
import java.util.HashSet;

public class ModernSofa implements Sofa, Furniture{

    Style style;
    int numberOfSeats;
    float price=2000;
    public static final boolean sleeperSofa=true;
    HashSet<String> possibleStyle;
    HashSet<Integer> possibleNumberOfSeats;
    public ModernSofa()
    {   possibleNumberOfSeats= new HashSet<>();
        possibleNumberOfSeats.add(2);
        possibleNumberOfSeats.add(3);
        possibleNumberOfSeats.add(4);
        possibleStyle=new HashSet<>();
        possibleStyle.add("Greek");
        possibleStyle.add("French");
    }

    public void setStyle(Style style) {
        if (possibleStyle.contains(style.getName()))
            this.style = style;
        else
            throw new IllegalArgumentException();
    }

    public void setNumberOfSeats(int numberOfSeats) {
        if(possibleNumberOfSeats.contains(numberOfSeats))
            this.numberOfSeats = numberOfSeats;
        else
            throw new IllegalArgumentException();
    }



    @Override
    public void getInformationAboutSofa()
    {
        System.out.println("Modern Sofa");
        System.out.println("Possible number of seats");
        possibleNumberOfSeats.forEach(p-> System.out.print(p+", "));
        System.out.println();
        System.out.println("SleeperSofa");
        System.out.println(sleeperSofa ? "yes" : "no");
        System.out.println("Possible styles");
        possibleStyle.forEach(p-> System.out.print(p+", "));
        System.out.println();

    }
    @Override
    public HashSet<String> getPossibleStyles()
    {
        return possibleStyle;
    }
    @Override
    public void  getDetailsAboutStyle()
    {
        style.getDescriptionForSofa();
    }

    @Override
    public float getPrice() {
        return price;
    }
}
