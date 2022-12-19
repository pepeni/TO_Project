package adding_managers;

import database.KoszykProxy;
import furniture_production.furnitures.Table;

import java.util.Objects;

public class AddingTableManager extends AddingManager {
    Table table;

    public AddingTableManager(KoszykProxy basket) {
        super(basket);
    }

    @Override
    public void showInformation()
    {
        System.out.println("\nstoly:\n");
        modernFurnituresFactory.showTableOptions();
        traditionalFurnituresFactory.showTableOptions();
        showInstruction();

    }

    @Override
    public boolean createFurniture(String option) {
        if (!Objects.equals(option, "Modern Table")&& !Objects.equals(option, "Traditional Table"))
            return false;
        System.out.println("Podaj styl:");
        String style=myObj.nextLine();
        System.out.println("Podaj rodzaj:");
        String type=myObj.nextLine();
        System.out.println("Podaj ksztalt:");
        String shape=myObj.nextLine();
        try {
            if (option.equals("Modern Table"))
                table = modernFurnituresFactory.createTable(style, type, shape);
            if (option.equals("Traditional Table"))
                table = traditionalFurnituresFactory.createTable(style, type, shape);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        System.out.println("Twoj produkt:");
        System.out.println(table.getInformationAboutTable());
        System.out.println(table.getDetailsAboutStyle());
        System.out.println("Dodano pomyślnie");
        return true;

    }

    @Override
    public void addFurniture() {
        basket.add_stol(table);
    }


}
