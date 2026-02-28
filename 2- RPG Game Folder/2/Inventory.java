import java.util.ArrayList;

public class Inventory {
    private final ArrayList<Item> items = new ArrayList<>();

    public void add(Item item){
        items.add(item);
    }

    public void displayItems(){
        for (Item item : items){
            System.out.println(item.getName());
        }
    }

    public ArrayList<Item> getItems(){
        return items;
    }
}
