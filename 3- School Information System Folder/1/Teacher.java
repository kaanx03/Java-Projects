import java.util.ArrayList;

public class Teacher {

    private String name;
    private final ArrayList<Lesson> lessons;


    public Teacher(String name) {
        this.name = name;
        lessons = new ArrayList<>();
    }
    public String getName(){
        return this.name;
    }

    public void addLesson(Lesson lesson){
        lessons.add(lesson);
    }

    public void displayAll(){
        System.out.println("Name : "+name+"\n* * * * * * * * * * * * * ");
        System.out.println("The lessons teacher gives: ");
        for (Lesson lesson : lessons){
            System.out.println("("+lesson.getCode()+")"+lesson.getName()+": "+lesson.getCredits()+" credits");
        }
        System.out.println("* * * * * * * * * * * * *");


    }

}
