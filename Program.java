import commands.ShowBasket;
import commands.CreateFacture;
import commands.ManageBasket;
import database.Basket;
import database.BasketProxy;

import java.util.Objects;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Basket koszyk = Basket.getInstance();
        BasketProxy koszykProxy = new BasketProxy(koszyk);

        System.out.println("Witamy w naszym sklepie meblowym \"Sofy i Stoły\"");
        Scanner myObj = new Scanner(System.in);
        boolean program = true;

        while (program) {
            System.out.println("\nPoruszaj się po programie za pomocą następujących komend:\n\tzarzadzaj - Przejdź w tryb wyboru i usuwania mebli\n\tkoszyk - sprawdź zawartość koszyka\n\tfaktura - Swtórz fakturę\n\tzamknij - Zakoncz Program");

            System.out.println("\nCo chcesz zrobić?");
            String wybor = myObj.nextLine();
            if (Objects.equals(wybor, "zarzadzaj")) {
                new ManageBasket(koszykProxy).execute();
            } else if (Objects.equals(wybor, "koszyk")) {
                new ShowBasket(koszykProxy).execute();
            } else if (Objects.equals(wybor, "faktura")) {
                new CreateFacture(koszykProxy).execute();
            } else if (Objects.equals(wybor, "zamknij")) {
                program = false;
            }
        }

    }


}
