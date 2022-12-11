import java.util.List;

public class KoszykProxy implements KoszykInterface{
    private Koszyk db;

    public KoszykProxy(Koszyk db) {
        this.db = db;
    }

    public void add(String value) {
        // add caching or logging functionality here
        this.db.add(value);
    }

    public List<String> get() {
        // add caching or logging functionality here
        return this.db.get();
    }

    public void delete(String value) {
        // add caching or logging functionality here
        this.db.delete(value);
    }
}
