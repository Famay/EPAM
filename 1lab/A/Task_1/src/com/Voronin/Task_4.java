package com.Voronin;
/*
    Ввести пароль из командной строки и сравнить его со строкой-образцом.
 */

import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите пароль: ");
        String psw = input.next();

        if (psw.equals("123")) {
            System.out.println("Верный пароль!");
        } else {
            System.out.println("Неверный пароль!");
        }
    }
}