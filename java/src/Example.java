import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for(int i=1; i<number ; i++){
            if(i%3 == 0 && i%5==0){
                System.out.println("fizzBuzz");
            }
            else if(i%3 == 0 ){
                System.out.println("fizz");
            }
            else if( i%5==0){
                System.out.println("Buzz");
            }else{
                System.out.println(i);
            }
        }
    }
}
