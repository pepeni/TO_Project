package adding_managers;

import database.BasketProxy;
import furniture_production.furnitures.Sofa;

import java.util.Objects;

public class AddingSofaManager extends AddingManager {
    Sofa sofa;

    public AddingSofaManager(BasketProxy basket) {
        super(basket);
    }

    @Override
    public void showInformation() {
        System.out.println("\nsofy:\n");
        modernFurnitureFactory.showSofaOptions();
        traditionalFurnitureFactory.showSofaOptions();
        showInstruction();

    }

    @Override
    public void createFurniture(String option) {

        if (!Objects.equals(option.toLowerCase(), "modern sofa") && !Objects.equals(option.toLowerCase(), "traditional sofa"))
            return;
        System.out.println("Podaj iluosobowa jest:");
        int number = 0;
        try {
            number = Integer.parseInt(myObj.nextLine());
        } catch (Exception e) {
            System.out.println("Podano bledna liczbe");
            return;
        }
        System.out.println("Podaj styl:");
        String style = myObj.nextLine();
        try {
            if (option.equals("modern sofa"))
                this.sofa = modernFurnitureFactory.createSofa(style, number);
            if (option.equals("traditional sofa"))
                this.sofa = traditionalFurnitureFactory.createSofa(style, number);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Twój produkt:");
        System.out.println(sofa.getInformationAboutSofa());
        System.out.println(sofa.getDetailsAboutStyle());
        System.out.println("Dodano pomyślnie");
    }

    @Override
    public void addFurniture() {
        basket.addSofa(sofa);
    }
}
