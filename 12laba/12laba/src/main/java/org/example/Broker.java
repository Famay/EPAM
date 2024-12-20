package org.example;

public class Broker implements Runnable {
    private final String name;
    private final Market market;

    public Broker(String name, Market market) {
        this.name = name;
        this.market = market;
    }

    @Override
    public void run() {
        while (market.isTradingActive()) {
            market.trade(name);
            try {
                Thread.sleep(500); // Имитация паузы между сделками
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
