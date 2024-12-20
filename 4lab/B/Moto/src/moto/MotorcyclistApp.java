 package moto;

import java.util.*;

public class MotorcyclistApp {
    public static void main(String[] args) {
        Motorcyclist motorcyclist = new Motorcyclist();

        // Экипируем мотоциклиста
        motorcyclist.addEquipment(new Helmet(1.5, 5000));
        motorcyclist.addEquipment(new Jacket(3.0, 12000));
        motorcyclist.addEquipment(new Gloves(0.5, 2000));
        motorcyclist.addEquipment(new Boots(2.5, 8000));

        System.out.println("Изначальная экипировка:");
        motorcyclist.displayEquipment();

        // Подсчет общей стоимости
        System.out.println("\nОбщая стоимость экипировки: " + motorcyclist.calculateTotalPrice() + " руб.");

        // Сортировка по весу
        motorcyclist.sortEquipmentByWeight();
        System.out.println("\nЭкипировка после сортировки по весу:");
        motorcyclist.displayEquipment();

        // Поиск по диапазону цен
        double minPrice = 3000;
        double maxPrice = 10000;
        System.out.println("\nЭкипировка в диапазоне цен от " + minPrice + " до " + maxPrice + " руб.:");
        List<Equipment> filteredEquipment = motorcyclist.findEquipmentByPriceRange(minPrice, maxPrice);
        for (Equipment equipment : filteredEquipment) {
            System.out.println(equipment);
        }
    }
}
