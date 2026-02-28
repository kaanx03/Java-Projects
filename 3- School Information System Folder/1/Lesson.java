public class Lesson {

    private final String name;
    private final String code;
    private final int credits;
    private final Teacher teacher;


    public Lesson(String name, String code, int credits,Teacher teacher) {
        this.name = name;
        this.code = code;
        this.credits = credits;
        this.teacher = teacher;
        teacher.addLesson(this); // (ai)
    }

    public String getName() {
        return name;
    }
    public String getCode(){
        return code;
    }
    public int getCredits(){
        return credits;
    }

    public void displayInfo(){
        System.out.println("Lesson Code: "+code+"\nLesson Name: "+name+"\nCredits : "+credits+"\nTeacher : "+teacher.getName());
    }



}
