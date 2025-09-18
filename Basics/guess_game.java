import java.util.Scanner;
import java.util.Random;
public class guess_game {
    public static void main(String []args){
        Random rand = new Random();
        Scanner read = new Scanner(System.in);
        int Random_num = rand.nextInt(100);
        System.out.println("Number guessing game !!");
    
        System.out.println("You have 5 attempts!!");
        
        int attempts = 5;
        while(attempts>0){
            System.out.println("Guess the number: ");
        int n = read.nextInt();
            if(n>Random_num){
                 System.out.println("Your number is High !!");
                 attempts--;
            }else if (n<Random_num){
                 System.out.println("Your number is low !!");
                 attempts--;
            }else{
                 System.out.println("You won !!");
                 break;
            }

        }
        read.close();
    }
}
