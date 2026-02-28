void main(){
    // quiz app

    String[] questions = {
            "1) Which data type is used to create a variable that should store text?\n" +
                    "A) myString\nB) string\nC) String\nD) Txt",

            "2) Which method is used to print text to the console in Java?\n" +
                    "A) System.out.println()\nB) print()\nC) echo()\nD) console.log()",

            "3) Which keyword is used to define a class in Java?\n" +
                    "A) define\nB) class\nC) object\nD) new",

            "4) Which operator is used for addition in Java?\n" +
                    "A) *\nB) -\nC) +\nD) /",

            "5) What is the correct way to create an array of integers?\n" +
                    "A) int arr = new int[5];\nB) int[] arr = new int[5];\nC) array int arr = 5;\nD) int arr[] = 5;",

            "6) Which loop is guaranteed to execute at least once?\n" +
                    "A) for\nB) while\nC) do-while\nD) foreach",

            "7) Which keyword is used to inherit a class?\n" +
                    "A) implement\nB) extends\nC) inherits\nD) super",

            "8) Which of these is a valid boolean value?\n" +
                    "A) True\nB) FALSE\nC) true\nD) 1",

            "9) Which exception occurs when dividing by zero?\n" +
                    "A) NullPointerException\nB) ArithmeticException\nC) IOException\nD) NumberFormatException",

            "10) Which keyword is used to stop a loop?\n" +
                    "A) stop\nB) exit\nC) break\nD) return"
    };

    String[] answers = {
            "C", "A", "B", "C", "B",
            "C", "B", "C", "B", "C"
    };

    int[] userWrongAnswersTemp = new int[10];


    Scanner scan = new Scanner(System.in);
    String answer;
    int correctCounter = 0;
    int wrongCounter = 0;
    System.out.println("******* Welcome to Quiz App *******");

    for (int i = 0; i <questions.length; i++) {
        System.out.println(questions[i]);
        answer = scan.nextLine().toUpperCase();

        if(answers[i].equals(answer)){
            correctCounter++;
        }else{
            wrongCounter++;
            userWrongAnswersTemp[i] = (i+1);
        }
    }

    // Transfering the temp array to real one with smaller size.
    int[] userWrongAnswers = new int[wrongCounter];
    int index = 0;
    for (int i = 0; i < userWrongAnswersTemp.length; i++) {
        if(userWrongAnswersTemp[i] != 0){
            userWrongAnswers[index] = userWrongAnswersTemp[i];
            index++;
        }
    }

    System.out.println("Score :"+correctCounter+"/10");
    if(wrongCounter >0){
        for (int wrong : userWrongAnswers){
            System.out.print(wrong+". ");
        }
        System.out.print("questions are wrong.\n");
    }




}