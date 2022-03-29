package com.company.config;

import java.util.ArrayList;
import java.util.List;

public class Configurations {
    public static void main(String[] args) {
        List<List<Integer>> lis = new ArrayList<>();
        List<Integer> lis1 = new ArrayList<>();

        for(int i=0; i<10; i++){
            if(i==0){ lis.add(List.of(new Integer[]{1}));}
           else if(i==1){ lis.add(List.of(new Integer[]{1, 1}));}
           else if(i==2){ lis.add(List.of(new Integer[]{1,2, 1}));}
            else {
                List<Integer> lists=lis.get(i-1);
               lis1.add(0 ,1);
               lis1.add(1);

               if(lists.size()>2) {
                   for (int j = 1; j < lists.size(); j++) {
                       lis1.add(j, lists.get(j-1) + lists.get(j));

                   }
                    List<Integer> copy = new ArrayList<>(lis1);

                   lis.add(copy);
                   lis1.clear();

               }

            }


        }
        System.out.println(lis.toString());
    }
}
