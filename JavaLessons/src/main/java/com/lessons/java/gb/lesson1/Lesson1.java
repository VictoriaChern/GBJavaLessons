package com.lessons.java.gb.lesson1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Lesson1 {

    public static void main(String[] args) {
        // 1. Выбросить случайное целое число в диапазоне от -1000 до 1000 и сохранить в i
        int i = task1();
        System.out.printf("i = %d \n", i);

        // 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        int n = task2(i);
        System.out.printf("n = %d \n", n);

        // 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
        int[] m1 = task3_4(n,i,Short.MAX_VALUE);
        System.out.printf("m1 = %s \n", Arrays.toString(m1));

        // 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
        int[] m2 = task3_4(n,Short.MIN_VALUE,i);
        System.out.printf("m2 = %s \n", Arrays.toString(m2));

        //5. Сохранить оба массива в файлы с именами m1 и m2 соответственно.
        task5(m1,m2);
    }

    public static int task1(){
        Random random = new Random();
        return random.nextInt(2001)-1000;
    }

    public static int task2(int i){
        return Integer.toBinaryString(Math.abs(i)).length();
    }

    public static int[] task3_4(int n, int min, int max){
        int size = 0;
        for(int j = min; j <= max; j++){
            if(j%n == 0) size++;
        }
        int[] array = new int[size];
        for(int j = min, k = 0; j <= max; j++){
            if(j%n == 0) {
                array[k] = j;
                k++;
            }
        }
        return array;
    }

    public static void task5(int[] m1, int[] m2){
        writeFile("m1.txt",m1);
        writeFile("m2.txt",m2);
    }

    public static void writeFile(String fileName, int[] array){
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for(int j = 0; j < array.length; j++){
                fileWriter.write(array[j] + " ");
            }
        } catch (IOException e) {
            System.err.println("Не получилось записать в файл "+fileName);
        }
    }
}
