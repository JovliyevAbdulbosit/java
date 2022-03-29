package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StrinFor {

    public static void main(String[] args) {

        // stringni loop bilan aylantirish
//        String word = "I am OK" ;
//        for(int i=0; i<word.length(); i++){
//            System.out.println(word.charAt(i));
//        }
        //replace metod
//        String change = null;
//        String words = "big integer" ;
//        for(int i=0; i < words.length(); i++){
//            if (words.charAt(i)== 'e'){
//                System.out.println(words.charAt(i));
//                change=words.replace('e' , 'a');
//            }
//        }
//
//        System.out.println(change);
//        String sean = new String("hello");
//        System.out.println(sean);
//        words.split("e");
//        System.out.println(words.split("e"));
//
//        Map<Integer , Integer> dic= new HashMap<>();
//        for (int i=0; i<10 ; i++){
//            dic.put(i ,i*i);
//        }
//        int s=0;
//        for (int i=0; i<10;i++){
//
//            s+=dic.get(i);
//        }
//        System.out.println(s);
//        Scanner sc = new Scanner(System.in);
//        String word = sc.nextLine();
//        System.out.println(Math.pow(5,2));

//        String word = "salom";
//        String words = "salom";
//        System.out.println(words==word);
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int a[] = new int[n];
//        String[] word = {};
//        for(int i=0 ; i < n; i++){
//            a[i]=sc.nextInt();
//
//
//        }
//        //5 8 6 9
//        System.out.println(Arrays.stream(a).max());
        int [] arr={9 ,1 , 8, 3 ,3, 6 , 5};
        int n = arr.length;
//        int temp = 0;
//        for(int i=0; i < n; i++) {
//            for (int j = 1; j < (n - i); j++) {
//                if (arr[j - 1] > arr[j]) {
//                    //swap elements
//                    temp = arr[j - 1];
//                    arr[j - 1] = arr[j];
//                    arr[j] = temp;
//                }
//
//            }
//
//        }
//            System.out.println(Arrays.toString(arr));
        int a=0;

        for(int i=0; i < n-1; i++) {
            boolean check =true;
            while(check){

                if(arr[i]>arr[i+1]){
                    a=arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i] =a;
                    check= true;

                }else{ check=false;}
            }
        }
        System.out.println(Arrays.toString(arr));




    }

}
