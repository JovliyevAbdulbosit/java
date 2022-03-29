package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Birinchi  {
    public static Integer big(Integer a , Integer b, Integer c){

        if(a>=b&&a>=c){return a;}
        if(b>=a&&b>=c){return b;}
        if(c>=b&&c>=b){return c;}
        return 0;
    }
    public static Integer pows(Integer a , Integer b){
        int c=1;
        for(int i=1; i<=b; i++){
            System.out.println(i);
            c*=a;
        }
        return c;
    }
    public static Double intlen(Long a){
        long b=10;
        while (a%b != a ){
            b*=10;
        }
        return Math.log10(b);
    }
    public static String maxLength(String[] a){
        Map<String ,Integer> dic = new HashMap<>();
        for(String i:a){
            dic.put(i , i.length());
        }
        int k=0;
        String s="";
        for(Map.Entry r:dic.entrySet()){
            if((int)r.getValue() > k){
                k=(int)r.getValue();
                s=(String)r.getKey();
            }
        }
        return k+s;
    }
    public  static String lens(String a){
        int b=0;
        String len="";
        for(String i:a.split(" ")){
            if(i.length()>b){
                b=i.length();
                len=i;
            }
        }return b + "_" + len;
    }
    public static Integer[] sort(Integer[] lis){
        boolean check = true;
        while (check){
            check=false;
            for(int i=0; i<lis.length-1; i++){
                if (lis[i + 1] < lis[i]) {
                    int d = lis[i];
                    lis[i]=lis[i+1];
                    lis[i+1]=d;
                    check = true;
                }
            }
        }
    return lis;
    }
    public static void main(String[] args) {

        // bular data type
//        Object object = new Object();
//        object ="salom";
//        object =12;
//        System.out.println(object.getClass());
//        object = new String[2];
//        System.out.println(object.hashCode());
//        Birinchi bir = new Birinchi();
//        System.out.println(bir.list((String[]) object));
//        System.out.println(big(12, 11, 10));
//        System.out.println(big(12, 12, 12));
//        System.out.println(pows(12, 2));
//        int a=1;
//        System.out.println(a++);
//        System.out.println(intlen(122334446666666666l));
//        System.out.println(maxLength(new String[]{"ass", "sasaa" , "ddwfeferfe"}));
        System.out.println(lens("salom dunyo bu eng qisqa so'z"));
        Integer[] lis={1,23,5,5,78,9,0,4,5,2,57,75};
        System.out.println(Arrays.stream(lis).toList());
        for(int i:sort(lis)){
            System.out.print(i+ " ");
        }
    }
    public String list(String[] ls){
        return ls.toString();

    }
}
