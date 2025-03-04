package com.Voronin;

/*
    Вывести фамилию разработчика, дату и время получения задания, а также дату и время сдачи задания.
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task_6 {
    public static void main(String[] args) {
        System.out.println("Разработчик: Voronin");
        Date taskGot = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.S");
        System.out.println("Задание получено: " + formatter.format(taskGot));

        Date taskCompleted = new Date();
        System.out.println("Задание выполнено: " + formatter.format(taskCompleted));
    }
}