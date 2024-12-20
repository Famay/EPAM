 package com.Voronin;

/*
    Программа для вывода всех чисел от 1 до 100, которые делятся на 3 без остатка.
 */

public class Task_4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.print(i + " ");
            }
        }
    }
}