import java.sql.SQLOutput;

void main(){

    boolean isActive = true;
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Lesson> lessons = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    System.out.println("Welcome to OBS!");

    while (isActive){
        System.out.println("\nPlease enter an operation:\n" +
                "0: Exit\n" +
                "1: Add Teacher\n" +
                "2: Add Lesson\n" +
                "3: Add Student\n" +
                "4: Add Lesson to Student\n" +
                "5: Enter Note\n" +
                "6: Calculate GPA\n" +
                "7: Display Teacher Info");
        System.out.print("Choice: ");

        int choice = scan.nextInt();
        scan.nextLine();

        switch (choice){
            case 0 -> isActive = false;
            case 1 ->{
                System.out.print("Enter a name : "); String name = scan.nextLine();
                teachers.add(new Teacher(name));
            }
            case 2 ->{
                System.out.print("Enter lesson name:"); String name = scan.nextLine();
                System.out.print("Enter lesson Code : "); String code = scan.nextLine();
                System.out.print("Enter lesson credits : "); int credit = scan.nextInt();scan.nextLine();
                if(credit<=0){
                    System.out.println("Credits can not be less than 0");
                    continue;
                }

                for (int i = 0; i < teachers.size() ; i++) {
                    System.out.println(i+"."+teachers.get(i).getName());;
                }
                System.out.print("Select a teacher : ");
                int index = scan.nextInt(); scan.nextLine();
                if(index<teachers.size()){
                lessons.add(new Lesson(name,code,credit,teachers.get(index)));
                }else{
                    System.out.println("Index you entered is not valid...");
                }
                }

            case 3->{
                System.out.println("Enter a name for student : ");
                String name = scan.nextLine();
                students.add(new Student(name));
            }
            case 4->{
                for (int i = 0; i <students.size() ; i++) {
                    System.out.println(i+"."+students.get(i).getName());
                }
                System.out.print("Select a student : ");int index = scan.nextInt();
                for (int i = 0; i <lessons.size() ; i++) {
                    System.out.println(i+"."+lessons.get(i).getName());
                }
                System.out.print("Select a lesson to add : ");int index2 = scan.nextInt();scan.nextLine();
                if(index<students.size() && index2<lessons.size()){
                students.get(index).addLesson(lessons.get(index2));
                }else{
                    System.out.println("Index you entered is not valid...");
                }
            }
            case 5->{
                for (int i = 0; i <students.size() ; i++) {
                    System.out.println(i+"."+students.get(i).getName());
                }
                System.out.print("Select a student : ");int index = scan.nextInt();scan.nextLine();
                for (int i = 0; i <lessons.size() ; i++) {
                    System.out.println(i+"."+lessons.get(i).getName());
                }
                System.out.print("Select a lesson to enter note : ");int index2 = scan.nextInt();scan.nextLine();
                System.out.print("Enter the note : "); int note = scan.nextInt();scan.nextLine();
                if(index<students.size() && index2<lessons.size()){
                students.get(index).enterNote(lessons.get(index2),note);
                }else{
                    System.out.println("Index you entered is not valid...");
                }
            }
            case 6->{
                for (int i = 0; i <students.size() ; i++) {
                    System.out.println(i+"."+students.get(i).getName());
                }
                System.out.print("Select a student : ");int index = scan.nextInt();scan.nextLine();
                if(index<students.size()){
                students.get(index).calculateGPA();
                }else{
                    System.out.println("Index you entered is not valid...");
                }
            }
            case 7->{
                for (int i = 0; i <teachers.size() ; i++) {
                    System.out.println(i+"."+teachers.get(i).getName());
                }
                System.out.print("Select a teacher : ");int index = scan.nextInt();scan.nextLine();
                if(index<teachers.size()){
                teachers.get(index).displayAll();
                }else{
                    System.out.println("Index you entered is not valid...");
                }
            }
        }

    }
}