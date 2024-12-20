 package com.Voronin;

// Написать код программы, которая бы переводила числа одной любой системы счисления в любую другую.

import java.util.Scanner;

public class Task_8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        String number = scanner.nextLine();

        System.out.print("Введите основание исходной системы счисления (от 2 до 36): ");
        int sourceBase = scanner.nextInt();

        System.out.print("Введите основание целевой системы счисления (от 2 до 36): ");
        int targetBase = scanner.nextInt();

        if ((sourceBase < 2 || sourceBase > 36) || (targetBase < 2 || targetBase > 36)) {
            System.out.println("Основание должно быть в диапазоне от 2 до 36.");
            return;
        }

        int decimalValue = convertToDecimal(number, sourceBase);
        if (decimalValue == -1) {
            System.out.println("Ошибка: введено некорректное число для заданного основания.");
            return;
        }

        String convertedNumber = convertFromDecimal(decimalValue, targetBase);
        System.out.println("Число " + number + " в системе счисления с основанием " + targetBase + " равно: " + convertedNumber);
    }

    private static int convertToDecimal(String number, int base) {
        int decimalValue = 0;
        int length = number.length();

        for (int i = 0; i < length; i++) {
            char digit = number.charAt(length - 1 - i);
            int value;

            if (Character.isDigit(digit)) {
                value = digit - '0';
            } else if (Character.isLetter(digit)) {
                value = Character.toUpperCase(digit) - 'A' + 10;
            } else {
                return -1; // Некорректный символ
            }

            if (value >= base) {
                return -1; // Некорректное значение для заданного основания
            }

            decimalValue += value * Math.pow(base, i);
        }

        return decimalValue;
    }

    private static String convertFromDecimal(int decimalValue, int base) {
        if (decimalValue == 0) return "0";

        StringBuilder result = new StringBuilder();
        boolean isNegative = decimalValue < 0;
        decimalValue = Math.abs(decimalValue);

        while (decimalValue > 0) {
            int remainder = decimalValue % base;
            result.append(remainder < 10 ? remainder : (char) ('A' + remainder - 10));
            decimalValue /= base;
        }

        if (isNegative) result.append('-');
        return result.reverse().toString();
    }
}