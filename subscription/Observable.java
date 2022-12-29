package subscription;

import furniture_production.furnitures.Sofa;
import furniture_production.furnitures.Table;

public interface Observable {
    void subscribe(Sofa o);

    void subscribe(Table o);

    void unsubscribe(Sofa o);

    void unsubscribe(Table o);

    void notifyObservers();
}
