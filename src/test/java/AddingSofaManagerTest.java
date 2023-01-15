
import adding_managers.AddingSofaManager;
import database.BasketProxy;
import furniture_production.factories.ModernFurnitureFactory;
import furniture_production.factories.TraditionalFurnitureFactory;
import furniture_production.furnitures.Sofa;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.Mockito;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class AddingSofaManagerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    @Mock
    Scanner myObj;
    @Mock
    ModernFurnitureFactory modernFurnitureFactory;
    @Mock
    TraditionalFurnitureFactory traditionalFurnitureFactory;
    @Test
    public void createFurniture()
    {

        String input = "2\nFrench\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        AddingSofaManager addingSofaManager=new AddingSofaManager(mock(BasketProxy.class));
        addingSofaManager.setMyObj(new Scanner(System.in));
        addingSofaManager.setModernFurnitureFactory(modernFurnitureFactory);
        addingSofaManager.setTraditionalFurnitureFactory(traditionalFurnitureFactory);
       Sofa sofa=mock(Sofa.class);
        Mockito.when(modernFurnitureFactory.createSofa(any(String.class), any(int.class))).thenReturn(null);
        Mockito.when(sofa.getInformationAboutSofa()).thenReturn("");
        Mockito.when(sofa.getDetailsAboutStyle()).thenReturn("");
        addingSofaManager.setSofa(sofa);
        addingSofaManager.createFurniture("modern sofa");
      Assertions.assertEquals("Podaj iluosobowa jest:\nPodaj styl:\nTwój produkt:\nDodano pomyślnie\n", outContent.toString().trim());
    }
}
