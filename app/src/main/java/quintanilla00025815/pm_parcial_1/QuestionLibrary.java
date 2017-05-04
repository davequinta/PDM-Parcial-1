package quintanilla00025815.pm_parcial_1;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class QuestionLibrary {

    private String mChoices [][] = {
            {"Afganistan", "Rusia", "Canada","Japón"},
            {"Angola", "Albania", "Chile","Japón"},
            {"Brasil", "Bolivia", "Alemania","Chile"},
            {"Andorra", "Brazil", "Alemania","Dinamarca"},
            {"Bahamas", "Brazil", "Egipto","Angola"},
            {"Bolivia", "Antigua Barbuda", "El Salvador","Egipto"},
            {"Bahamas", "Albania", "Chile","Canada"},
            {"Bolivia", "Angola", "Afganistan","Japón"},
            {"Brazil", "Afganistan", "Japón","Grecia"},
            {"Canada", "Angola", "Britania","Grecia"},
            {"Canada", "Chile", "Afganistan","El Salvador"},
            {"Egipto", "Chile", "Grecia","Guatemala"},
            {"India", "Dinamarca", "Italia","Andorra"},
            {"Egipto", "Grecia", "Guatemala","Italia"},
            {"Bolivia", "El Salvador", "Angola","Brazil"},
            {"Grecia", "Italia", "Japón","Dinamarca"},
            {"Dinamarca", "Guatemala", "India","El Salvador"},
            {"Angola", "Bolivia", "India","Japón"},
            {"Bahamas", "Antigua Barbuda", "Italia","El Salvador"},
            {"Guatemala", "Japón", "Canada","Britania"},
    };

    private String mCorrectAnswers[] = {"Afganistan", "Albania", "Alemania", "Andorra","Angola", "Antigua barbuda", "Bahamas",
            "Bolivia","Brazil", "Britania", "Canada", "Chile","Dinamarca",
            "Egipto", "El Salvador", "Grecia", "Guatemala", "India", "Italia","Japón"};

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
    public String getChoice4(int a) {
        String choice3 = mChoices[a][3];
        return choice3;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

}

