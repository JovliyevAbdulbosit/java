package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// sonni stringga o'tkazish
//    int number = 12 ;
//    String d = String.valueOf(number);
////    System.out.println(d.getClass().getSimpleName());
//        int i=10;
//        String s=Integer.toString(i);//Now it will return "10"
//    // stringni songa o'tkazish
//        String word = "restart";
//        char g='s';
//        char news = '$';
//        char ne = word.charAt(5);
//
//        String son1 = word.substring(0,5)+"$" +word.substring(6 , word.length());
//        System.out.println(son1);
//        Scanner sc=new Scanner(System.in);
//        float number = sc.nextFloat();
//        if ( number >= 100000){
//            System.out.println(number-(number*10)/100);
//        }
//        else if ( number >= 50000){
//            System.out.println(number-(number*5)/100);
//        }else {
//            System.out.println(number);
//        }
//        Scanner sc=new Scanner(System.in);
//        System.out.println("umumiy ");
//        int total = sc.nextInt();
//        System.out.println("topgan ");
//        int result = sc.nextInt();
//        if (result >= total*60/100){
//            System.out.println("ok");
//        }else {
//            System.out.println("no");
//        }
        //listga add qilish
//        List<Integer> list = new ArrayList<>();
//        list.add(5);
//        for(int i=0; i<=10; i++){
//           list.add(i , i+1);
//
//        }
//        System.out.println(list);
//        Map<String , Integer> dic = new HashMap<>();
//        dic.put("son" , 3) ;
//        dic.put("so1" , 3) ;
//        dic.put("son2" , 3) ;
//        dic.put("son3" , 3) ;
//        System.out.println(dic);
//        // listga ixtiyoriy naras yozish
//        List<Object> lists = new ArrayList<>();
//        lists.add(5);
//        lists.add(8);
        // o'zgaruvchilar
        int a= 12;//bu tip butun sonlar uchun
        Map<String , Integer> dic = new HashMap<>();

        for(int i=0; i<=10; i++){
            String d = String.valueOf(i);
            dic.put("son"+d,i);
        }

        System.out.println(dic.get("son7"));
    }




}
