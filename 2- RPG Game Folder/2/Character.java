public class Character {

    private final String name;
    private int health=100;
    private final Inventory inventory = new Inventory();

    public Character(String name){
        this.name = name;
    }

    public String getName(){
        return  name;
        }
    public double getHealth(){return  health;}
    public Inventory getInventory(){return inventory;}

    public void changeHealth(int effect){health += effect;}


}
