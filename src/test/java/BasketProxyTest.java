import commands.CreateFacture;
import database.Basket;
import database.BasketProxy;
import facture.Facture;
import furniture_production.furnitures.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class BasketProxyTest {
    private CreateFacture createFacture;
    private BasketProxy basketProxy;
    private Basket db;
    private Facture facture;
    private ModernSofa modernSofa;
    private TraditionalSofa traditionalSofa;
    private ModernTable modernTable;
    private TraditionalTable traditionalTable;


    @Test
    public void shouldAddSofaToDB() {
        db = mock(Basket.class);
        basketProxy = new BasketProxy(db);
        modernSofa = mock(ModernSofa.class);

        basketProxy.addSofa(modernSofa);

        verify(db).addSofa(modernSofa);
    }

    @Test
    public void shouldAddTableToDB() {
        db = mock(Basket.class);
        basketProxy = new BasketProxy(db);
        traditionalTable = mock(TraditionalTable.class);

        basketProxy.addTable(traditionalTable);

        verify(db).addTable(traditionalTable);
    }

    @Test
    public void shouldNotAddNullToSofaDB() {
        db = mock(Basket.class);
        basketProxy = new BasketProxy(db);

        basketProxy.addSofa(null);

        verify(db, never()).addSofa(null);
    }

    @Test
    public void shouldNotAddNullToTableDB() {
        db = mock(Basket.class);
        basketProxy = new BasketProxy(db);

        basketProxy.addTable(null);

        verify(db,never()).addTable(null);
    }

    @Test
    public void shouldDeleteProperSofaInDB() {
        db = mock(Basket.class);
        basketProxy = new BasketProxy(db);

        basketProxy.deleteSofas(1);

        verify(db).deleteSofas(1);
    }

    @Test
    public void shouldDeleteProperTableInDB() {
        db = mock(Basket.class);
        basketProxy = new BasketProxy(db);

        basketProxy.deleteTables(1);

        verify(db).deleteTables(1);
    }

    @Test
    public void shouldReturnAllSofas() {
        db = mock(Basket.class);
        basketProxy = new BasketProxy(db);
        List sofas = new ArrayList<Sofa>();
        modernSofa = mock(ModernSofa.class);
        traditionalSofa = mock(TraditionalSofa.class);
        sofas.add(modernSofa);
        sofas.add(traditionalTable);
        when(db.getSofas()).thenReturn((ArrayList<Sofa>) sofas);

        Assertions.assertEquals(sofas, basketProxy.getSofas());
    }

    @Test
    public void shouldReturnAllTables() {
        db = mock(Basket.class);
        basketProxy = new BasketProxy(db);
        List tables = new ArrayList<Table>();
        modernTable = mock(ModernTable.class);
        traditionalTable = mock(TraditionalTable.class);
        tables.add(modernTable);
        tables.add(traditionalTable);
        when(db.getTables()).thenReturn((ArrayList<Table>) tables);

        Assertions.assertEquals(tables, basketProxy.getTables());
    }

}
