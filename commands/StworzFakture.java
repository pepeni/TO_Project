package commands;

import database.KoszykProxy;

public class StworzFakture implements Command {

    KoszykProxy koszyk;

    public StworzFakture(KoszykProxy koszyk){
        this.koszyk = koszyk;
    };

    @Override
    public void execute() {
        System.out.println("Stworz fakture :)");
    }
}
