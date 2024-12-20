package org.example;

public class Stock {
    private final String name;
    private double price;

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public synchronized void buy(int quantity) {
        price += quantity * 0.5; // Увеличение цены при покупке
    }

    public synchronized void sell(int quantity) {
        price -= quantity * 0.5; // Уменьшение цены при продаже
    }
}
