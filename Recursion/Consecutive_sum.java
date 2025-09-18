package Recursion;
import java.util.Scanner;

public class Consecutive_sum {
    public static void main(String[] args){
       Scanner reader  = new Scanner(System.in);
       System.out.println("Please entre the range of numbers : ");
       int range = reader.nextInt();
       System.out.println("The sum of consecutive numbers is : "+sum(range));
       reader.close();
    }
    public static int sum(int num){
        if(num==1){
            return 1;
        }else{
            return num+ sum(num-1);
        }
    }
}
