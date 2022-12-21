package facture;

import furniture_production.furnitures.Sofa;
import furniture_production.furnitures.Table;

import java.util.ArrayList;

public class FactureBuilder implements Builder {
    private Facture facture;

    public FactureBuilder(ArrayList<Table> table,ArrayList<Sofa> sofa) {
        this.reset(table,sofa);
    }

    @Override
    public void reset(ArrayList<Table> table, ArrayList<Sofa> sofa) {
        this.facture = new Facture(table,sofa);
    }

    @Override
    public void setCustomer(String name) {
        facture.setCustomer(name);
    }

    @Override
    public void setNIP(CompanyInformation NIP) {
        facture.setNIP(NIP);
    }

    @Override
    public void setAddress(String address){
        facture.setCustomerAddress(address);
    }

    @Override
    public void setPostCode(String postCode){
        facture.setCustomerPostCode(postCode);
    }

    @Override
    public Facture getFacture(){
        return this.facture;
    }
}
