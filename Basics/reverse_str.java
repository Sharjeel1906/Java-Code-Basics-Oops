import java.util.Scanner;
public class reverse_str {
    public static void main(String []args){
        Scanner read = new Scanner(System.in);
        System.out.println("Entre the string : ");
        String str = read.nextLine();
        int len = str.length();
        String rev_string = "";
        for(int i =len ;i>0;i--){
            rev_string +=str.charAt(i-1);
        }
        System.out.println("Reversed string: "+rev_string);
        if(rev_string.equals(str)){
          System.out.println("Given string is polindrome");
        }else{
            System.out.println("Given string is not polindrome");
        }
        read.close();
    }
}
