import adding_managers.AddingTableManager;
import database.BasketProxy;
import furniture_production.factories.ModernFurnitureFactory;
import furniture_production.factories.TraditionalFurnitureFactory;
import furniture_production.furnitures.Table;
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

public class AddingTableManagerTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private AddingTableManager addingTableManager;

    @BeforeEach
    public void setUp() {
        addingTableManager = new AddingTableManager(mock(BasketProxy.class));
        Table table= mock(Table.class);
        Mockito.when(table.getInformationAboutTable()).thenReturn("");
        Mockito.when(table.getDetailsAboutStyle()).thenReturn("");
        addingTableManager.setTable(table);

        ModernFurnitureFactory modernFurnitureFactory = mock(ModernFurnitureFactory.class);
        Mockito.when(modernFurnitureFactory.createTable(any(String.class), any(String.class), any(String.class))).thenReturn(table);
        doNothing().when(modernFurnitureFactory).showTableOptions();
        addingTableManager.setModernFurnitureFactory(modernFurnitureFactory);


        TraditionalFurnitureFactory traditionalFurnitureFactory = mock(TraditionalFurnitureFactory.class);
        Mockito.when(traditionalFurnitureFactory.createTable(any(String.class), any(String.class), any(String.class))).thenReturn(table);
        doNothing().when(traditionalFurnitureFactory).showTableOptions();
        addingTableManager.setTraditionalFurnitureFactory(traditionalFurnitureFactory);

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    String getOutputFromTest(String input)
    {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        addingTableManager.setMyObj(new Scanner(System.in));
        addingTableManager.steps();
        String results = outContent.toString();
        results = results.replaceAll("\r", "");
        results = results.replaceAll("\n", "");
        return results;
    }
    @Test
    void shouldExecuteAllTableStepsCorrectly() {

        String input = "modern table\nFrench\ncoffee table\ncircle\nwyjdz\n";
        String results=getOutputFromTest(input);
        Assertions.assertEquals(("stoly:Wpisz poprawnie nazwe przedmiotu, który chcesz dodać do koszykawyjdz - wyjdź z tego trybuPodaj styl:Podaj rodzaj:Podaj ksztalt:Twoj produkt:Dodano pomyślnieWpisz poprawnie nazwe przedmiotu, który chcesz dodać do koszykawyjdz - wyjdź z tego trybu"), results);
        outContent= new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        input = "traditional table\nFrench\ncoffee table\ncircle\nwyjdz\n";
        results=getOutputFromTest(input);
        Assertions.assertEquals(("stoly:Wpisz poprawnie nazwe przedmiotu, który chcesz dodać do koszykawyjdz - wyjdź z tego trybuPodaj styl:Podaj rodzaj:Podaj ksztalt:Twoj produkt:Dodano pomyślnieWpisz poprawnie nazwe przedmiotu, który chcesz dodać do koszykawyjdz - wyjdź z tego trybu"), results);

    }
    @Test
    void shouldAskAgainWhenNameOfTableIsWrong()
    {
        String input = "modernistyczna table\nFrench\nwyjdz\n";
        String results=getOutputFromTest(input);
        Assertions.assertEquals(("stoly:Wpisz poprawnie nazwe przedmiotu, który chcesz dodać do koszykawyjdz - wyjdź z tego trybuWpisz poprawnie nazwe przedmiotu, który chcesz dodać do koszykawyjdz - wyjdź z tego trybuWpisz poprawnie nazwe przedmiotu, który chcesz dodać do koszykawyjdz - wyjdź z tego trybu"), results);

    }
    @Test
    void shouldExitInAddingManagerFunctions()
    {
        String input = "wyjdz\n\n";
        String results=getOutputFromTest(input);
        Assertions.assertEquals(("stoly:Wpisz poprawnie nazwe przedmiotu, który chcesz dodać do koszykawyjdz - wyjdź z tego trybu"), results);

    }

}
