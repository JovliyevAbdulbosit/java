package com.company;
// abstractsiya
abstract class  Person {
    String geder;
    String name;
     public abstract String profession();

}
class Programmer extends Person{



    public Programmer(String i){
        this.name =i;
    }
    @Override
    public String profession() {
        return "bu odam dasturlash bilan shug'ilanadi ";
    }
    public String info(){
        return this.geder + " " +this.name ;
    }

    public static void main(String[] args) {
      Programmer i = new Programmer("abdulbosit") ;

        i.geder = "erkak";
        System.out.println(i.info());

    }
}