package com.lessons.java.gb.lesson6;

import java.util.*;


public class Lesson6 {
    public static void main(String[] args) {
        //Объявить и инициализировать множества HashSet hs, LinkedHashSet lhs и TreeSet ts
        Set<Integer> hs = new HashSet<>();
        Set<Integer> lhs = new LinkedHashSet<>();
        Set<Integer> ts = new TreeSet<>();
        //Добавить в множества по 10 случайных целочисленных ключей.
        Random random = new Random();
        int bound = 100;
        for(int i = 0; i < 10; i++){
            hs.add(random.nextInt(bound));
            lhs.add(random.nextInt(bound));
            ts.add(random.nextInt(bound));
        }
        System.out.printf("Task2\nhs = %s\nlhs = %s\nts = %s\n",hs,lhs,ts);
        //Пройти по множеству hs и, при условии наличия соответствующего ключа в множестве lhs, удалить ключ из hs
        Iterator<Integer> iterator = hs.iterator();
        while (iterator.hasNext()){
            Integer h = iterator.next();
            if(lhs.contains(h)){
                iterator.remove();
            }
        }
        System.out.printf("Task3\nhs = %s\nlhs = %s\nts = %s\n",hs,lhs,ts);

        //Пройти по множеству lhs и, при условии отсутствия соответствующего ключа в множестве ts, добавит ключ в ts
        for(Integer l : lhs){
            if(!ts.contains(l)){
                ts.add(l);
            }
        }
        System.out.printf("Task4\nhs = %s\nlhs = %s\nts = %s\n",hs,lhs,ts);
        //Объявить и инициализировать множество TreeSet ts1 с компаратором Integer
        //(-1 при значении %2==0 ;0 при ==;1 при значении %2!=0). Заполнить ts1 15 случайными числами и вывести на печать.
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1%2==0){
                    return -1;
                } else if(o1 == o2){
                    return 0;
                }
                return 1;
            }
        };
        TreeSet<Integer> ts1 = new TreeSet<>(comparator);
        for(int i = 0; i < 15; i++){
            ts1.add(random.nextInt(bound));
        }
        System.out.printf("Task5\nts1 = %s\n",ts1);

        //*Объявить и инициализировать множество TreeMap tm с компаратором Integer
        // (-1 при значении %2==0 ;0 при ==;1 при значении %2!=0). Заполнить tm 15 случайными числами и вывести на печать.
        TreeMap<Integer,Integer> tm = new TreeMap<>(comparator);
        for(int i = 0; i < 15; i++){
            tm.put(i,random.nextInt(bound));
        }
        System.out.printf("Task6\ntm = %s\n",tm);

    }
}
