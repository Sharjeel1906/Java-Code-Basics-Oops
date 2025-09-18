package classes.employee;

// Calculate bonus() is override function and this is called compile time polymorphism

class Employee {
    private static int number_of_employee=0;

    public String name ;
    public int id ;
    public double salary;

    public Employee(){
        number_of_employee+=1;
    }
    public Employee(String name,int id ,double salary){
        number_of_employee+=1;
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    public int get_emp_no(){
        return number_of_employee;
    }
    public void display_info(){
        System.out.println("Name : "+name);
        System.out.println("Id : "+id);
        System.out.println("Salary : "+salary);
    }
    public double calculate_bonus(){
        return (salary/100)*10;
    }
}
class Manager extends Employee {
    
    public Manager(String name, int id, double salary) {
        super(name, id, salary);
    }
    public double calculate_bonus(){
        return (salary/100)*20;
    }
}
class Engineer extends Employee{
    public Engineer(String name,int id,double salary){
        super(name,id,salary);
    }
    public double calculate_bonus(){
        return (salary/100)*15;
    }
}
class Intern extends Employee{
    public Intern(String name,int id,double salary){
        super(name,id,salary);
    }
    public double calculate_bonus(){
        return 2000;
    }
}    