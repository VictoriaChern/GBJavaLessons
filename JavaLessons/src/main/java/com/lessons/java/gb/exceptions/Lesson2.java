package com.lessons.java.gb.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lesson2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Вы ввели число: %.3f\n", task1(scanner));
        task2();
        task3();
        task4(scanner);
    }

    /**
     * task 1: Реализуйте метод, который запрашивает у пользователя ввод дробного числа
     * (типа float), и возвращает введенное значение.
     *  Ввод текста вместо числа не должно приводить к падению приложения,
     * вместо этого, необходимо повторно запросить у пользователя ввод данных.
     */
    public static float task1(Scanner scanner){
        System.out.println("Введите дробное число:");

        try {
            return scanner.nextFloat();
        } catch (InputMismatchException e){
            System.out.println("Неккоректный ввод");
            scanner.nextLine();
            return task1(scanner);
        }
    }

    /**
     * task 2: исправьте данный код
     * <a href="https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit">задание 2</a>
     */
    public static void task2() {
        int[] intArray = {20,33,2,5,6,89,7,122,4,6};
        try {
            int d = 2;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    /**
     * task3: исправьте код там, где требуется
     * <a href="https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit">задание 3</a>
     */
    private static void task3() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2, 0, 0 };
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b){
        System.out.println(a + b);
    }

    /**
     * Разработайте программу, которая выбросит Exception,
     * когда пользователь вводит пустую строку.
     * Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
     */
    public static void task4(Scanner scanner){
        System.out.println("Введите любую строку:");
        try {
            System.out.println(askString(scanner));
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public static String askString(Scanner scanner) throws Exception {
        String str = scanner.nextLine();
        if(str.isBlank()) {
            throw new Exception("Пустые строки вводить нельзя");
        }
        return str;
    }
}
