import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Binary_search {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        boolean found=false;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(76);
        arr.add(56);
        arr.add(82);
        arr.add(34);
        arr.add(53);
        arr.add(21);
        arr.add(15);
        arr.add(63);
        Collections.sort(arr);
        System.out.println("Sorted Array is :");
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
        System.out.println("Please entre the number you want to search:");
        int num = read.nextInt();
        int low=0;
        int hight = arr.size()-1;
        while (!found) {
        int mid = (low+hight)/2;
        if(arr.get(mid)==num){
          System.out.println("Founded at index "+mid+" of sorted array");
          found=true;
        }else if(arr.get(mid)<num){
            low=1+mid;
        }else{
            hight = mid-1;
        }
        read.close();
        }
       
    }
}
