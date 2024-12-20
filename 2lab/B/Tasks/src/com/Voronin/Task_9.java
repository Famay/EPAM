 package com.Voronin;
/*
    4. Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу.
    Осуществить проверку корректности ввода чисел.
 */

import java.util.Scanner;

public class Task_9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int monthNum;
        do {
            System.out.print("Введите число от 1 до 12: ");
            monthNum = input.nextInt();
        } while (monthNum < 1 || monthNum > 12);

        final String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль",
                "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        System.out.println("Введенное число соответствует месяцу: " + months[monthNum - 1]);
    }
}