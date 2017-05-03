package quintanilla00025815.pm_parcial_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import static quintanilla00025815.pm_parcial_1.R.*;


public class QuizActivity extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();
    private ArrayList<Integer> rCountries = new ArrayList<Integer>();
    public void countryRepository() {
        rCountries.add(drawable.afganistan);
        rCountries.add(drawable.albania);
        rCountries.add(drawable.alemania);
        rCountries.add(drawable.andorra);
        rCountries.add(drawable.angola);
        rCountries.add(drawable.antigua_barbuda);
        rCountries.add(drawable.bahamas);
        rCountries.add(drawable.bolivia);
        rCountries.add(drawable.brasil);
        rCountries.add(drawable.britania_f);
        rCountries.add(drawable.canada);
        rCountries.add(drawable.chile);
        rCountries.add(drawable.dinamarca);
        rCountries.add(drawable.egipto);
        rCountries.add(drawable.esa);
        rCountries.add(drawable.grecia);
        rCountries.add(drawable.guatemala);
        rCountries.add(drawable.india);
        rCountries.add(drawable.italia);
        rCountries.add(drawable.japon);
    }
    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private int x=0;
    private int a=0;
    private ArrayList<Integer> number = new ArrayList<Integer>();
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_quiz);


        for (int i = 0; i <= 19; ++i) number.add(i);
        Collections.shuffle(number);
        countryRepository();

        mScoreView = (TextView)findViewById(id.score);
        mQuestionView = (TextView)findViewById(id.question);
        mButtonChoice1 = (Button)findViewById(id.choice1);
        mButtonChoice2 = (Button)findViewById(id.choice2);
        mButtonChoice3 = (Button)findViewById(id.choice3);
        mButtonChoice4 = (Button)findViewById(id.choice4);
        updateQuestion();
        //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice1.getText() == mAnswer){
                    mScore +=1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice2.getText() == mAnswer){
                    mScore += 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button2


        //Start of Button Listener for Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
                                              @Override
                                              public void onClick(View view){
                                                  //My logic for Button goes in here

                                                  if (mButtonChoice3.getText() == mAnswer){
                                                      mScore += 1;
                                                      updateScore(mScore);
                                                      updateQuestion();
                                                      //This line of code is optiona
                                                      Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

                                                  }else {
                                                      Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                                                      updateQuestion();
                                                  }
                                              }
                                          }
        );
        mButtonChoice4.setOnClickListener(new View.OnClickListener(){
                                              @Override
                                              public void onClick(View view){
                                                  //My logic for Button goes in here
                                                  if (mButtonChoice4.getText() == mAnswer){
                                                      mScore += 1;
                                                      updateScore(mScore);
                                                      updateQuestion();
                                                      //This line of code is optiona
                                                      Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

                                                  }else {
                                                      Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                                                      updateQuestion();
                                                  }
                                              }
                                          }
        );



    }

    private void updateQuestion(){


        if(x<10){
            a= number.get(x);
            ImageView img= (ImageView) findViewById(id.image_view_image1);
            img.setImageResource(rCountries.get(a));
            mQuestionView.setText( "¿De qué país es la bandera?");
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(a));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(a));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(a));
            mButtonChoice4.setText(mQuestionLibrary.getChoice4(a));
            mAnswer = mQuestionLibrary.getCorrectAnswer(a);
            mQuestionNumber++;
            x++;
        }
          else{
            if (mScore>5){
                Intent intent = new Intent(getBaseContext(), Finalgame.class);
                intent.putExtra("SCORE", String.valueOf(mScore));
                startActivity(intent);
            }
            else{
                Intent intent = new Intent(getBaseContext(), Finalgame.class);
                intent.putExtra("SCORE", String.valueOf(mScore));
                startActivity(intent);
            }
        }

    }


    private void updateScore(int point) {
        mScoreView.setText(""+ mScore);
    }
}