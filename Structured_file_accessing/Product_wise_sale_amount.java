package Structured_file_accessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Product_wise_sale_amount {
    public static void main(String[] args) throws FileNotFoundException{
        File my_file = new File("D:\\One_drive_code\\java_projects(1)\\Structured_file_accessing\\sales_data.txt");
        Scanner read = new Scanner(my_file);
        HashMap<String,Double>Employees_data =new  HashMap<>();
            while(read.hasNextLine()){
            String line = read.nextLine();
            String arr[] = line.split("\t");
            try{
                String product = arr[3];
                int qty = Integer.parseInt(arr[4]);
                int price = Integer.parseInt(arr[5]);
                if(Employees_data.containsKey(product)){
                    Double sale_amount = Employees_data.get(product);
                    Double new_sale_amount = sale_amount+=(qty*price);
                    Employees_data.replace(product,new_sale_amount);
                }else{
                    Employees_data.put(product,(double) (qty*price) );
                }
            }catch(Exception e){
                continue;
            }
            
        }
       for (Map.Entry<String, Double> entry : Employees_data.entrySet()) {
        System.out.println(entry.getKey()+" Sales Amount : "+entry.getValue());
       }
        read.close();
    }
}
