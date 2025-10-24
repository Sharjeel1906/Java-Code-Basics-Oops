package Structured_file_accessing;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Challange_menu_display {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        File my_file = new File("D:\\One_drive_code\\java_projects(1)\\Structured_file_accessing\\sales_data.txt");

        Scanner header = new Scanner(my_file);
        String line = header.nextLine();
        header.close();
        String[] headers =line.split("\t");

        System.out.println("Enter which sale amount you want to calculate: ");
        System.out.println("1. Total Sales Amount");
        for (int i = 0; i < headers.length - 2; i++) {
            System.out.println((i + 2) + ". " + headers[i] + " Wise Sale Amount");
        }
        int Userchoice = input.nextInt();
        if (Userchoice == 1) {
            System.out.println("Total Sales Amount Of Given Data is: " + calculate_total_sum(my_file));
        } else {
            int columnIndex = Userchoice - 2;
            HashMap<String, Double> data = Calculate_specific(my_file, columnIndex);

            for (Map.Entry<String, Double> entry : data.entrySet()) {
                System.out.println(entry.getKey() + " Wise Sales Amount : " + entry.getValue());
            }
        }
        input.close();
    }

    public static HashMap<String, Double> Calculate_specific(File myFile, int choice) throws Exception {
        Scanner read = new Scanner(myFile);
        if (read.hasNextLine())
            read.nextLine();

        HashMap<String, Double> data = new HashMap<>();
        while (read.hasNextLine()) {
            String line = read.nextLine();
            String arr[] = line.split("\t");
            String param;
            if (choice == 0) {
                    String date = arr[0];
                    String[] months = date.split("-");
                    param = months[1];
            } else {
                param = arr[choice];
            }
                int qty = Integer.parseInt(arr[4]);
                int price = Integer.parseInt(arr[5]);
                double sale = qty * price;

                data.put(param, data.getOrDefault(param, 0.0) + sale);
        }
        read.close();
        return data;
    }

    public static Double calculate_total_sum(File myFile) throws Exception {
        Scanner read = new Scanner(myFile);
        if (read.hasNextLine())
            read.nextLine();

        double total = 0;
        while (read.hasNextLine()) {
            String line = read.nextLine();
            String arr[] = line.split("\t");
            try {
                int qty = Integer.parseInt(arr[4]);
                int price = Integer.parseInt(arr[5]);
                total += (qty * price);
            } catch (Exception e) {
                continue;
            }
        }
        read.close();
        return total;
    }
}
