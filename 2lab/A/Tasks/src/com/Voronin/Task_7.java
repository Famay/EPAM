 package com.Voronin;
/*
    Ввести n чисел с консоли.
    Найти число, состоящее только из различных цифр. Если таких чисел не-
    сколько, найти первое из них.
 */

import java.util.Scanner;

public class Task_7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите число элементов n: ");
        int n = input.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            System.out.print((i + 1) + "-й элемент: ");
            a[i] = input.nextInt();
        }

        for (int value : a) {
            if (isOnlyDifferentDigits(value)) {
                System.out.print("Число, состоящее только из разных цифр: " + value);
                break;
            }
        }

    }

    public static boolean isOnlyDifferentDigits(int value) {
        int[] digitsCount = new int[8];
        boolean result = true;
        while (value > 0) {
            int digit = value % 10;
            digitsCount[digit - 1]++;
            if (digitsCount[digit - 1] > 1) {
                result = false;
                break;
            }
            value /= 10;
        }

        return result;
    }
}