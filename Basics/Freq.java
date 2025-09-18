import java.util.Scanner;
public class Freq {
    public static void main(){
        Scanner read = new Scanner(System.in);
        int[] arr = {1,2,4,3,5,4,2,8};
        System.out.println("Entre the value to find frequency");
        int val = read.nextInt();
        int freq = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==val){
               freq++;
            }
        }
        System.out.println("The frequency of "+val+" is "+freq);
        read.close();
    }
}
