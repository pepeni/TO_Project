package commands;

import database.KoszykProxy;

public class ZarzadzajKoszykiem implements Command {

    KoszykProxy koszyk;

    public ZarzadzajKoszykiem(KoszykProxy koszyk){
        this.koszyk = koszyk;
    };

    @Override
    public void execute() {
        System.out.println("Dodaj meble :)");
    }
}
