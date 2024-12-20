package org.example;

public class MarketIndexWatcher implements Runnable {
    private final Market market;

    public MarketIndexWatcher(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        double initialIndex = market.calculateMarketIndex();
        while (market.isTradingActive()) {
            double currentIndex = market.calculateMarketIndex();
            System.out.printf("Текущий индекс биржи: %.2f%n", currentIndex);

            if (currentIndex < initialIndex * 0.5) {
                market.stopTrading();
            }

            try {
                Thread.sleep(1000); // Проверка каждые 1 сек
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
