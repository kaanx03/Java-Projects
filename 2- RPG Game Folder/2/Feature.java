public class Feature {

    private String name;
    private int effect;

    public String getName(){return name;}
    public int getEffect(){return effect;}  // + heal - damage verme manasında

    public Feature(String name,int effect){
        this.name = name;
        this.effect = effect;
    }
}
