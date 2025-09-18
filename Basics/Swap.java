import java.util.Scanner;

public class Swap {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Entre the 1st number :");
        int num1 = read.nextInt();

        System.out.println("Entre the 2nd number :");
        int num2 = read.nextInt();

        int arr[] = { num1, num2 };
        swap(arr);
        System.out.println("Value of 1st number is " + arr[0]);
        System.out.println("Value of 2nd number is " + arr[1]);
        read.close();
    }

    public static void swap(int arr[]) {
        int c = arr[0];
        arr[0] = arr[1];
        arr[1] = c;
    }

}
