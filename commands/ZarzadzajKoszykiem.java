package commands;

import database.KoszykProxy;
import furnitures_production.factories.*;
import furnitures_production.furnitures.ModernTable;
import furnitures_production.furnitures.Sofa;
import furnitures_production.furnitures.Table;
import furnitures_production.styles.GreekStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ZarzadzajKoszykiem implements Command {

    KoszykProxy koszyk;

    public ZarzadzajKoszykiem(KoszykProxy koszyk){
        this.koszyk = koszyk;
    };

    @Override
    public void execute() {
        boolean zarzadzanie = true;
        Scanner myObj = new Scanner(System.in);
        while (zarzadzanie){


            System.out.println("\nKomendy:\n\tdodaj do koszyka - przejdz do trybu wyboru mebli\n\tusun z koszyka - przejdz do trybu usuwania mebli z koszyka\n\twyjdz - konczy tryb zarzadzania koszykiem");
            String wybor = myObj.nextLine();

            if(Objects.equals(wybor, "wyjdz")){zarzadzanie = false;}
            if(Objects.equals(wybor, "dodaj do koszyka")){ dodawania_do_koszyka(); }
            if(Objects.equals(wybor, "usun z koszyka")){ usuwanie_z_koszyka(); }
        }
    }

    public void dodawania_do_koszyka(){
        boolean dodawanie = true;
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nCo chcesz wybierać?");

        while(dodawanie){
            System.out.println("\nsofy - przejdź do wyboru sofy\nstoly - przedź do wyboru stołów\nwyjdz - wyjdź");
            String wybor = myObj.nextLine();
            if(Objects.equals(wybor, "wyjdz")){dodawanie = false;}
            if(Objects.equals(wybor, "sofy")){ wybor_sof(); }
            if(Objects.equals(wybor, "stoly")){ wybor_stolow(); }
        }

    }

    public void wybor_sof(){
        boolean dodawanie = true;
        Scanner myObj = new Scanner(System.in);
        ModernFurnituresFactory modernFurnituresFactory = new ModernFurnituresFactory();
        TraditionalFurnituresFactory traditionalFurnituresFactory = new TraditionalFurnituresFactory();

        System.out.println("\nWpisz poprawnie nazwy przedmiotów, które chcesz dodać do koszyka\nwyjdz - wyjdź z tego trybu");
        System.out.println("\nsofy:\n");
        //Tutaj chciałbym wypisać wszystkie dostępne możliwości z instrukcją jak wpisać komendy
        while(dodawanie){
            String wybor = myObj.nextLine();
            if(Objects.equals(wybor, "wyjdz")){dodawanie = false;}
            //Tutaj obsługa tych komend i dodanie do koszyka przykład:
            /*else if(Objects.equals(wybor, "1")){
                koszyk.add_sofa(modernFurnituresFactory.createSofa("French", "3"));
                System.out.println("pomyślnie dodano sofę :)");
            }*/
        }
    }

    public void wybor_stolow(){
        boolean dodawanie = true;
        Scanner myObj = new Scanner(System.in);
        ModernFurnituresFactory modernFurnituresFactory = new ModernFurnituresFactory();
        TraditionalFurnituresFactory traditionalFurnituresFactory = new TraditionalFurnituresFactory();

        System.out.println("\nWpisz poprawnie nazwy przedmiotów, które chcesz dodać do koszyka\nwyjdz - wyjdź z tego trybu");
        System.out.println("\nstoly:\n");
        //Tutaj chciałbym wypisać wszystkie dostępne możliwości z instrukcją jak wpisać komendy
        while(dodawanie){
            String wybor = myObj.nextLine();
            if(Objects.equals(wybor, "wyjdz")){dodawanie = false;}
            //Tutaj obsługa tych komend i dodanie do koszyka przykład:
            /*else if(Objects.equals(wybor, "1")){
                koszyk.add_stol(modernFurnituresFactory.createTable("French", "dining table", "rectangular"));
                System.out.println("pomyślnie dodano stół :)");
            }*/
        }

    }

    public void usuwanie_z_koszyka(){
        ArrayList<Sofa> sofy = koszyk.getSofy();
        ArrayList<Table> stoly = koszyk.getStoly();

        boolean wyrzucanie = true;
        Scanner myObj = new Scanner(System.in);


        while(wyrzucanie) {
            System.out.println("\n\nWpisz poprawnie indeks pezedmiotu, który chcesz usunąć z koszyka\nAby wyjść wpisz: 0\n");
            int id = 1;

            for(Sofa sofa: sofy){
                System.out.println(id + " " + sofa.getInformationAboutSofa());
                id+=1;
            }
            for(Table table: stoly){
                System.out.println(id + " " + table.getInformationAboutTable());
                id+=1;
            }

            int wybor = Integer.parseInt(myObj.nextLine());
            if(Objects.equals(wybor, 0)){wyrzucanie = false;}
            else if(wybor-1<sofy.size()){
                koszyk.deleteSofy(wybor-1);
                System.out.println("\nWyrzucono pomyślnie :)");
            }
            else if(wybor-sofy.size()-1<stoly.size()){
                koszyk.deleteStoly(wybor-sofy.size()-1);
                System.out.println("\nWyrzucono pomyślnie :)");
            }
            else{
                System.out.println("Wpisano zły indeks");
            }
        }
    }
}
