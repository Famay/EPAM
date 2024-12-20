import org.example.Stock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StockTest {

    @Test
    void testBuyIncreasesPrice() {
        Stock stock = new Stock("TestCompany", 100);
        stock.buy(10);
        assertEquals(105, stock.getPrice(), 0.01);
    }

    @Test
    void testSellDecreasesPrice() {
        Stock stock = new Stock("TestCompany", 100);
        stock.sell(10);
        assertEquals(95, stock.getPrice(), 0.01);
    }
}

