import java.util.Calendar;
import java.util.Scanner;

public class calendar_print {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Entre the year : ");
        int year = read.nextInt();
        System.out.println("Entre the month : ");
        int month = read.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Invalid Input");
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month - 1, 1);
            int no_of_days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            int start_day_of_month = calendar.get(Calendar.DAY_OF_WEEK);
            System.out.println("Su\tMo\tTu\tWe\tTh\tFr\tSa");

            for (int i = 1; i < start_day_of_month; i++) {
                System.out.print("\t");
            }
            for (int i = 1; i <= no_of_days; i++) {
                System.out.print(i + "\t");

                if ((start_day_of_month - 1 + i) % 7 == 0) {
                    System.out.println();
                }
            }
            read.close();
        }

    }
}
