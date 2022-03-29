package com.company;

public class Voris implements BirinchiInterface {
    private int id;
    public String nameSon;
    public String nameFather;

    @Override
    public void print() {

    }

    @Override
    public int print(int i) {
        return 0;
    }

    public String allInformations(){
        return this.nameFather+" "+this.nameSon;
    }

    public static void main(String[] args) {
        Voris v=new Voris();
        Vorislik v1 = new Vorislik();
        System.out.println(v.min);
        System.out.println(v1.min);
        System.out.println(v1.bankName);
    }
}
 class Vorislik implements Ikkinchi{
    @Override
    public void print(){

    }
    @Override
    public int print(int i){
        return 1;

    }
}