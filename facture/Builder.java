package facture;

import furniture_production.furnitures.Sofa;
import furniture_production.furnitures.Table;

import java.util.ArrayList;

public interface Builder {
    void reset(ArrayList<Table> table, ArrayList<Sofa> sofa);

    void setCustomer(String name);

    void setNIP(CompanyInformation nip);

    void setAddress(String address);

    void setPostCode(String postCode);

    Facture getFacture();
}
