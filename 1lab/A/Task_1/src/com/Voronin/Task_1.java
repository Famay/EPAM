package com.Voronin;
/*
    Приветствовать любого пользователя при вводе его имени через командную строку.
 */

import java.util.Scanner;

public class Task_1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите свое имя: ");
        String name = input.next();
        System.out.println("Здравствуйте, " + name + "!");
    }
}