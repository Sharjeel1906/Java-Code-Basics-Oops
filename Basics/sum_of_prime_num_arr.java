import java.util.Scanner;
public class sum_of_prime_num_arr {
    public static void main(String []args){
        Scanner read  = new Scanner(System.in);
        int[] arr = {3,4,6,11,12,7};
        String str="";
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(is_prime(arr[i])){
               sum+=arr[i];
               str+=arr[i]+"+";
            }
        }
        System.out.println(str + " = "+sum);
        read.close();
    }

    public static boolean is_prime(int num) {
    if (num <= 1) {
        return false; 
    }

    for (int i = 2; i <= num / 2; i++) {
        if (num % i == 0) {
            return false; 
        }
    }
    return true; 
}


}
