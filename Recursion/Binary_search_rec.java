package Recursion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Binary_search_rec {
    public static void main(String[] args){
        Scanner reader  = new Scanner(System.in);
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
        System.out.println("Please Entre the number you want to search: ");
        int num = reader.nextInt();
        int low = 0;
        int high = arr.size()-1;
        System.out.println("Number founded at index "+search(num,low,high,arr)+" of sorted array");
        reader.close();
    }
    public static int search(int num,int low,int high,ArrayList<Integer> arr){
        int mid = (low+high)/2;
       if (arr.get(mid)==num){
        return mid;
       }else if (arr.get(mid)<num){
        return search(num, 1+mid, high, arr);
       }else{
        return search(num, low, mid-1, arr);
       }
    }
}
