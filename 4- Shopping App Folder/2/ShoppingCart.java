import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<CartItem> items = new ArrayList<>();


    public void addItem(Product product, int quantity){
        items.add(new CartItem(product,quantity));
    }
    public void removeItem(int choice){
        items.remove(choice);
    }
    public ArrayList<CartItem> getItems(){
        return items;
    }


    public void displayCart(){
            System.out.println("- - - CART ITEMS - - - ");
        for (int i=0;i<items.size();i++){
            System.out.print((i+1)+"."+items.get(i).getProduct().getName()+":"+items.get(i).getQuantity()+" ");
        }
        System.out.println("\n- - -            - - - ");
    }

    public double calculateTotal(){
        double total = 0;
        for(CartItem item : items){
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return  total;
    }

}
