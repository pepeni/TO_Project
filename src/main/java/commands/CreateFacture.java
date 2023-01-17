package commands;

import database.BasketProxy;
import facture.CompanyInformation;
import facture.Director;
import facture.Facture;
import facture.FactureBuilder;
import furniture_production.furnitures.ModernSofa;
import furniture_production.furnitures.ModernTable;
import furniture_production.furnitures.TraditionalSofa;
import furniture_production.furnitures.TraditionalTable;
import subscription.CollectObserver;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.System.exit;

public class CreateFacture implements Command {

    BasketProxy basket;
    CollectObserver collectObserver = new CollectObserver();
    ModernSofa modernSofa = new ModernSofa();
    TraditionalSofa traditionalSofa = new TraditionalSofa();
    ModernTable modernTable = new ModernTable();
    TraditionalTable traditionalTable = new TraditionalTable();
    Facture facture;

    public CreateFacture(BasketProxy basket) {
        this.basket = basket;
    }


    @Override
    public void execute() {
        boolean facture = true;
        Scanner myObj = new Scanner(System.in);

        System.out.println("Zanim wygenerujesz fakture:");
        System.out.println("Sprawdź czy na pewno wszystko jest dobrze.\n");

        if (basket.getSofas().stream().noneMatch(o -> o instanceof ModernSofa)) {

            collectObserver.subscribe(modernSofa);
        } else {
            collectObserver.unsubscribe(modernSofa);
        }
        if (basket.getSofas().stream().noneMatch(o -> o instanceof TraditionalSofa)) {

            collectObserver.subscribe(traditionalSofa);
        } else {
            collectObserver.unsubscribe(traditionalSofa);
        }
        if (basket.getTables().stream().noneMatch(o -> o instanceof ModernTable)) {

            collectObserver.subscribe(modernTable);
        } else {
            collectObserver.unsubscribe(modernTable);
        }
        if (basket.getTables().stream().noneMatch(o -> o instanceof TraditionalTable)) {

            collectObserver.subscribe(traditionalTable);
        } else {
            collectObserver.unsubscribe(traditionalTable);
        }
        collectObserver.notifyObservers();
        while (facture) {
            System.out.println("\nKomendy:\n\tprywatna - stworz fakture dla osoby prywatnej\n\tfirma - stworz fakture dla firmy\n\twyjdz - konczy tryb faktury");
            String choice = myObj.nextLine();

            if (Objects.equals(choice.toLowerCase(), "wyjdz")) {
                facture = false;
            }
            if (Objects.equals(choice.toLowerCase(), "prywatna")) {
                makePersonalFacture();
                exit(0);
            }
            if (Objects.equals(choice.toLowerCase(), "firma")) {
                makeCompanyFacture();
                exit(0);
            }
        }
    }

    public void makePersonalFacture() {
        Director director = new Director();
        FactureBuilder builder = new FactureBuilder(basket.getTables(), basket.getSofas());
        Scanner myObj = new Scanner(System.in);
        System.out.println("Podaj Imię i Nazwisko:");
        String name = myObj.nextLine();
        System.out.println("Podaj adres (ulica numer budynku):");
        String address = myObj.nextLine();
        System.out.println("Podaj kod pocztowy i miasto:");
        String postCode = myObj.nextLine();
        director.constructPrivateFacture(builder, name, address, postCode);
        this.facture = builder.getFacture();
        facture.generateFacture();
    }

    public void makeCompanyFacture() {
        boolean correctNip = true;
        Director director = new Director();
        FactureBuilder builder = new FactureBuilder(basket.getTables(), basket.getSofas());
        Scanner myObj = new Scanner(System.in);
        System.out.println("Podaj nazwe firmy:");
        String name = myObj.nextLine();
        System.out.println("Podaj adres (ulica numer budynku):");
        String address = myObj.nextLine();
        System.out.println("Podaj kod pocztowy i miasto:");
        String postCode = myObj.nextLine();
        while (correctNip) {
            System.out.println("Podaj NIP firmy:");
            String NIP = myObj.nextLine();
            if (Pattern.matches("\\d{10}", NIP)) {
                CompanyInformation companyInformation = CompanyInformation.getInstance(NIP);
                director.constructCompanyFacture(builder, name, companyInformation, address, postCode);
                correctNip = false;
            } else {
                System.out.println("Podałeś niepoprawny numer NIP.");
            }
        }
        this.facture = builder.getFacture();
        facture.generateFacture();
    }

    public CollectObserver getCollectObserver() {
        return this.collectObserver;
    }

    public Facture getFacture() {
        return this.facture;
    }
}
