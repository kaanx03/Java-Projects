public class Customer {
    private String name;
    private double money;
    private ShoppingCart cart;

    public Customer(String name,double money){
        this.name = name;
        this.money=money;
        this.cart = new ShoppingCart();
    }

    public String getName() {
        return name;
    }
    public double getMoney(){
        return money;
    }
    public void setMoney(double money){
        this.money -= money;
    }

    public ShoppingCart getCart(){
        return cart;
    }

}
