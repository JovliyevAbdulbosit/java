package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class ReadFileTxt {
    public static void main(String[] args) throws Exception {

        File file = new File("D:\\text.txt");


        BufferedReader br = new BufferedReader(new FileReader(file));


        String st;
        List<String> list = new ArrayList<>();
        Map<String ,String> dic = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while ((st = br.readLine()) != null) {
                String[] lists = st.split("-");
                dic.put(lists[0] , lists[1]);
            }



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
