package quintanilla00025815.pm_parcial_1;


public class QuestionLibrary {

    private String mQuestions [] = {
            "Which part of the plant holds it in the soil?",
            "This part of the plant absorbs energy from the sun.",
            "This part of the plant attracts bees, butterflies and hummingbirds.",
            "The _______ holds the plant upright.",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
    };


    private String mChoices [][] = {
            {"Roots", "Stem", "Flower"},
            {"Fruit", "Leaves", "Seeds"},
            {"Bark", "Flower", "Roots"},
            {"Bark", "Flower", "Roots"},
            {"Bark", "Flower", "Roots"},
            {"Bark", "Flower", "Roots"},
            {"Bark", "Flower", "Roots"},
            {"Bark", "Flower", "Roots"},
            {"Bark", "Flower", "Roots"},
            {"Bark", "Flower", "Roots"},
            {"Bark", "Flower", "Roots"},
            {"Bark", "Flower", "Roots"},
            {"Flower", "Leaves", "Stem"},
            {"Bark", "Flower", "Roots"},
            {"Bark", "Flower", "Roots"},
            {"Bark", "Flower", "Roots"},
            {"Bark", "Flower", "Roots"},
            {"Bark", "Flower", "Roots"},
            {"Bark", "Flower", "Roots"},
            {"Bark", "Flower", "Roots"},
            {"Bark", "Flower", "Roots"}
    };



    private String mCorrectAnswers[] = {"Roots", "Leaves", "Flower", "Stem","Roots", "Leaves", "Flower", "Stem","Roots", "Leaves", "Flower", "Stem","Roots",
            "Leaves", "Flower", "Stem","Roots", "Leaves", "Flower", "Stem"};




    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }


    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

}
