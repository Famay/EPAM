import org.example.Market;
import org.example.Stock;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MarketTest {

    @Test
    void testMarketTradeUpdatesStockPrice() {
        Stock stock = new Stock("TestCompany", 100);
        Market market = new Market(List.of(stock));

        market.trade("Broker1");
        double updatedPrice = stock.getPrice();
        assertTrue(updatedPrice != 100, "Цена акции должна измениться после сделки.");
    }

    @Test
    void testCalculateMarketIndex() {
        Stock stock1 = new Stock("CompanyA", 100);
        Stock stock2 = new Stock("CompanyB", 200);
        Market market = new Market(List.of(stock1, stock2));

        double index = market.calculateMarketIndex();
        assertEquals(300, index, 0.01);
    }

    @Test
    void testStopTrading() {
        Stock stock = new Stock("TestCompany", 100);
        Market market = new Market(List.of(stock));

        market.stopTrading();
        assertFalse(market.isTradingActive(), "Торги должны быть остановлены.");
    }
}
