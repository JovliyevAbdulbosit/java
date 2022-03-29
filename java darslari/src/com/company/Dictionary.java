package com.company;

import java.sql.SQLOutput;
import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Map<String ,String> dic = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("tilni tanlang");
            System.out.println("choose Language");
            String lang = sc.nextLine();
            if(lang.equals("en")){
                System.out.println("enter word");
                String inputWord = sc.nextLine();
                for(Map.Entry word:dic.entrySet()){
                 String sen =   (String)word.getKey();
                 sen = sen.toLowerCase();
                    if(sen.startsWith(inputWord.toLowerCase())){
                        list.add((String)word.getKey() + "-" + (String)word.getValue());
                    }
                }
                if(!list.isEmpty()){
                    System.out.println(list.toString());
                    list.clear();

                }else {
                    System.out.println("hech narsa topilmadi");
                }
            }
            else if(lang.equals("uz")){
                System.out.println("so'zni kiriting");
                String inputWord = sc.nextLine();
                for(Map.Entry word:dic.entrySet()){
                    String sen =   (String)word.getValue();
                    sen = sen.toLowerCase();
                    if(sen.startsWith(inputWord.toLowerCase())){
                        list.add((String)word.getValue()+ "-" +(String)word.getKey());
                    }
                }
                if(!list.isEmpty()){
                    System.out.println(list.toString());
                    list.clear();

                }else {
                    System.out.println("hech narsa topilmadi");
                }

            }
        }


    }


}
