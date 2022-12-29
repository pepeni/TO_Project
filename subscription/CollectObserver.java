package subscription;

import furniture_production.furnitures.Sofa;
import furniture_production.furnitures.Table;

import java.util.HashSet;
import java.util.Set;

public class CollectObserver implements Observable{

    private final Set<Sofa> sofas;
    private final Set<Table> tables;

    public CollectObserver(){
        this.sofas = new HashSet<>();
        this.tables = new HashSet<>();
    }

    @Override
    public void subscribe(Sofa observer){
        sofas.add(observer);
    }

    @Override
    public void subscribe(Table observer){
        tables.add(observer);
    }


    @Override
    public void unsubscribe(Sofa observer){
        sofas.remove(observer);
    }

    @Override
    public void unsubscribe(Table observer){
        tables.remove(observer);
    }

    @Override
    public void notifyObservers(){
        sofas.forEach(Sofa::newsletter);
        tables.forEach(Table::newsletter);
    }
}
