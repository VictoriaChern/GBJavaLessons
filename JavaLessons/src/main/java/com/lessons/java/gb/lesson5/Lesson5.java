package com.lessons.java.gb.lesson5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lesson5 {
    public static void main(String[] args) {
        //Объявить и инициализировать словарь hashMap<String, String>
        Map<String,String> hashMap = new HashMap<>();
        //Добавить в словарь 10 пар "Ключ - Значение". Автор и название книги например.
        hashMap.putAll(Map.of(
                "Кэролл","Алиса в стране чудес",
                "Стокер","Дракула",
                "Герберт", "Война миров",
                "Хайн Лайн", "Звездный десант",
                "Гибсон","Нейромант",
                "Крайден","Парк юрского периода",
                "Хаксли","О дивный новый мир",
                "Оруэлл","1984",
                "Лем","Солярис",
                "Брэдбери","Марсианские хроники"));
        System.out.println(hashMap);
        //Пройти по словарю и добавить к значениям символ "!"
        for(Map.Entry<String,String> entry : hashMap.entrySet()){
            entry.setValue(entry.getValue()+ "!");
        }
        System.out.println(hashMap);
        //Добавить нового автора и название книги если соответствующего ключа не было.
        addNewAuthor(hashMap);
        System.out.println(hashMap);
        //Если ключ, указанный в запросе, имеется, вырезать из соответствующего ключу значения первое слово.
        addOrCutNewAuthor(hashMap);
        System.out.println(hashMap);
        //*Пройти по словарю другим, не таким как в пункте 3, методом и вывести пары ключ значение в консоль.
        for (String key: hashMap.keySet()){
            System.out.printf("key = %s, value = %s\n",key,hashMap.get(key));
        }
        //** Пройти по словарю другим, не таким как в пункте 3 и 6, методом. Добавить к значениям строку "(просмотрен)" и вывести в консоль.
    }
    public static void addNewAuthor(Map<String,String> map){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите автора: ");
        String author = scanner.nextLine();
        System.out.println("Введите название книги: ");
        String book = scanner.nextLine();
        map.putIfAbsent(author,book);
    }

    public static void addOrCutNewAuthor(Map<String,String> map){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите автора: ");
        String author = scanner.nextLine();
        System.out.println("Введите название книги: ");
        String book = scanner.nextLine();

        String value = map.get(author);
        if(value != null){
            int index = value.indexOf(" ");
            value = index < 0 ? "" : value.substring(index+1);
        } else {
            value = book;
        }
        map.put(author,value);
    }
}
