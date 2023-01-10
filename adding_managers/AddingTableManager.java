package adding_managers;

import database.BasketProxy;
import furniture_production.furnitures.Table;

import java.util.Objects;

public class AddingTableManager extends AddingManager {
    Table table;

    public AddingTableManager(BasketProxy basket) {
        super(basket);
    }

    @Override
    public void showInformation() {
        System.out.println("\nstoly:\n");
        modernFurnitureFactory.showTableOptions();
        traditionalFurnitureFactory.showTableOptions();
        showInstruction();

    }

    @Override
    public void createFurniture(String option) {
        if (!Objects.equals(option.toLowerCase(), "modern table") && !Objects.equals(option.toLowerCase(), "traditional table"))
            return;
        System.out.println("Podaj styl:");
        String style = myObj.nextLine();
        System.out.println("Podaj rodzaj:");
        String type = myObj.nextLine();
        System.out.println("Podaj ksztalt:");
        String shape = myObj.nextLine();
        try {
            if (option.equalsIgnoreCase("modern table"))
                table = modernFurnitureFactory.createTable(style, type, shape);
            if (option.equalsIgnoreCase("traditional table"))
                table = traditionalFurnitureFactory.createTable(style, type, shape);
            System.out.println("Twoj produkt:");
            System.out.println(table.getInformationAboutTable());
            System.out.println(table.getDetailsAboutStyle());
            System.out.println("Dodano pomyślnie");
        } catch (Exception e) {
            System.out.println("Nie udało się dodać");

        }

    }

    @Override
    public void addFurniture() {
        basket.addTable(table);
    }


}
