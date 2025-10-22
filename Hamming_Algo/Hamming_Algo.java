import java.util.Scanner;

public class Hamming_Algo {

    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        // System.out.println("Please input the data:");
        // int num = read.nextInt();
        String str = "20100111001";
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }
        System.out.print("Digits stored in array: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }
        read.close();
    }
}
