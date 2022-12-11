import java.util.ArrayList;
import java.util.List;

public class Koszyk {
    private static Koszyk instance;
    private List<String> koszyk;

    private Koszyk() {
        // initialize database
        this.koszyk = new ArrayList<>();
    }

    public static Koszyk getInstance() {
        if (instance == null) {
            instance = new Koszyk();
        }
        return instance;
    }

    public void add(String value) {
        this.koszyk.add(value);
    }

    public List<String> get() {
        return this.koszyk;
    }

    public void delete(String value) {
        this.koszyk.remove(value);
    }
}
