package option_managers;

import database.KoszykProxy;
import furnitures_production.furnitures.Table;

import java.util.Objects;

public class TableOptionManager extends OptionManager{
    Table table;

    public TableOptionManager(KoszykProxy basket) {
        super(basket);
    }

    @Override
    public void showInformation()
    {
        showInstruction();
        System.out.println("\nstoly:\n");
        modernFurnituresFactory.showTableOptions();
        traditionalFurnituresFactory.showTableOptions();

    }

    @Override
    public void createFurniture(String option) {
        System.out.println("Podaj styl:");
        String style=myObj.nextLine();
        System.out.println("Podaj rodzaj:");
        String type=myObj.nextLine();
        System.out.println("Podaj ksztalt:");
        String shape=myObj.nextLine();
        if(Objects.equals(option, "Modern Table"))
            table=modernFurnituresFactory.createTable(style,type,shape);
        if(Objects.equals(option, "Traditional Table"))
            table=traditionalFurnituresFactory.createTable(style,type,shape);
        System.out.println("Twoj produkt:");
        System.out.println(table.getInformationAboutTable());
        System.out.println(table.getDetailsAboutStyle());
        System.out.println("Dodano pomyślnie");

    }

    @Override
    public void addFurniture() {
        basket.add_stol(table);
    }


}
