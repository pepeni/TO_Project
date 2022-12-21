package facture;

public class CompanyInformation {

    private final String NIP;
    private static volatile CompanyInformation instance = null;

    private CompanyInformation(String nip) {
        if (instance != null) {
            throw new RuntimeException("Może istnieć tylko jeden numer NIP, aby go użyć wykorzystaj metodę getInstance()");
        }
        this.NIP = nip;
    }

    public static CompanyInformation getInstance(String nip) {
        if (instance == null) {
            synchronized (CompanyInformation.class) {
                if (instance == null) {
                    instance = new CompanyInformation(nip);
                }
            }
        }
        return instance;
    }

    public String getNIP() {
        return NIP;
    }
}
