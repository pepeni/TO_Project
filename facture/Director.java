package facture;

public class Director {

    public void constructPrivateFacture(Builder builder, String name,String address, String postCode) {
        builder.reset(builder.getFacture().tables,builder.getFacture().sofas);
        builder.setCustomer(name);
        builder.setAddress(address);
        builder.setPostCode(postCode);
    }

    public void constructCompanyFacture(Builder builder, String name, CompanyInformation NIP, String address, String postCode) {
        builder.reset(builder.getFacture().tables,builder.getFacture().sofas);
        builder.setCustomer(name);
        builder.setNIP(NIP);
        builder.setAddress(address);
        builder.setPostCode(postCode);
    }
}
