 package com.Voronin;

//Написать код программы, которая бы переводила числа из десятичной системы счисления в любую другую

import java.util.Scanner;

public class Task_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите десятичное число: ");
        int decimalNumber = scanner.nextInt();

        System.out.print("Введите основание системы счисления (от 2 до 36): ");
        int base = scanner.nextInt();

        if (base < 2 || base > 36) {
            System.out.println("Основание должно быть в диапазоне от 2 до 36.");
            return;
        }

        String result = convertToBase(decimalNumber, base);

        System.out.println("Число " + decimalNumber + " в системе счисления с основанием " + base + " равно: " + result);
    }

    public static String convertToBase(int decimalNumber, int base) {
        if (decimalNumber == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        boolean isNegative = decimalNumber < 0;
        decimalNumber = Math.abs(decimalNumber);

        while (decimalNumber > 0) {
            int remainder = decimalNumber % base;

            if (remainder >= 10) {
                result.append((char) ('A' + (remainder - 10)));
            } else {
                result.append(remainder);
            }
            decimalNumber /= base;
        }

        if (isNegative) {
            result.append('-');
        }

        // Результат нужно развернуть, так как мы добавляли цифры в обратном порядке
        return result.reverse().toString();
    }
}