package classes.store_employee;

public class Empl_Main {
    public static void main(String[] args){
        Store_Employee e1 = new Store_Employee("Sharjeel", "Ahmed", "a11010");
        e1.get_comm_rate(0.8);
        e1.get_gross_sale(5.5);
        e1.display();
   }
}
