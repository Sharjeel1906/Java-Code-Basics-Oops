import java.util.Scanner;

public class binary_search {

    public static int s(int[] arr, int target) {
    
    int first = 0;
    int last = arr.length-1;
    int midddle = (first+ last)/2;
    
    for(int i = 0 ;i < arr.length;i++){
         
         if (arr[midddle] == target) {
             return midddle;
            }
         else if(arr[midddle] < target){
            first= midddle;  
         }
         else{
            last = midddle;
         } midddle = (first + last)/2;
    }
    return -1;    
       }
    public static void main(String[] args) {
        int[] array = {1, 4, 5, 7, 8, 14, 16, 19,21};

        Scanner input = new Scanner(System.in);
        int target = input.nextInt();

        System.out.println(s(array, target));
        input.close();
    }
}
