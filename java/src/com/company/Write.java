package com.company;

import java.io.*;
import java.util.Scanner;

public class Write {
    public static void main(String[] args) throws IOException {

        while (true){
            File file = new File("D:\\text.txt");
            FileWriter fr = new FileWriter(file, true);
            Scanner sc = new Scanner(System.in);
            System.out.println("O'zbekcha so'z kirting");
            String uz = sc.nextLine();
            System.out.println("Tarjimani so'z kirting");

            String  en = sc.nextLine();
            if(uz.equals("q")||en.equals("q")){
                break;
            }else{
            fr.write(en+"-"+uz+"\n");
            fr.close();}
        }


    }
}
