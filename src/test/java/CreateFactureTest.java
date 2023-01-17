import commands.CreateFacture;
import database.BasketProxy;
import facture.Facture;
import furniture_production.furnitures.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;


public class CreateFactureTest {


    private CreateFacture createFacture;
    private BasketProxy basket;
    private Facture facture;
    private ModernSofa modernSofa;
    private ModernTable modernTable;
    private TraditionalTable traditionalTable;

    @Before
    public void setUp() {
        basket = mock(BasketProxy.class);
        modernSofa = mock(ModernSofa.class);
        modernTable = mock(ModernTable.class);
        traditionalTable = mock(TraditionalTable.class);
        createFacture = new CreateFacture(basket);
    }

    @Test
    public void testGeneratePersonalFacture() {
        String input = "Konrad Nowak\nWarszawska 24\n31-155 Kraków\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        ArrayList<Table> tables = new ArrayList<>();
        tables.add(modernTable);
        tables.add(traditionalTable);

        ArrayList<Sofa> sofas = new ArrayList<>();
        sofas.add(modernSofa);

        when(basket.getTables()).thenReturn(tables);
        when(basket.getSofas()).thenReturn(sofas);

        System.setIn(in);
        createFacture.makePersonalFacture();

        facture = createFacture.getFacture();

        Assertions.assertEquals("Konrad Nowak",facture.getCustomer());
        Assertions.assertEquals("Warszawska 24",facture.getCustomerAddress());
        Assertions.assertEquals("31-155 Kraków",facture.getCustomerPostCode());
        Assertions.assertEquals(2,facture.getTables().size());
        Assertions.assertEquals(1,facture.getSofas().size());
    }

    @Test
    public void testGenerateCompanyFacture() {
        String input = "KoloX\nWarszawska 24\n31-155 Kraków\n1234567890\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        ArrayList<Table> tables = new ArrayList<>();
        tables.add(modernTable);
        tables.add(traditionalTable);
        tables.add(traditionalTable);
        tables.add(traditionalTable);

        ArrayList<Sofa> sofas = new ArrayList<>();

        when(basket.getTables()).thenReturn(tables);
        when(basket.getSofas()).thenReturn(sofas);

        System.setIn(in);
        createFacture.makeCompanyFacture();

        facture = createFacture.getFacture();

        Assertions.assertEquals("KoloX",facture.getCustomer());
        Assertions.assertEquals("Warszawska 24",facture.getCustomerAddress());
        Assertions.assertEquals("31-155 Kraków",facture.getCustomerPostCode());
        Assertions.assertEquals("1234567890",facture.getNIP().getNIP());
        Assertions.assertEquals(4,facture.getTables().size());
        Assertions.assertEquals(0,facture.getSofas().size());
    }
}
