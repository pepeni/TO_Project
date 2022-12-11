public class DodajDoKoszyka implements Command{

    KoszykProxy koszyk;

    public DodajDoKoszyka(KoszykProxy koszyk){
        this.koszyk = koszyk;
    };

    @Override
    public void execute() {

    }
}
