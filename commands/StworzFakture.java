package commands;

import database.KoszykProxy;
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

public class StworzFakture implements Command {

    KoszykProxy koszyk;
    CollectObserver collectObserver = new CollectObserver();
    ModernSofa modernSofa = new ModernSofa();
    TraditionalSofa traditionalSofa = new TraditionalSofa();
    ModernTable modernTable = new ModernTable();
    TraditionalTable traditionalTable = new TraditionalTable();

    public StworzFakture(KoszykProxy koszyk) {
        this.koszyk = koszyk;
    }


    @Override
    public void execute() {
        boolean facture = true;
        Scanner myObj = new Scanner(System.in);

        System.out.println("Zanim wygenerujesz fakture:");

        if(koszyk.getSofy().stream().noneMatch(o -> o instanceof ModernSofa)){

            collectObserver.subscribe(modernSofa);
        } else {
            collectObserver.unsubscribe(modernSofa);
        }
        if(koszyk.getSofy().stream().noneMatch(o -> o instanceof TraditionalSofa)){

            collectObserver.subscribe(traditionalSofa);
        } else {
            collectObserver.unsubscribe(traditionalSofa);
        }
        if(koszyk.getSofy().stream().noneMatch(o -> o instanceof ModernTable)){

            collectObserver.subscribe(modernTable);
        } else {
            collectObserver.unsubscribe(modernTable);
        }
        if(koszyk.getSofy().stream().noneMatch(o -> o instanceof TraditionalTable)){

            collectObserver.subscribe(traditionalTable);
        } else {
            collectObserver.unsubscribe(traditionalTable);
        }
        collectObserver.notifyObservers();
        while (facture) {
            System.out.println("\nKomendy:\n\tprywatna - stworz fakture dla osoby prywatnej\n\tfirma - stworz fakture dla firmy\n\twyjdz - konczy tryb faktury");
            String wybor = myObj.nextLine();

            if (Objects.equals(wybor, "wyjdz")) {
                facture = false;
            }
            if (Objects.equals(wybor, "prywatna")) {
                makePersonalFacture();
            }
            if (Objects.equals(wybor, "firma")) {
                makeCompanyFacture();
            }
        }
    }

    public void makePersonalFacture() {
        Director director = new Director();
        FactureBuilder builder = new FactureBuilder(koszyk.getStoly(), koszyk.getSofy());
        Scanner myObj = new Scanner(System.in);
        System.out.println("Podaj Imię i Nazwisko:");
        String name = myObj.nextLine();
        System.out.println("Podaj adres (ulica numer budynku):");
        String address = myObj.nextLine();
        System.out.println("Podaj kod pocztowy i miasto:");
        String postCode = myObj.nextLine();
        director.constructPrivateFacture(builder, name, address, postCode);
        Facture facture = builder.getFacture();
        facture.generateFacture();
        exit(0);
    }

    public void makeCompanyFacture() {
        boolean correctNip = true;
        Director director = new Director();
        FactureBuilder builder = new FactureBuilder(koszyk.getStoly(), koszyk.getSofy());
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
        Facture facture = builder.getFacture();
        facture.generateFacture();
        exit(0);
    }
}
