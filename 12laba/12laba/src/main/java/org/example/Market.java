package org.example;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Market {
    private final List<Stock> stocks;
    private final Lock lock = new ReentrantLock();
    private volatile boolean tradingActive = true;

    public Market(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public boolean isTradingActive() {
        return tradingActive;
    }

    public void stopTrading() {
        tradingActive = false;
        System.out.println("Торги остановлены!");
    }

    public void trade(String brokerName) {
        if (!tradingActive) return;

        lock.lock();
        try {
            Stock stock = stocks.get((int) (Math.random() * stocks.size()));
            int quantity = (int) (Math.random() * 10) + 1; // Кол-во акций
            boolean buy = Math.random() > 0.5;

            if (buy) {
                stock.buy(quantity);
                System.out.printf("%s купил %d акций %s. Цена: %.2f%n", brokerName, quantity, stock.getName(), stock.getPrice());
            } else {
                stock.sell(quantity);
                System.out.printf("%s продал %d акций %s. Цена: %.2f%n", brokerName, quantity, stock.getName(), stock.getPrice());
            }
        } finally {
            lock.unlock();
        }
    }

    public double calculateMarketIndex() {
        return stocks.stream().mapToDouble(Stock::getPrice).sum();
    }
}
