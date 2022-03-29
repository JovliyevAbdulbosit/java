package com.company;

public class Classlar {
    public int getId() {
        return id;
    }

    private int id;
    public String name;
    public int age;
// constructor
    public Classlar(int i){
        this.id =i;
    }
    //
    public String info(){
        return "name :"+this.name+" "+"age: "+this.age;
    }

    public String info(int i){
        this.id=i;
        return "id "+ i+" " +"name :"+this.name+" "+"age: "+this.age;
    }
    private int summ(int a , int b){
        return a+b ;
    }


}
 class Client {
    Long balance ;
    Classlar account;
    Client(Classlar a){
        this.account=a;

    }

    public  String info(){
        return "balance: " +this.balance+this.account.info();
    }
}