  package com.example.transport;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void testCarInitializationAndDisplayInfo() {
        // Создаем объект автомобиля с данными
        Car car = new Car("A123BC", "Toyota", "Camry", "VIN1234567890", "Иван Иванов", "Бензин");

        assertEquals("A123BC", car.getRegistrationNumber());
        assertEquals("Toyota", car.getBrand());
        assertEquals("Camry", car.getModel());
        assertEquals("VIN1234567890", car.getVinNumber());
        assertEquals("Иван Иванов", car.getOwner());
        assertEquals("Бензин", car.getPowerType());

        car.displayInfo();
    }

    @Test
    void testCarActions() {
        // Создаем объект автомобиля
        Car car = new Car("A123BC", "Toyota", "Camry", "VIN1234567890", "Иван Иванов", "Бензин");


        car.refuel(); // Вывод: "Автомобиль заправлен."
        car.repair(); // Вывод: "Автомобиль отремонтирован."
        car.service(); // Вывод: "Автомобиль обслужен."
        car.passInspection(); // Вывод: "Автомобиль прошел техосмотр."
    }
}
