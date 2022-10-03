package com.lessons.java.gb.lesson4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Lesson4 {

    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        LinkedList<Integer> ids = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        // заполняем листы данными
        boolean exit = true;
        while(exit) {
            System.out.println("Введите имя:");
            String str = scanner.nextLine();
            System.out.println("Введите возраст:");
            int i = scanner.nextInt();
            name.add(str);
            age.add(i);
            System.out.println("Идентификатор пользователя: " + name.get(name.size() - 1).hashCode());
            System.out.println("Закончить? (y/n):");
            scanner.nextLine();
            String ex = scanner.nextLine();
            if (ex.equals("y")) {
                exit = false;
            }
        }
        for (int i = 0; i < name.size(); i++) {
            ids.add(i);
        }

        // печатаем не отсортированный список пользователей
        System.out.println("Список пользователей:");
        for (int id : ids) {
            System.out.println("Имя: " + name.get(id) + ", Возраст: " + age.get(id) + ", id: " + name.get(id).hashCode());
        }

        // сортировка
        boolean isSorted = false;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < ids.size() - 1; i++) {
                Integer n1 = age.get(ids.get(i));
                Integer n2 = age.get(ids.get(i + 1));
                int r = n1.compareTo(n2);
                if (r > 0) {
                    isSorted = false;
                    int j = ids.get(i);
                    ids.set(i, ids.get(i + 1));
                    ids.set(i + 1, j);
                }
            }
        }

        // печатаем отсортированный список пользователей по возрасту
        System.out.println("Отсортированный список по возрасту: ");
        for (int id : ids) {
            System.out.println("Имя: " + name.get(id) + ", Возраст: " + age.get(id) + ", id: " + name.get(id).hashCode());
        }
    }
}
