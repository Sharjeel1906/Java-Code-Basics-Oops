import java.util.Scanner;
public class even_odd {
    public static void main(String []args){
        Scanner read = new Scanner(System.in);
        
        System.out.println("Entre the number to check wether it is even or odd");
        int num = read.nextInt();

        if(num%2==0){
            System.out.println("The number is even");
        }else{
            System.out.println("The number is odd");
        }
        
        System.out.println("Entre the number to count no of digits");
        int num1 = read.nextInt();
        System.out.println("Number of digits are "+count(num1));

        read.close();
    }
    public static int count(int a){
       int count=0;
       while (a!=0){
        a = a/10;
        count++;
       }
       return count;
    }
    
}
