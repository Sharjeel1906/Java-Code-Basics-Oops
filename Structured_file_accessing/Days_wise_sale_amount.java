package Structured_file_accessing;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Days_wise_sale_amount {
    public static void main(String[] args) throws FileNotFoundException {
        File my_file = new File("D:\\One_drive_code\\java_projects(1)\\Structured_file_accessing\\sales_data.txt");
        Scanner read = new Scanner(my_file);
        if (read.hasNextLine())
            read.nextLine();
        HashMap<String, Double> Employees_data = new HashMap<>();
        while (read.hasNextLine()) {
            String line = read.nextLine();
            String arr[] = line.split("\t");
            String date = arr[0];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
            LocalDate real_date = LocalDate.parse(date, formatter);
            DayOfWeek day = real_date.getDayOfWeek();
            int qty = Integer.parseInt(arr[4]);
            int price = Integer.parseInt(arr[5]);
            if (Employees_data.containsKey(day.name())) {
                Double sale_amount = Employees_data.get(day.name());
                Double new_sale_amount = sale_amount += (qty * price);
                Employees_data.replace(day.name(), new_sale_amount);
            } else {
                Employees_data.put(day.name(), (double) (qty * price));
            }

        }
        for (Map.Entry<String, Double> entry : Employees_data.entrySet()) {
            System.out.println(entry.getKey() + " Sales Amount : " + entry.getValue());
        }
        read.close();
    }
}
