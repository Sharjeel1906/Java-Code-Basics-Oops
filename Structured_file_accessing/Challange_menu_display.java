package Structured_file_accessing;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Challange_menu_display {
    public static void main(String[] args)throws Exception{
        Scanner input  = new Scanner(System.in);
        File my_file = new File("D:\\One_drive_code\\java_projects(1)\\Structured_file_accessing\\sales_data.txt");
        Scanner headerReader = new Scanner(my_file);
        String headerLine = headerReader.nextLine();
        headerReader.close();
        String[] headers = headerLine.split("\t");

        System.out.println("Enter which sale amount you want to calculate: ");
        System.out.println("1. Total Sales Amount");
        int index = 2;
        for (int i = 0; i < headers.length - 2; i++) {
            System.out.println(index + ". " + headers[i] + " Wise Sale Amount");
            index++;
        }
        int Userchoice = input.nextInt();

        if (Userchoice == 1) {
            System.out.println("Total Sales Amount Of Given data is " + calculate_total_sum(my_file));
        } else if (Userchoice == 2) {
            HashMap<String, Double> data = Calculate_specific(my_file, 0);
            for (Map.Entry<String, Double> entry : data.entrySet()) {
                System.out.println(entry.getKey() + " Wise Sales Amount : " + entry.getValue());
            }
        } else if (Userchoice == 3) {
            HashMap<String, Double> data = Calculate_specific(my_file, 1);
            for (Map.Entry<String, Double> entry : data.entrySet()) {
                System.out.println(entry.getKey() + " Wise Sales Amount : " + entry.getValue());
            }
        } else if (Userchoice == 4) {
            HashMap<String, Double> data = Calculate_specific(my_file, 2);
            for (Map.Entry<String, Double> entry : data.entrySet()) {
                System.out.println(entry.getKey() + " Wise Sales Amount : " + entry.getValue());
            }
        } else if (Userchoice == 5) {
            HashMap<String, Double> data = Calculate_specific(my_file, 3);
            for (Map.Entry<String, Double> entry : data.entrySet()) {
                System.out.println(entry.getKey() + " Wise Sales Amount : " + entry.getValue());
            }
        }
        input.close();
    }
    public static HashMap<String,Double> Calculate_specific(File myFile,int choice) throws Exception{
        Scanner read = new Scanner(myFile);
        String param;
        HashMap<String,Double>data =new  HashMap<>();
            while(read.hasNextLine()){
            String line = read.nextLine();
            String arr[] = line.split("\t");
            if(choice==0){
                try{String date = arr[0];
                String[] months = date.split("-");
                param = months[1];
                }catch(Exception e){
                    continue;
                }
                
            }else{
                param = arr[choice];
            }
            try{
                int qty = Integer.parseInt(arr[4]);
                int price = Integer.parseInt(arr[5]);
                if(data.containsKey(param)){
                    Double sale_amount = data.get(param);
                    Double new_sale_amount = sale_amount+=(qty*price);
                    data.replace(param,new_sale_amount);
                }else{
                    data.put(param,(double) (qty*price) );
                }
            }catch(Exception e){
                continue;
            }
        }
        read.close();
        return data;
    }
    public static Double calculate_total_sum(File myFile) throws Exception{
         Scanner read = new Scanner(myFile);
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
        read.close();
        return total;
    }
}