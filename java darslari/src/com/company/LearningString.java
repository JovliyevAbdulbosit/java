package com.company;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.IntStream;

public class LearningString {
    public static void main(String[] args) {
        String word = "hello world ";
//
      //s// method upper case
        ////        word.toLowerCase();
        ////        System.out.println(word.toLowerCase());
        ////        System.out.println(word.toUpperCase());
        ////        // split
        ////       String[] a = (word.split("o"));
        ////        System.out.println(Arrays.toString(a));
        ////       for(String i:a){
        ////           System.out.println(i);
        ////       }
        ////        System.out.println("shu " + word.charAt(1));
        ////        IntStream b=word.chars();
        ////        b.forEach(System.out::println);
        ////// ikkita matini qo'shish
        ////        System.out.println(word.concat("sssss"));
        String news = null;
        for (char i:word.toCharArray()){
            System.out.println(i);

        }


    }

}
