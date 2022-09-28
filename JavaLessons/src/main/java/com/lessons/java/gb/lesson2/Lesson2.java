package com.lessons.java.gb.lesson2;

public class Lesson2 {

    public static void main(String[] args) {
        // Напишите программу на Java, чтобы проверить,
        // являются ли две данные строки вращением друг друга.
        String s1 = "Hello world";
        String s2 = "ldHell";
        System.out.printf("\"%s\", \"%s\" -> %s вращением друг друга\n", s1,s2,
                checkRotation(s1,s2)? "являются": "не являются");

        //*Напишите программу на Java, чтобы перевернуть строку с помощью рекурсии.
        System.out.println(stringReverse("hello world"));

        //Дано два числа, например 3 и 56, необходимо составить следующие строки:
        // 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
        String str = buildString(3,56);
        System.out.println(str);

        //Замените символ “=” на слово “равно”.
        // Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
        System.out.println(replaceString(str));

        //*Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
        System.out.println(replaceString2(str));

        //**Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "="
        // средствами String и StringBuilder.
        String test = "=".repeat(10000);
        System.out.printf("Test string:\n%s", test);

        System.out.println("String method:");
        long startTime = System.currentTimeMillis();
        System.out.println(test.replaceAll("=","равно"));
        long endTime = System.currentTimeMillis();
        System.out.printf("Time: %d millis\n", (endTime-startTime));

        System.out.println("Stringbuilder method (deleteCharAt, insert):");
        startTime = System.currentTimeMillis();
        System.out.println(replaceString(test));
        endTime = System.currentTimeMillis();
        System.out.printf("Time: %d millis\n", (endTime-startTime));

        System.out.println("Stringbuilder method (replace):");
        startTime = System.currentTimeMillis();
        System.out.println(replaceString2(test));
        endTime = System.currentTimeMillis();
        System.out.printf("Time: %d millis\n", (endTime-startTime));
    }

    public static boolean checkRotation(String s1, String s2){
        return (s1 + s1).contains(s2);
    }

    public static String stringReverse(String st){
        if(st.length()==1){
            return st;
        }
        return st.substring(st.length()-1) + stringReverse(st.substring(0,st.length()-1));
    }

    public static String buildString(int n1, int n2){
        StringBuilder sb = new StringBuilder();
        sb.append(n1).append(" + ").append(n2).append(" = ").append(n1+n2).append(" ");
        sb.append(n1).append(" - ").append(n2).append(" = ").append(n1-n2).append(" ");
        sb.append(n1).append(" * ").append(n2).append(" = ").append(n1*n2).append(" ");
        return sb.toString();
    }

    public static String replaceString(String s){
        StringBuilder sb = new StringBuilder(s);
        int i = sb.indexOf("=");
        while(i != -1) {
            sb.deleteCharAt(i).insert(i, "равно");
            i = sb.indexOf("=");
        }
        return sb.toString();
    }

    public static String replaceString2(String s){
        StringBuilder sb = new StringBuilder(s);
        int i = sb.indexOf("=");

        while(i != -1) {
            sb.replace(i,i+1,"равно");
            i = sb.indexOf("=");
        }

        return sb.toString();
    }
}
