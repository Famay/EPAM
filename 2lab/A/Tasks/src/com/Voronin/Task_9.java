 package com.Voronin;

/*
    Найти корни квадратного уравнения. Параметры уравнения передавать
    с командной строкой.
 */

import java.util.Scanner;

public class Task_9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите коэффициент a: ");
        double a = input.nextDouble();

        System.out.print("Введите коэффициент b: ");
        double b = input.nextDouble();

        System.out.print("Введите коэффициент c: ");
        double c = input.nextDouble();

        findRoots(a, b, c);
    }

    public static void findRoots(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Два различных корня: " + root1 + " и " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("Один корень: " + root);
        } else {
            System.out.println("Нет действительных корней.");
        }
    }
}