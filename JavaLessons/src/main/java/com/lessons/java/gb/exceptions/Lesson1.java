package com.lessons.java.gb.exceptions;

import java.util.Arrays;

public class Lesson1 {

    public static void main(String[] args) {
        // task 1
        testArrayIndexOutOfBoundsException();
        testArithmeticException();
        testNumberFormatException();

        // task 2
        int[] a1 = {16, 34, 12};
        int[] a2 = {4, 12, 7};
        System.out.println(Arrays.toString(arrayDif(a1, a2)));
        try {
            int[] b1 = {16, 34, 12, 34};
            int[] b2 = {6, 72, 9};
            System.out.println(Arrays.toString(arrayDif(b1, b2)));
        } catch (IllegalArgumentException e){
            System.err.printf("Возникла ошибка: %s\n", e);
        }

    }

    public static void testArrayIndexOutOfBoundsException(){
        try {
            int[] array = {1,2,3};
            System.out.println(array[3]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.err.printf("Возникла ошибка: %s\n", e);
        }
    }

    public static void testArithmeticException(){
        try {
            int a = 5;
            int b = 0;
            System.out.println(a/b);
        } catch (ArithmeticException e){
            System.err.printf("Возникла ошибка: %s\n", e);
        }
    }
    public static void testNumberFormatException(){
        try {
            String str = "Hello";
            System.out.println(Integer.parseInt(str));
        } catch (NumberFormatException e){
            System.err.printf("Возникла ошибка: %s\n", e);
        }
    }

    public static int[] arrayDif(int[] s1, int[] s2){
        if(s1.length != s2.length){
            throw new IllegalArgumentException("Длины массивов не равны");
        }
        int[] ans = new int[s1.length];
        for(int i = 0; i < s1.length; i++){
            ans[i] = s1[i] - s2[i];
        }
        return ans;
    }
}
