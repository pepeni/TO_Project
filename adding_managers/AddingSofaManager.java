package option_managers;

import database.KoszykProxy;
import furnitures_production.furnitures.Sofa;

import java.util.Objects;

public class SofaOptionManager extends OptionManager{
    Sofa sofa;

    public SofaOptionManager(KoszykProxy basket) {
        super(basket);
    }

    @Override
    public void showInformation()
    {
        showInstruction();
        System.out.println("\nsofy:\n");
        modernFurnituresFactory.showSofaOptions();
        traditionalFurnituresFactory.showSofaOptions();

    }

    @Override
    public void createFurniture(String option) {
        System.out.println("Podaj iluosobowa jest:");
        int number= Integer.parseInt(myObj.nextLine());
        System.out.println("Podaj styl:");
        String style=myObj.nextLine();
        if(Objects.equals(option, "Modern Sofa"))
            this.sofa=modernFurnituresFactory.createSofa(style, number);
        if(Objects.equals(option, "Traditional Sofa"))
            this.sofa=traditionalFurnituresFactory.createSofa(style, number);
        System.out.println("Twój produkt:");
        System.out.println( sofa.getInformationAboutSofa());
        System.out.println(sofa.getDetailsAboutStyle());
        System.out.println("Dodano pomyślnie");
    }

    @Override
    public void addFurniture() {
        basket.add_sofa(sofa);
    }
}
