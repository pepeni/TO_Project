import furniture_production.furnitures.*;
import furniture_production.styles.Style;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class FurnitureTest {
    @Test
    void shouldSetStyleModernSofa()
    {
        ModernSofa modernSofa=new ModernSofa();
        Style style = mock(Style.class);
        Mockito.when(style.getName()).thenReturn("Greek");
        Assertions.assertDoesNotThrow(()->modernSofa.setStyle(style));
        Mockito.when(style.getName()).thenReturn("French");
        Assertions.assertDoesNotThrow(()->modernSofa.setStyle(style));
    }
    @Test
    void shouldNotSetStyleModernSofa()
    {
        ModernSofa modernSofa=new ModernSofa();
        Style style = mock(Style.class);
        Mockito.when(style.getName()).thenReturn("greek");
        Assertions.assertThrows(IllegalArgumentException.class, ()->modernSofa.setStyle(style));
        Mockito.when(style.getName()).thenReturn("french");
        Assertions.assertThrows(IllegalArgumentException.class, ()->modernSofa.setStyle(style));
    }

    @Test
    void shouldSetStyleTraditionalSofa()
    {
        TraditionalSofa traditionalSofa=new TraditionalSofa();
        Style style = mock(Style.class);
        Mockito.when(style.getName()).thenReturn("French");
        Assertions.assertDoesNotThrow(()->traditionalSofa.setStyle(style));
    }
    @Test
    void shouldNotSetStyleTraditionalSofa()
    {
        TraditionalSofa traditionalSofa=new TraditionalSofa();
        Style style = mock(Style.class);
        Mockito.when(style.getName()).thenReturn("greek");
        Assertions.assertThrows(IllegalArgumentException.class, ()->traditionalSofa.setStyle(style));
        Mockito.when(style.getName()).thenReturn("french");
        Assertions.assertThrows(IllegalArgumentException.class, ()->traditionalSofa.setStyle(style));
        Mockito.when(style.getName()).thenReturn("Greek");
        Assertions.assertThrows(IllegalArgumentException.class, ()->traditionalSofa.setStyle(style));
    }
    @Test
    void shouldSetStyleModernTable()
    {
        ModernTable modernTable=new ModernTable();
        Style style = mock(Style.class);
        Mockito.when(style.getName()).thenReturn("Greek");
        Assertions.assertDoesNotThrow(()->modernTable.setStyle(style));
        Mockito.when(style.getName()).thenReturn("French");
        Assertions.assertDoesNotThrow(()->modernTable.setStyle(style));
    }
    @Test
    void shouldNotSetStyleModernTable()
    {
        ModernTable modernTable=new ModernTable();
        Style style = mock(Style.class);
        Mockito.when(style.getName()).thenReturn("greek");
        Assertions.assertThrows(IllegalArgumentException.class, ()->modernTable.setStyle(style));
        Mockito.when(style.getName()).thenReturn("french");
        Assertions.assertThrows(IllegalArgumentException.class, ()->modernTable.setStyle(style));
    }
    @Test
    void shouldSetStyleTraditionalTable()
    {
        TraditionalTable traditionalTable=new TraditionalTable();
        Style style = mock(Style.class);
        Mockito.when(style.getName()).thenReturn("French");
        Assertions.assertDoesNotThrow(()->traditionalTable.setStyle(style));
    }
    @Test
    void shouldNotSetStyleTraditionalTable()
    {
        TraditionalTable traditionalTable=new TraditionalTable();
        Style style = mock(Style.class);
        Mockito.when(style.getName()).thenReturn("greek");
        Assertions.assertThrows(IllegalArgumentException.class, ()->traditionalTable.setStyle(style));
        Mockito.when(style.getName()).thenReturn("french");
        Assertions.assertThrows(IllegalArgumentException.class, ()->traditionalTable.setStyle(style));
        Mockito.when(style.getName()).thenReturn("Greek");
        Assertions.assertThrows(IllegalArgumentException.class, ()->traditionalTable.setStyle(style));
    }
}
