package classes.University_mang_system; 

class Person {
    String name;
    String phoneNumber; 
    String adress;
    String email;

    public Person(String name, String phoneNumber, String adress, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.email = email;
    }
    
    public String to_String() {
        return "name of class = Person\nName of person = " + name;
    }
}

class Student extends Person {
    public static final String FIRST_YEAR = "First Year";
    public static final String SECOND_YEAR = "Second Year";
    public static final String THIRD_YEAR = "Third Year";
    public static final String FINAL_YEAR = "Final Year";

    String status;

    public Student(String name, String phoneNumber, String adress, String email, String status) {
        super(name, phoneNumber, adress, email);
        this.status = status;
    }

    @Override
    public String to_String() {
        return "name of class = Student\nName of student = " + name;
    }
}

class Employee extends Person {
    String office;
    Double salary;

    public Employee(String name, String phoneNumber, String adress, String email, String office, Double salary) {
        super(name, phoneNumber, adress, email);
        this.office = office;
        this.salary = salary;
    }
    
    @Override
    public String to_String() {
         return "name of class = Employee\nName of employee = " + name;
    }
}

class Facalty extends Employee {
    int office_hour;
    String rank;

    public Facalty(String name, String phoneNumber, String adress, String email, String office, Double salary, int office_hour, String rank) {
        super(name, phoneNumber, adress, email, office, salary); 
        this.office_hour = office_hour;
        this.rank = rank;
    }
    
    @Override
    public String to_String() {
         return "name of class = Facalty\nName of Facalty = " + name;
    }
}

class Staff extends Employee {
    String title;

    public Staff(String name, String phoneNumber, String adress, String email, String office, Double salary, String title) {
        super(name, phoneNumber, adress, email, office, salary);
        this.title = title;
    }
    
    @Override
    public String to_String() {
         return "name of class = Staff\nName of Staff = " + name;
    }
}

public class TestProgram {
    public static void main(String[] args) {
        Person person = new Person("John Doe", "555-0001", "Los Angeles", "john@mail.com");
        Employee employee = new Employee("Bob Johnson", "555-0003", "karachi", "bob@work.com", "corporate", 20000.0);
        Student st = new Student("Ahmed", "555-0002", "New York", "ahmed@edu.com", Student.FIRST_YEAR);
        Facalty facalty = new Facalty("Daniyal", "555-0004", "Boston", "daniyal@uni.edu", "Main Campus", 80000.0, 15, "Associate Professor");
        Staff staff = new Staff("Ali", "555-0005", "karachi", "ali@admin.com", "Administration", 45000.0, "Manager");

        System.out.println("--- Invoking to_String() Methods ---");
        
        System.out.println(person.to_String());
        System.out.println("---");
        System.out.println(st.to_String());
        System.out.println("---");
        System.out.println(employee.to_String());
        System.out.println("---");
        System.out.println(facalty.to_String());
        System.out.println("---");
        System.out.println(staff.to_String());
    }
}