import commands.StworzFakture;
import commands.ZarzadzajKoszykiem;
import database.Koszyk;
import database.KoszykProxy;

import java.util.Objects;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Koszyk koszyk = Koszyk.getInstance();
        KoszykProxy koszykProxy = new KoszykProxy(koszyk);

        System.out.println("Witamy w naszym sklepie meblowym\nPoruszaj się po nim za pomocą następujących komend:\n\tdodaj mebel - Przejdź w tryb wyboru mebli\n\tfaktura - Swtórz fakturę\n\tzamknij - Zakoncz Program");
        Scanner myObj = new Scanner(System.in);
        boolean program = true;

        while (program){

            System.out.println("\nCo chcesz zrobić?");
            String wybor = myObj.nextLine();

            if(Objects.equals(wybor, "zamknij")){program = false;}
            if(Objects.equals(wybor, "dodaj mebel")){ new ZarzadzajKoszykiem(koszykProxy).execute(); }
            if(Objects.equals(wybor, "faktura")){ new StworzFakture(koszykProxy).execute(); }
        }

    }


}
