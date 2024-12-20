import org.example.Market;
import org.example.MarketIndexWatcher;
import org.example.Stock;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MarketIndexWatcherTest {

    @Test
    void testMarketIndexWatcherStopsTradingOnDrop() {
        Stock stock1 = new Stock("CompanyA", 100);
        Stock stock2 = new Stock("CompanyB", 100);
        Market market = new Market(List.of(stock1, stock2));

        MarketIndexWatcher watcher = new MarketIndexWatcher(market);
        Thread watcherThread = new Thread(watcher);
        watcherThread.start();

        stock1.sell(200); // Умышленно "обрушить" индекс
        try {
            Thread.sleep(1000); // Дать время наблюдателю остановить торги
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        assertTrue(market.isTradingActive(), "Торги должны остановиться при резком падении индекса.");
    }
}
