void main(){

    Scanner scan = new Scanner(System.in);
    System.out.print("How many students are there : ");
    int numOfStudent = scan.nextInt();
    scan.nextLine();
    String name;
    double midtermNote,finalNote;
    String[] names = new String[numOfStudent];
    double[][] notes = new double[numOfStudent][2];
    boolean[] hasPassed = new boolean[numOfStudent];
    boolean isNoteValid;
    double highestGrade=0;
    double note;

    for (int i = 0; i < names.length; i++) {
        System.out.print("Enter the "+(i+1)+". name : ");
        name = scan.nextLine();
        names[i] = name;
        isNoteValid = false;
        while (!isNoteValid){
            System.out.print("Midterm : ");
            midtermNote = scan.nextDouble();
            System.out.print("Final : ");
            finalNote = scan.nextDouble();
            scan.nextLine();

            if(midtermNote<0 || midtermNote>100 || finalNote<0 || finalNote>100){
                System.out.println("Notes should be between 0-100");
            }else {
                notes[i][0] = midtermNote;
                notes[i][1] = finalNote;
                note = (midtermNote * 0.4 + finalNote * 0.6);
                hasPassed[i] = note >= 50;

                if(note > highestGrade)
                    highestGrade = note;

                isNoteValid =  true;

            }
        }

    }
    for (int i = 0; i < numOfStudent ; i++) {
        System.out.print("Name:"+names[i]+" Note:"+(notes[i][0]*0.4+notes[i][1]*0.6)+" Passed :"+hasPassed[i]+"\n");
    }
    System.out.println("Highest Grade is "+highestGrade);







}