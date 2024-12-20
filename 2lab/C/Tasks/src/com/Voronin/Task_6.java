 package com.Voronin;
/*
    Ввести с консоли n-размерность матрицы a [n] [n].
    Задать значения элементов матрицы в интервале значений
    от -n до n с помощью датчика случайных чисел.

    6. Вычислить норму матрицы.
 */

import java.util.Scanner;


public class Task_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер матрицы N (N x N): ");
        int N = scanner.nextInt();

        System.out.print("Введите значение k (до какого числа заполнять): ");
        int k = scanner.nextInt();

        // Создаем матрицу N x N
        double[][] matrix = new double[N][N];

        // Заполняем матрицу случайными вещественными числами от 1 до k
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((i * N + j + 1) <= k) {
                    // Заполняем случайными вещественными числами
                    matrix[i][j] = Math.random() * k; // случайное число от 0 до k
                } else {
                    matrix[i][j] = 0; // Можно оставить 0 или любое другое значение для пустых ячеек
                }
            }
        }

        // Округляем элементы матрицы
        int[][] roundedMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                roundedMatrix[i][j] = (int) Math.round(matrix[i][j]);
            }
        }

        // Выводим округленную матрицу
        System.out.println("Результирующая округленная матрица:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (roundedMatrix[i][j] != 0) {
                    System.out.print(roundedMatrix[i][j] + "\t");
                } else {
                    System.out.print("\t"); // Пустая ячейка
                }
            }
            System.out.println();
        }
    }
}