package classes.employee;

public class Main_class {
    public static void main(String[] args){
        Employee e1 = new Employee("Sharjeel",1,10000);
        e1.display_info();
        System.out.println("Bonus : " +e1.calculate_bonus());

        System.out.println();

        Manager e2 = new Manager("Abraiz", 2, 20000);
        e2.display_info();
        System.out.println( "Bonus : " +e2.calculate_bonus());

        System.out.println();
        
        Engineer e3 = new Engineer("Irtasam", 3, 30000);
        e3.display_info();
        System.out.println( "Bonus : " +e3.calculate_bonus());

        System.out.println();
        
        Intern e4 = new Intern("Ali", 4, 8000);
        e4.display_info();
        System.out.println( "Bonus : " +e4.calculate_bonus());
    }
    
}
