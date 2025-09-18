package classes.store_employee;

public class Store_Employee {
    String First_name;
    String Last_name;
    String Social_sec_num;
    double gross_sale;
    double commision_rate;

    Store_Employee(String fname,String lname,String socialnum){
       First_name = fname;
       Last_name = lname;
       Social_sec_num = socialnum;
    }
    public void get_gross_sale(double sale){
       if(sale>=0.0){
        gross_sale=sale;
       }else{
        System.out.println("Please entre correct value of gross sale");
       }
    }
    public void get_comm_rate(double rate){
        if(rate>0.0 && rate<1.0){
            commision_rate = rate;
        }
        else{
            System.out.println("Please entre correct value of commison rate");
        }
    }
    public double earnings(){
        return commision_rate * gross_sale;
    }
    public void display(){
        System.out.println("First Name : "+First_name);
        System.out.println("Last Name : "+Last_name);
        System.out.println("Social Security Num : "+Social_sec_num);
        System.out.println("Gross sale: "+gross_sale);
        System.out.println("Commision Rate : "+commision_rate);
        System.out.println("Earnings: "+earnings());   
    }
}
