package com.lessons.java.gb.lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) {
        //1. Создайте новый список массивов, добавить несколько цветов (строку) и вывести коллекцию на экран.
        List<String> colors = new ArrayList<>();
        colors.add("white");
        colors.add("pink");
        colors.add("black");
        System.out.printf("Задача 1: %s\n", colors);

        //2. Проитерируйте все элементы списка цветов и добавте к каждому символа '!'.
        for(int i = 0; i < colors.size(); i++){
            colors.set(i, colors.get(i)+"!");
        }
        System.out.printf("Задача 2: %s\n", colors);

        //3. Напишите программу для вставки элемента в список массивов в первой позиции.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задача 3:");
        insertIntoFirstPosition(colors,scanner);
        System.out.println(colors);

        //4. Извлеките элемент (по указанному индексу) из заданного списка.
        System.out.println("Задача 4:");
        System.out.println(getByIndex(colors,scanner));

        //5. Обновите элемент массива по заданному индексу.
        System.out.println("Задача 5:");
        updateByIndex(colors,scanner);
        System.out.println(colors);

        //6. Напишите программу для удаления третьего элемента из списка массивов.
        System.out.println("Задача 6:");
        colors.remove(2);
        System.out.println(colors);

        //7. Напишите программу для поиска элемента в списке массивов.
        System.out.println("Задача 7:");
        List<String> searchRes = search(colors,scanner);
        System.out.printf("Найдены следующие элементы: %s\n", searchRes);

        //8. *Напишите программу для сортировки заданного списка массивов.
        System.out.println("Задача 8:");
        sort(colors);
        System.out.printf("Отсортированный список: %s\n", colors);

        //9. *Напишите программу для копирования одного списка массивов в другой.
        System.out.println("Задача 9:");
        System.out.printf("Оригинальный список: %s\n", colors);
        List<String> copy = new ArrayList<>(colors);
        System.out.printf("Копия: %s\n", copy);
    }

    public static void insertIntoFirstPosition(List<String> list,Scanner scanner){
        System.out.println("Какой цвет вы хотите добавить? ");
        String str = scanner.nextLine();
        list.add(0,str);
    }

    public static String getByIndex(List<String> list, Scanner scanner){
        int i = askIndex(list.size(),scanner);
        return list.get(i);
    }

    public static int askIndex(int size, Scanner scanner){
        System.out.println("Введите позицию: ");
        if(!scanner.hasNextInt()){
            System.out.println("Ошибка! Вы ввели не число. Попробуйте еще раз.");
            scanner.nextLine();
            return askIndex(size,scanner);
        }
        int i = scanner.nextInt();
        if(i >= size || i < 0){
            System.out.printf("Ошибка! позиция должна быть в промежутке от 0 до %d. Попробуйте еще раз.\n", size-1);
            return askIndex(size,scanner);
        }
        scanner.nextLine();
        return i;
    }

    public static void updateByIndex(List<String> list, Scanner scanner){
        int i = askIndex(list.size(),scanner);
        System.out.printf("Текущее значение под позицией %d -> %s\n", i, list.get(i));
        System.out.println("Введите новое значение:");
        String str = scanner.nextLine();
        list.set(i,str);
        System.out.println("Значение обновлено");
    }

    public static List<String> search(List<String> list, Scanner scanner){
        System.out.println("Введите текст для поиска:");
        String search = scanner.nextLine();
        List<String> searchResult = new ArrayList<>();
        for(String str: list) {
            if(str.contains(search)){
                searchResult.add(str);
            }
        }
        return searchResult;
    }

    public static void sort(List<String> list) {
        boolean isSorted = false;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                String n1 = list.get(i);
                String n2 = list.get(i + 1);
                int r = n1.compareTo(n2);
                if (r > 0) {
                    isSorted = false;
                    String j = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, j);
                }
            }
        }
    }
}
