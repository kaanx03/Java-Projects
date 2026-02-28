import java.util.ArrayList;

public class Item {

 private String name;
 private final ArrayList<Feature> features = new ArrayList<>();

 public Item(String name){
     this.name = name;
 }
 public String getName(){
     return name;
 }
 public void addFeature(Feature feature){
     features.add(feature);
}

 public int use(Feature feature){
    return feature.getEffect();
}

public void displayFeatures(){
    System.out.println("Item Features:");
     for (Feature feature :features){
         System.out.println("-"+feature.getName());
     }
}
}
