package commands;

import database.KoszykProxy;
import furnitures_production.furnitures.Sofa;
import furnitures_production.furnitures.Table;

import java.util.ArrayList;

public class PrzegladajKoszyk implements Command{

    KoszykProxy koszyk;

    public PrzegladajKoszyk(KoszykProxy koszyk){
        this.koszyk = koszyk;
    };

    @Override
    public void execute() {

        ArrayList<Sofa> sofy = koszyk.getSofy();
        ArrayList<Table> stoly = koszyk.getStoly();

        int id = 1;

        for(Sofa sofa: sofy){
            System.out.println(id + " " + sofa.getInformationAboutSofa());
            id+=1;
        }
        for(Table table: stoly){
            System.out.println(id + " " + table.getInformationAboutTable());
            id+=1;
        }
    }
}
