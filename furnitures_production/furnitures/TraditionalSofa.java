package furnitures_production.furnitures;

import furnitures_production.styles.Style;

import java.util.HashSet;

public class TraditionalSofa implements Sofa{

    Style style;
    float price = 258;
    int numberOfSeats;
    public static final boolean sleeperSofa=false;

    HashSet<String> possibleStyle;
    HashSet<Integer> possibleNumberOfSeats;

    public TraditionalSofa() {
        possibleNumberOfSeats= new HashSet<>();
        possibleNumberOfSeats.add(3);
        possibleNumberOfSeats.add(7);
        possibleStyle=new HashSet<String>();
        possibleStyle.add("French");

    }
    @Override
    public void setStyle(Style style) {
        if (possibleStyle.contains(style.getName()))
            this.style = style;
        else
            throw new IllegalArgumentException();
    }
    @Override
    public void setNumberOfSeats(int numberOfSeats) {
        if(possibleNumberOfSeats.contains(numberOfSeats))
            this.numberOfSeats = numberOfSeats;
        else
            throw new IllegalArgumentException();
    }
    @Override
    public void showInformationAboutSofa()
    {
        System.out.println("Traditional Sofa");
        System.out.println("Possible number of seats");
        possibleNumberOfSeats.forEach(p-> System.out.print(p+", "));
        System.out.println();
        System.out.println("SleeperSofa");
        System.out.println(sleeperSofa ? "yes" : "no");
        System.out.println("Possible styles");
        possibleStyle.forEach(p-> System.out.print(p+", "));
        System.out.println();

    }
    public String getInformationAboutSofa()
    {
        return "Traditional Sofa: "+"    price: "+price+"     number of seats: "+numberOfSeats+ "     style: "+style.getName()+"     sleeper sofa: "+ sleeperSofa;
    }

    @Override
    public HashSet<String> getPossibleStyles() {
        return possibleStyle;
    }
    @Override
    public void  getDetailsAboutStyle()
    {
        style.getDescriptionForSofa();
    }
    @Override
    public double getPrice() {
        return price;
    }
}
