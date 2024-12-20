package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаём акции с начальными ценами
        List<Stock> stocks = Arrays.asList(
                new Stock("CompanyA", 100),
                new Stock("CompanyB", 150),
                new Stock("CompanyC", 200)
        );

        // Создаём рынок
        Market market = new Market(stocks);

        // Добавляем брокеров
        for (int i = 1; i <= 5; i++) {
            new Thread(new Broker("Broker" + i, market)).start();
        }

        // Запускаем наблюдатель за индексом
        new Thread(new MarketIndexWatcher(market)).start();
    }
}
