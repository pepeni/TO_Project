import commands.PrzegladajKoszyk;
import commands.StworzFakture;
import commands.ZarzadzajKoszykiem;
import database.Koszyk;
import database.KoszykProxy;
import furniture_production.furnitures.ModernSofa;
import furniture_production.furnitures.ModernTable;
import furniture_production.furnitures.TraditionalSofa;
import furniture_production.furnitures.TraditionalTable;
import subscription.CollectObserver;

import java.util.Objects;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Koszyk koszyk = Koszyk.getInstance();
        KoszykProxy koszykProxy = new KoszykProxy(koszyk);

        System.out.println("Witamy w naszym sklepie meblowym \"Sofy i Stoły\"");
        Scanner myObj = new Scanner(System.in);
        boolean program = true;

        while (program) {
            System.out.println("\nPoruszaj się po programie za pomocą następujących komend:\n\tzarzadzaj - Przejdź w tryb wyboru i usuwania mebli\n\tkoszyk - sprawdź zawartość koszyka\n\tfaktura - Swtórz fakturę\n\tzamknij - Zakoncz Program");

            System.out.println("\nCo chcesz zrobić?");
            String wybor = myObj.nextLine();
            if (Objects.equals(wybor, "zarzadzaj")) {
                new ZarzadzajKoszykiem(koszykProxy).execute();
            } else if (Objects.equals(wybor, "koszyk")) {
                new PrzegladajKoszyk(koszykProxy).execute();
            } else if (Objects.equals(wybor, "faktura")) {
                new StworzFakture(koszykProxy).execute();
            } else if (Objects.equals(wybor, "zamknij")) {
                program = false;
            }
        }

    }


}
