package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Method {

    public static void main(String[] args) {
        String word = new String("salom");

        for (int i=0; i<word.length() ; i++){
            System.out.println(word.charAt(i));
        }



    }
     public static void free(String d){
        System.out.println("siz shu"+" " +d + " degan so'zni yozdingiz");
    }
     public static int summ(int a , int b){
        return a+b;
    }
    protected static int summs(int a , int b){
        return a+b;
    }
}
