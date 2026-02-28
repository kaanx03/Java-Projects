import java.util.ArrayList;

public class Customer {

    private boolean isActive= false;
    private int passTryLeft = 3;
    private double balance;
    private final String password;
    private final int accountNumber;
    private final ArrayList<String> transactions = new ArrayList<>();


    public Customer(int accountNumber,double balance,String password){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.password = password;
    }

    public int getAccountNumber(){return accountNumber;}
    public boolean isActive(){
        return isActive;
    }
    public void setActive(boolean status){isActive = status;}

    public int getPassTryLeft(){return passTryLeft;}


   public void checkPassword(String password){
       if (this.password.equals(password)) {
           System.out.println("You entered correct password");
           isActive = true;
       }else {
           passTryLeft--;
           System.out.println("You entered wrong password (Try Left : "+passTryLeft+")");
       }
    }


    public void displayBalance(){
        System.out.println("Balance is "+balance);
    }

    public void depositMoney(double money){
        balance += money;
        System.out.println("New balance is "+balance);
        transactions.add("$"+money+" is deposited");
    }
    public void withdrawMoney(double money){
        if(balance>=money){
            System.out.println("New balance is "+balance);
            balance -= money;
            transactions.add("$"+money+" is withdrawed");
        }else{
            System.out.println("Insufficient Balance!");
        }
    }

    public void displayTransactionHistory(){
        for(String transaction : transactions){
            System.out.println(transaction);
        }
    }

}
