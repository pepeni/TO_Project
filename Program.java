import java.util.Scanner;

public class Program {
    Koszyk koszyk = Koszyk.getInstance();
    KoszykProxy koszykProxy = new KoszykProxy(koszyk);

    public static void main(String[] args) {

        System.out.println("Witamy w naszym sklepie meblowym\nPoruszaj się po nim za pomocą następujących komend:\n\tdodaj mebel - Przejdź w tryb wyboru mebli\n\tzamknij - Zakoncz Program");
        Scanner myObj = new Scanner(System.in);
        boolean program = true;

        while (program){

            System.out.println("\nCo chcesz zrobić?");
            String wybor = myObj.nextLine();

            if(wybor == "zamknij"){program = false;}
            if(wybor == "dodaj mebel"){}
        }

    }


}
