package Structured_file_accessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Employee_wise_sale_amount {
    public static void main(String[] args) throws FileNotFoundException{
        File my_file = new File("D:\\One_drive_code\\java_projects(1)\\Structured_file_accessing\\sales_data.txt");
        Scanner read = new Scanner(my_file);
        HashMap<String,Double>Employees_data =new  HashMap<>();
            while(read.hasNextLine()){
            String line = read.nextLine();
            String arr[] = line.split("\t");
            try{
                String id = arr[2];
                int qty = Integer.parseInt(arr[4]);
                int price = Integer.parseInt(arr[5]);
                if(Employees_data.containsKey(id)){
                    Double sale_amount = Employees_data.get(id);
                    Double new_sale_amount = sale_amount+=(qty*price);
                    Employees_data.replace(id,new_sale_amount);
                }else{
                    Employees_data.put(id,(double) (qty*price) );
                }
            }catch(Exception e){
                continue;
            }
            
        }
       for (Map.Entry<String, Double> entry : Employees_data.entrySet()) {
        System.out.println("Employee Id : "+entry.getKey());
        System.out.println("Employee Sales Amount : "+entry.getValue());
       }
        read.close();
    }
}
