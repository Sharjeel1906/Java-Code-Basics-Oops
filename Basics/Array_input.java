import java.util.Scanner;
public class Array_input {
    public static void main(String []args){
        Scanner read = new Scanner(System.in);

         // System.out.println("Entre the size of array");
         // int size = read.nextInt();
         int[] arr = {4,6,2,9};
         // int[] arr = new int[size];
         // System.out.println("Entre the values of array");
         // for(int i=0;i<size;i++){
         //     int val = read.nextInt();
         //     arr[i] = val;
         // }
         // System.out.println("Entre the value You want to find:");
         // int val = read.nextInt();
        //System.out.println("The values of array are:");
        for (int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
               if(arr[i]==arr[j]){
                 System.out.println("Duplicate found at index:"+j+1);
                 arr[i] = -1;
               }
            }
           
        
           // System.out.println(arr[i]);
        }
        
        read.close();
    }
    
}
