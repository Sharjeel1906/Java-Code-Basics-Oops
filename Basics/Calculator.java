import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Entre the first number:");
        int num1 = read.nextInt();

        System.out.println("Entre the second number:");
        int num2 = read.nextInt();

        System.out.println("Entre the operator:");

        String oper = read.next();

        int sum, product, div, subt;

        if (oper.equals("+")) {
            sum = num1 + num2;
            System.out.println("Sum is " + sum);
        } else if (oper.equals("-")) {
            subt = num1 - num2;
            System.out.println("Diffrence is " + subt);
        } else if (oper.equals("*")) {
            product = num1 * num2;
            System.out.println("Product is " + product);
        } else if (oper.equals("/")) {
            div = num1 / num2;
            System.out.println("Division  is " + div);
        } else {
            System.out.println("Invalid input");
        }
        read.close();

    }
}
