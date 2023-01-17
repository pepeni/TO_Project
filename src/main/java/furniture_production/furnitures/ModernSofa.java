package furniture_production.furnitures;

import furniture_production.styles.Style;

import java.util.Arrays;
import java.util.HashSet;

public class ModernSofa implements Sofa {

    Style style;
    int numberOfSeats;
    float price = 2000;
    public static final boolean sleeperSofa = true;
    HashSet<String> possibleStyle;
    HashSet<Integer> possibleNumberOfSeats;

    public ModernSofa() {
        possibleNumberOfSeats = new HashSet<>(Arrays.asList(2, 3, 4));
        possibleStyle = new HashSet<>(Arrays.asList("Greek", "French"));
    }

    public void setStyle(Style style) {
        if (possibleStyle.contains(style.getName()))
            this.style = style;
        else
            throw new IllegalArgumentException("Podano bledny styl");
    }

    public void setNumberOfSeats(int numberOfSeats) {
        if (possibleNumberOfSeats.contains(numberOfSeats))
            this.numberOfSeats = numberOfSeats;
        else
            throw new IllegalArgumentException("Podano bledna ilosc siedzen");
    }


    @Override
    public void newsletter() {
        System.out.println("W ofercie posiadamy również Modern Sofa");
    }

    @Override
    public void showInformationAboutSofa() {
        System.out.println("Nazwa:   Modern Sofa");
        System.out.println("Mozliwa ilosc siedzen:");
        possibleNumberOfSeats.forEach(p -> System.out.print(p + ", "));
        System.out.println();
            System.out.println("Mozliwosc spania:");
        System.out.println(sleeperSofa ? "tak" : "nie");
        System.out.println("Mozliwe style:");
        possibleStyle.forEach(p -> System.out.print(p + ", "));
        System.out.println();

    }

    public String getInformationAboutSofa() {
        return "Modern Sofa: " +  "    cena: " + price + "     liczba siedzen: " + numberOfSeats + "     styl: " + style.getName() + "     mozliwosc spania: " + sleeperSofa;
    }

    @Override
    public HashSet<String> getPossibleStyles() {
        return possibleStyle;
    }

    @Override
    public String getDetailsAboutStyle() {
        return style.getDescriptionForSofa();
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getInformationForFacture() {
        return "Modern Sofa. " + style.getName() + ", Seats: " + numberOfSeats + ", Sleeper Sofa: " + sleeperSofa;
    }
}
