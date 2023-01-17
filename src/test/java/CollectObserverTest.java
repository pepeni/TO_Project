import commands.CreateFacture;
import database.BasketProxy;
import furniture_production.furnitures.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import subscription.CollectObserver;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CollectObserverTest {

    private CreateFacture createFacture;
    private BasketProxy basketProxy;
    private ModernSofa modernSofa;
    private TraditionalSofa traditionalSofa;
    private ModernTable modernTable;
    private TraditionalTable traditionalTable;


    @Before
    public void setUp() {
        basketProxy = mock(BasketProxy.class);
        modernSofa = mock(ModernSofa.class);
        traditionalSofa = mock(TraditionalSofa.class);
        modernTable = mock(ModernTable.class);
        traditionalTable = mock(TraditionalTable.class);
        createFacture = new CreateFacture(basketProxy);
    }


    @Test
    public void ShouldReturn0FurnitureNotifications() {
        String input = "wyjdz";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        CollectObserver collectObserver = createFacture.getCollectObserver();
        ArrayList<Sofa> sofas = new ArrayList<>();
        sofas.add(modernSofa);
        sofas.add(traditionalSofa);
        ArrayList<Table> tables = new ArrayList<>();
        tables.add(modernTable);
        tables.add(traditionalTable);
        when(basketProxy.getSofas()).thenReturn(sofas);
        when(basketProxy.getTables()).thenReturn(tables);

        System.setIn(in);
        createFacture.execute();
        System.setOut(new PrintStream(outContent));
        collectObserver.notifyObservers();

        Assertions.assertEquals("", outContent.toString().trim());
    }

    @Test
    public void ShouldReturnFurnitureNotifications() {
        String input = "wyjdz";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        CollectObserver collectObserver = createFacture.getCollectObserver();
        ArrayList<Sofa> sofas = new ArrayList<>();
        sofas.add(traditionalSofa);
        ArrayList<Table> tables = new ArrayList<>();
        tables.add(modernTable);
        tables.add(traditionalTable);
        when(basketProxy.getSofas()).thenReturn(sofas);
        when(basketProxy.getTables()).thenReturn(tables);


        System.setIn(in);
        createFacture.execute();
        System.setOut(new PrintStream(outContent));
        collectObserver.notifyObservers();

        Assertions.assertEquals("W ofercie posiadamy również Modern Sofa", outContent.toString().trim());
    }
}
