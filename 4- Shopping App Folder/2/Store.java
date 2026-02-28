import java.util.ArrayList;

public class Store {
    private String name;
    private final ArrayList<Product> products;
    private ArrayList<Customer> customers;

    public Store(){
        customers = new ArrayList<>();
        products = new ArrayList<>();
        products.add(new Product("Apple", 1.99));
        products.add(new Product("Milk", 3.49));
        products.add(new Product("Bread", 2.75));
        products.add(new Product("Butter", 4.99));
        products.add(new Product("Eggs", 5.49));
        products.add(new Product("Cheese", 6.99));
        products.add(new Product("Chicken", 8.99));
        products.add(new Product("Rice", 3.25));
        products.add(new Product("Pasta", 2.49));
        products.add(new Product("Orange Juice", 4.75));
    }

    public void displayProducts(){
        System.out.println("* * * * * * *");
         for (int i=0;i<products.size();i++){
            System.out.println((i+1)+"."+products.get(i).getName()+"("+products.get(i).getStock()+")");
         }
        System.out.println("* * * * * * *");
    }

    public Product getProducts(int choice){
        return  products.get(choice);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

}
