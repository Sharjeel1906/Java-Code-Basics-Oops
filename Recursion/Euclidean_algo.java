package Recursion;
import java.util.Scanner;

public class Euclidean_algo {
    public static void main(String[] args){
       Scanner reader = new Scanner(System.in);
       System.out.println("Entre the first number : ");
       int a = reader.nextInt();
       System.out.println("Entre the second number : ");
       int b = reader.nextInt();
       int gcd = Gcd(a, b);
       System.out.println("Greated common Diviser is "+gcd);
       reader.close();
    }
    public static int Gcd(int a,int b){
        if(b==0){
            return a;
        }else{
            return Gcd(b, a%b);
        }
    }
}
