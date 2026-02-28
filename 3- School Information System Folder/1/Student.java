import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student {

    final private String name;
    private ArrayList<Lesson> lessons;
    final private HashMap<Lesson,Integer> notes = new HashMap<>();


    public Student(String name){
        this.name = name;
        lessons = new ArrayList<>();
    }
    public String getName(){
        return name;
    }

    public void addLesson(Lesson lesson){
        lessons.add(lesson);
    }

    public void enterNote(Lesson lesson,int note){
        notes.put(lesson,note);
    }

    public void calculateGPA(){
        double gp;
        double totalPoints=0.0;
        int totalCredits=0;
        for(Map.Entry<Lesson,Integer> entry : notes.entrySet()){ // entry(ai)
            Lesson k = entry.getKey();
            Integer v = entry.getValue();

            if (v >= 90) gp = 4.0;
            else if (v >= 85) gp = 3.5;
            else if (v >= 80) gp = 3.0;
            else if (v >= 75) gp = 2.5;
            else if (v >= 70) gp = 2.0;
            else if (v >= 60) gp = 1.0;
            else gp = 0.0;

            totalCredits += k.getCredits();
            gp *= k.getCredits();
            totalPoints += gp;
        }

        System.out.printf("GPA : %.2f",(totalPoints/totalCredits));


    }





}
