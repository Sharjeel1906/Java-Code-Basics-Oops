package classes.banking;

class Account {
    public double balance;
    
    public Account(double bal){
       balance = bal;
    }
    public void deposit(double amount){
        balance+=amount;
    }
   
    public void display_bal(){
        System.out.println("Balance : "+balance);
    }
    public void withdraw(double amount){
           balance-=amount;
           System.out.println("You withdraw : "+amount);
    }
}
class Saving extends Account{
    Saving( double bal){
       super(bal);
    }
    public void withdraw(double amount){
        if(amount<=balance){
            System.out.println("You withdraw : "+amount);
            balance-=amount;
        }
        else{
            System.out.println("Insufficient Balance !!");
        }
    }
}
class Current extends Account{
    Current( double bal){
       super(bal);
    }
    public void withdraw(double amount){
        if(amount<=balance){
            System.out.println("You withdraw : "+amount);
            balance-=amount;
        }
        else{
            if(amount<=balance+10000){
                balance-=amount;
                System.out.println("You withdraw : "+amount);
            }
            else{
                System.out.println("You can only withdraw upto 10,000");
            }
        }
    }
}
class Loan extends Account{
    Loan(double bal){
        super(bal);
    }
    public void withdraw(){
        System.out.println("Withdraw not allowed !! You can only deposit amount to pay Loan !!");
    }
}
