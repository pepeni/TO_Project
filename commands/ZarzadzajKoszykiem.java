package commands;

import database.KoszykProxy;
import furnitures_production.factories.*;
import furnitures_production.furnitures.Furniture;
import furnitures_production.furnitures.ModernTable;
import furnitures_production.styles.GreekStyle;

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
        ModernFurnituresFactory modernFurnituresFactory = new ModernFurnituresFactory();
        TraditionalFurnituresFactory traditionalFurnituresFactory = new TraditionalFurnituresFactory();
        koszyk.add(modernFurnituresFactory.createTable("Greek", "dinning table", "circle"));
        koszyk.add(traditionalFurnituresFactory.createSofa("French", 3));
        System.out.println(koszyk.get().get(0));
        System.out.println(koszyk.get().get(1));
    }

    public void usuwanie_z_koszyka(){}
}
