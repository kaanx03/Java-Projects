public class Product {
    private String name;
    private double price;
    private int stock = 10;

    public Product(String name,double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getStock(){
        return stock;
    }
    public void setStock(int quantity){ stock-= quantity;}
}
