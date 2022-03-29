package com.company;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Scanner sc= new Scanner(System.in);
//        System.out.print("Enter first number- ");
//        long a= sc.nextLong();
//        long b=a%10 ;
//        System.out.println(b);
//        System.out.print("son ");
//        String d= sc.nextLine() ;
//        String s= "";
//        System.out.println(d.length());
//        for (int i=d.length()-1; i>=0 ; i--){
//            s+=d.charAt(i);
//            System.out.println(d.charAt(i));
//        }
//        System.out.println(s);
        Classlar inson = new Classlar(2);
            inson.name="xon";
            inson.age = 24;

        System.out.println(inson.info());
        System.out.println(inson.info(1));
    Client news= new Client(inson);
            news.account=inson;
        System.out.println(news.info());


    }
}
