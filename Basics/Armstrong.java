import java.util.Scanner;
public class Armstrong {
    public static void main(String []args){
         Scanner read = new Scanner(System.in);

         System.out.println("Check wether the number is armstrong Or not!!");
         System.out.println("Entre the number");

         int num = read.nextInt();
         int dup = num;
         String str = Integer.toString(num);
         int len = str.length();
         double sum=0;
         while (num!=0) {
            int digit =num%10;
            num = num/10; 
            sum += Math.pow(digit, len);
         }
         if (sum==dup){
            System.out.println("The number is Armstrong");
         }else{
            System.out.println("The number is not Armstrong");
         }
         read.close();

}}
