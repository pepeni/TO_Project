package facture;

import furniture_production.furnitures.Sofa;
import furniture_production.furnitures.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Facture {
    LocalDate date;
    final static String vendorName = "MebleX sp.z.o.o";
    final static String vendorAddress = "ul. Warszawska 24";
    final static String vendorPostCode = "31-155 Kraków";
    final static String vendorNIP = "8888888888";
    String customer;
    String customerAddress;
    String customerPostCode;
    int factureNumber;
    CompanyInformation NIP;
    ArrayList<Table> tables;
    ArrayList<Sofa> sofas;
    float totalPrice;

    public Facture(ArrayList<Table> tables, ArrayList<Sofa> sofas) {
        this.tables = tables;
        this.sofas = sofas;
        this.date = LocalDate.now();
        this.factureNumber = (int) (Math.random() * (901) + 100);
    }

    public void setCustomer(String name) {
        this.customer = name;
    }

    public void setNIP(CompanyInformation NIP) {
        this.NIP = NIP;
    }

    public void setCustomerAddress(String address) {
        this.customerAddress = address;
    }

    public void setCustomerPostCode(String postCode) {
        this.customerPostCode = postCode;
    }

    public void generateFacture() {
        int id = 0;
        System.out.println(new String(new char[100]).replace("\0", "-"));
        System.out.printf("|%-47S %50S|%n", "Faktura Nr." + factureNumber, "Kraków, " + date);
        System.out.println(new String(new char[100]).replace("\0", "-"));
        System.out.printf("|%-55S   %40S|%n", "Sprzedawca:", "Nabywca:");
        System.out.printf("|%-55s   %40s|%n", vendorName, customer);
        System.out.printf("|%-55s   %40s|%n", vendorAddress, customerAddress);
        System.out.printf("|%-55s   %40s|%n", vendorPostCode, customerPostCode);
        if (Objects.equals(NIP, null)) {
            System.out.printf("|%-55s   %40s|%n", "NIP:" + vendorNIP, "");
        } else {
            System.out.printf("|%-55s   %40s|%n", "NIP:" + vendorNIP, "NIP:" + NIP.getNIP());
        }
        System.out.println(new String(new char[100]).replace("\0", "-"));
        System.out.printf("|%-5s | %-60s | %27s|%n", "Lp.", "Produkt", "Cena");
        System.out.println(new String(new char[100]).replace("\0", "-"));
        for (Table table : tables) {
            System.out.printf("|%-5s | %-60s | %27s|%n", ++id, table.getInformationForFacture(), table.getPrice());
            totalPrice += table.getPrice();
        }
        for (Sofa sofa : sofas) {
            System.out.printf("|%-5s | %-60s | %27s|%n", ++id, sofa.getInformationForFacture(), sofa.getPrice());
            totalPrice += sofa.getPrice();
        }
        System.out.println(new String(new char[100]).replace("\0", "-"));
        System.out.printf("|%-55s   %40s|%n", "", "RAZEM:" + totalPrice);
        System.out.printf("|%-55s   %40s|%n", "Do zapłaty: " + totalPrice + " PLN", "");
        System.out.println(new String(new char[100]).replace("\0", "-"));
    }

    public String getCustomer() {
        return customer;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerPostCode() {
        return customerPostCode;
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public ArrayList<Sofa> getSofas() {
        return sofas;
    }

    public CompanyInformation getNIP() {
        return NIP;
    }
}
