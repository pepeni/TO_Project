package furniture_production.furnitures;

import furniture_production.styles.Style;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TraditionalSofa implements Sofa {

    Style style;
    float price = 258;
    int numberOfSeats;
    public static final boolean sleeperSofa = false;

    HashSet<String> possibleStyle;
    HashSet<Integer> possibleNumberOfSeats;

    public TraditionalSofa() {
        possibleNumberOfSeats = new HashSet<>(Arrays.asList(3, 7));
        possibleStyle = new HashSet<>(List.of("French"));
    }

    @Override
    public void setStyle(Style style) {
        if (possibleStyle.contains(style.getName()))
            this.style = style;
        else
            throw new IllegalArgumentException("Podano bledny styl");
    }

    @Override
    public void setNumberOfSeats(int numberOfSeats) {
        if (possibleNumberOfSeats.contains(numberOfSeats))
            this.numberOfSeats = numberOfSeats;
        else
            throw new IllegalArgumentException("Podano bledna ilosc siedzen");
    }

    @Override
    public void showInformationAboutSofa() {
        System.out.println("Nazwa:   Traditional Sofa");
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
        return "Traditional Sofa: " + "    cena: " + price + "     liczba siedzen: " + numberOfSeats + "     styl: " + style.getName() + "     mozliwosc spania: " + sleeperSofa;
    }

    @Override
    public void newsletter() {
        System.out.println("W ofercie posiadamy również Traditional Sofa");
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
        return "Traditional Sofa. " + style.getName() + ", Seats: " + numberOfSeats + ", Sleeper Sofa: " + sleeperSofa;
    }
}
