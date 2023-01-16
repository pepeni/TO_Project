import database.Basket;
import database.BasketProxy;
import furniture_production.furnitures.ModernSofa;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BasketTest {
    private Basket db1;
    private Basket db2;

    @Test
    public void hashCodesShouldBeEqual() {
        db1 = Basket.getInstance();
        db2 = Basket.getInstance();

        Assertions.assertEquals(db1.hashCode(), db2.hashCode());
    }
}
