package classes.banking;

public class Bank {
    public static void main(String[] args){
        Account a1 = new Account(20000);
        a1.deposit(5000);
        a1.display_bal();
        a1.withdraw(10000);
        a1.display_bal();
        
        System.out.println("-----Saving Account------");

        Saving a2 = new Saving(20000);
        a2.deposit(5000);
        a2.display_bal();
        a2.withdraw(100000);
        a2.display_bal();

        System.out.println("-------Current Account--------");

        Current a3 = new Current(20000);
        a3.deposit(5000);
        a3.display_bal();
        a3.withdraw(30000);
        a3.display_bal();

        System.out.println("--------Loan Account---------");

        Loan a4 = new Loan(20000);
        a4.deposit(5000);
        a4.display_bal();
        a4.withdraw();
        a4.display_bal();
    }
    
}
