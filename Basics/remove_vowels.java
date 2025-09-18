import java.util.Scanner;

public class remove_vowels {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Entre the string: ");
        String str = read.nextLine();

        String new_str = "";

        for (int i = 0; i < str.length() - 1; i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                continue;
            }else{
                new_str += ch;
            }
        }
        System.out.println("New strings is : "+new_str);
        read.close();
    }
}
