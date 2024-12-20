 package com.Voronin;
/*
     Определить принадлежность некоторого значения k интервалам (n, m], [n, m), (n, m), [n, m].
 */

import java.util.Scanner;

public class Task_3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите число k: ");
        int k = input.nextInt();
        System.out.print("Введите число n: ");
        int n = input.nextInt();
        System.out.print("Введите число m: ");
        int m = input.nextInt();

        if (k >= n && k <= m) {
            System.out.println("Число k = " + k + " принадлежит интервалу [" + n + ", " + m + "]");
        }

        if (k > n && k < m) {
            System.out.println("Число k = " + k + " принадлежит интервалу (" + n + ", " + m + ")");
        }

        if (k >= n && k < m) {
            System.out.println("Число k = " + k + " принадлежит интервалу [" + n + ", " + m + ")");
        }

        if (k > n && k <= m) {
            System.out.println("Число k = " + k + " принадлежит интервалу (" + n + ", " + m + "]");
        }

        if (k < n || k > m) {
            System.out.println("Число k = " + k + " не принадлежит интервалу [" + n + ", " + m + "]");
        }

    }
}