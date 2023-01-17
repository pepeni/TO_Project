
import adding_managers.AddingSofaManager;
import database.BasketProxy;
import furniture_production.factories.ModernFurnitureFactory;
import furniture_production.factories.TraditionalFurnitureFactory;
import furniture_production.furnitures.Sofa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

public class AddingSofaManagerTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private AddingSofaManager addingSofaManager;

    @BeforeEach
    public void setUp() {
        addingSofaManager = new AddingSofaManager(mock(BasketProxy.class));
        Sofa sofa = mock(Sofa.class);
        Mockito.when(sofa.getInformationAboutSofa()).thenReturn("");
        Mockito.when(sofa.getDetailsAboutStyle()).thenReturn("");
        addingSofaManager.setSofa(sofa);

        ModernFurnitureFactory modernFurnitureFactory = mock(ModernFurnitureFactory.class);
        Mockito.when(modernFurnitureFactory.createSofa(any(String.class), any(int.class))).thenReturn(sofa);
        Mockito.doNothing().when(modernFurnitureFactory).showSofaOptions();
        addingSofaManager.setModernFurnitureFactory(modernFurnitureFactory);


        TraditionalFurnitureFactory traditionalFurnitureFactory = mock(TraditionalFurnitureFactory.class);
        Mockito.when(traditionalFurnitureFactory.createSofa(any(String.class), any(int.class))).thenReturn(sofa);
        doNothing().when(traditionalFurnitureFactory).showSofaOptions();
        addingSofaManager.setTraditionalFurnitureFactory(traditionalFurnitureFactory);

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    String getOutputFromTest(String input)
    {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        addingSofaManager.setMyObj(new Scanner(System.in));
        addingSofaManager.steps();
        String results = outContent.toString();
        results = results.replaceAll("\r", "");
        results = results.replaceAll("\n", "");
        return results;
    }
    @Test
    void shouldExecuteAllSofaStepsCorrectly() {

        String input = "modern sofa\n2\nFrench\n";
        String results=getOutputFromTest(input);
        Assertions.assertEquals(("sofy:Wpisz poprawnie nazwe przedmiotu, który chcesz dodać do koszykawyjdz - wyjdź z tego trybuPodaj iluosobowa jest:Podaj styl:Twój produkt:Dodano pomyślnie"), results);
        outContent= new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        input = "traditional sofa\n3\nFrench\n";
        results=getOutputFromTest(input);
        Assertions.assertEquals(("sofy:Wpisz poprawnie nazwe przedmiotu, który chcesz dodać do koszykawyjdz - wyjdź z tego trybuPodaj iluosobowa jest:Podaj styl:Twój produkt:Dodano pomyślnie"), results);

    }
    @Test
    void shouldReportWrongNumberOfSeats() {
        String input = "modern sofa\na\n";
        String results=getOutputFromTest(input);
        Assertions.assertEquals(("sofy:Wpisz poprawnie nazwe przedmiotu, który chcesz dodać do koszykawyjdz - wyjdź z tego trybu" +
                "Podaj iluosobowa jest:Podano bledna liczbe"), results);
    }
    @Test
    void shouldAskAgainWhenNameOfSofaIsWrong()
    {
        String input = "wyjdz\n";
        String results=getOutputFromTest(input);
        Assertions.assertEquals(("sofy:Wpisz poprawnie nazwe przedmiotu, który chcesz dodać do koszykawyjdz - wyjdź z tego trybu" ), results);

    }



}