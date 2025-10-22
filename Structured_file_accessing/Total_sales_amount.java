package Structured_file_accessing;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Total_sales_amount {
    public static void main(String[] args)throws FileNotFoundException{
        File my_file = new File("D:\\One_drive_code\\java_projects(1)\\Structured_file_accessing\\sales_data.txt");
        Scanner read = new Scanner(my_file);
        double total = 0;
        while(read.hasNextLine()){
            String line = read.nextLine();
            String arr[] = line.split("\t");
            try{
                int qty = Integer.parseInt(arr[4]);
                int price = Integer.parseInt(arr[5]);
                total+=(qty*price);
            }catch(Exception e){
                continue;
            }
            
        }
        System.out.println("Total Sales = "+total);
        read.close();
    }
}
