package com.company;

public class AvtoSalon {
    private long id;
    public String carName ;
    public String color ;
    public int price ;
    public void info(){
        System.out.println("carname: "+this.carName+" " + "color: " +this.color);
    }


    public static void main(String[] args){
        AvtoSalon spark = new AvtoSalon();
        spark.carName="spark";
        spark.color = "qora";
        spark.info();
    }
}
