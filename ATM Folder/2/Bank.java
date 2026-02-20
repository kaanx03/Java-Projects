import java.util.ArrayList;

public class Bank {

    private String name;
    private double totalBalance;
    private final ArrayList<Customer> customers = new ArrayList<>();

    public Bank(String name){
        this.name = name;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public Customer findCustomer(int accountNumber){
        for(Customer c : customers){
            if(c.getAccountNumber() == accountNumber){
                return c;
            }
        }
        return null; // bulunamazsa
    }



}
