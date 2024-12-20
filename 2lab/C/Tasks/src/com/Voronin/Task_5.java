 package com.Voronin;
/*
    Ввести с консоли n-размерность матрицы a [n] [n].
    Задать значения элементов матрицы в интервале значений
    от -n до n с помощью датчика случайных чисел.

    5. Транспонировать квадратную матрицу.
 */
import java.util.Scanner;

public class Task_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер матрицы N (N x N): ");
        int N = scanner.nextInt();

        System.out.print("Введите значение k (до какого числа заполнять): ");
        int k = scanner.nextInt();

        // Создаем матрицу N x N
        int[][] matrix = new int[N][N];

        // Заполняем матрицу числами от 1 до k
        int number = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (number <= k) {
                    matrix[i][j] = number;
                    number++;
                } else {
                    matrix[i][j] = 0; // Можно оставить 0 или любое другое значение для пустых ячеек
                }
            }
        }

        // Выводим матрицу
        System.out.println("Результирующая матрица:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] != 0) {
                    System.out.print(matrix[i][j] + "\t");
                } else {
                    System.out.print("\t"); // Пустая ячейка
                }
            }
            System.out.println();
        }
    }
}