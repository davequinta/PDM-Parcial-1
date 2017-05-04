package quintanilla00025815.pm_parcial_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class QuizActivity extends AppCompatActivity {
    //Varaiables
    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private int x=0;
    private int a=0;
    private ArrayList<Integer> number = new ArrayList<Integer>();
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    //Funcion onCreate para levantar el programa
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        for (int i = 1; i <= 20; ++i) number.add(i);
        Collections.shuffle(number);
        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);

        updateQuestion();
        if (savedInstanceState!=null){
            int mS=savedInstanceState.getInt("mScore");
            int mQ=savedInstanceState.getInt("mQuestion");
            int x=savedInstanceState.getInt("x");
            int a=savedInstanceState.getInt("a");
            String ma=savedInstanceState.getString("mAnswer");
            ArrayList<Integer> n=savedInstanceState.getIntegerArrayList("number");
            mScoreView.setText(mS+"");
        }
        //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here

                if (mButtonChoice1.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here

                if (mButtonChoice2.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button2


        //Start of Button Listener for Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here

                if (mButtonChoice3.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button3

    }
    @Override
    protected void onSaveInstanceState(Bundle onState){
        onState.putInt("mScore",mScore);
        onState.putInt("mQuestion",mQuestionNumber);
        onState.putInt("x",x);
        onState.putInt("a",a);
        onState.putString("mAnswe",mAnswer);
        onState.putIntegerArrayList("number",number);
    }

    //Actualizar pregunta
    private void updateQuestion(){
        a= number.get(x);
        mQuestionView.setText(mQuestionLibrary.getQuestion(a));
        mButtonChoice1.setText(mQuestionLibrary.getChoice1(a));
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(a));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(a));
        mAnswer = mQuestionLibrary.getCorrectAnswer(a);
        mQuestionNumber++;
        x++;
    }

    //Actualizar puntaje
    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }
}
