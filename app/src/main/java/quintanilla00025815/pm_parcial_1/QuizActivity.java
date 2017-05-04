package quintanilla00025815.pm_parcial_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Classes.Country;
import Classes.countryRepository;

import static quintanilla00025815.pm_parcial_1.R.*;


public class QuizActivity extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();
    private countryRepository mCountry = new countryRepository();
    List<Country> Lista = new ArrayList<Country>();



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
    private int mQuestionNumber = 0; //aunque no parezca, si! se ocupa
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_quiz);
        Lista = mCountry.getCountry();

        for (int i = 0; i <= 19; ++i) number.add(i); //arreglo de 20 numeros
        Collections.shuffle(number); // desordenanos el arreglo


        mScoreView = (TextView)findViewById(id.score); //definimos el textview del score
        mQuestionView = (TextView)findViewById(id.question); //definimos el textview de la pregunta
        mButtonChoice1 = (Button)findViewById(id.choice1); //definimos el button de la opcion 1
        mButtonChoice2 = (Button)findViewById(id.choice2);//definimos el button de la opcion 2
        mButtonChoice3 = (Button)findViewById(id.choice3);//definimos el button de la opcion 3
        mButtonChoice4 = (Button)findViewById(id.choice4);//definimos el button de la opcion 4
        updateQuestion(); //iniciamos el juego

        if(savedInstanceState!=null){
            int x=savedInstanceState.getInt("x");
            int a=savedInstanceState.getInt("a");
            int ms=savedInstanceState.getInt("mScore");
            int mq=savedInstanceState.getInt("mQuestion");
            String mAnswer=savedInstanceState.getString("mAnswer");
            ArrayList<Integer> number=savedInstanceState.getIntegerArrayList("number");
            mScoreView.setText(ms+"");
            mScore=ms;
        }
        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){


                if (mButtonChoice1.getText() == mAnswer){ //comparamos el valor la opcion 1 con la respuesta
                    mScore +=1; //si la respuesta es correcta sumamos 1 al score
                    updateScore(mScore); //actualizamos score
                    updateQuestion(); //avanzamos a la siguiente pregunta

                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show(); //mensaje de opcion correcta

                }else {
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show(); //mensaje de opcion incorrecta
                    updateQuestion(); //avanzamos a la siguiente pregunta
                }
            }
        });

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //misma logica que en el boton 1 solo que seria con la segunda opcion


                if (mButtonChoice2.getText() == mAnswer){
                    mScore += 1;
                    updateScore(mScore);
                    updateQuestion();

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
                                                  //misma logica que en el boton 1 solo que seria con la tercera opcion

                                                  if (mButtonChoice3.getText() == mAnswer){
                                                      mScore += 1;
                                                      updateScore(mScore);
                                                      updateQuestion();

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
                                                  //misma logica que en el boton 1 solo que seria con la cuarta opcion
                                                  if (mButtonChoice4.getText() == mAnswer){
                                                      mScore += 1;
                                                      updateScore(mScore);
                                                      updateQuestion();

                                                      Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

                                                  }else {
                                                      Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                                                      updateQuestion();
                                                  }
                                              }
                                          }
        );



    }
    @Override
    protected void onSaveInstanceState(Bundle onState){
        onState.putInt("x",x);
        onState.putInt("a",a);
        onState.putInt("mScore",mScore);
        onState.putInt("mQuestionNumber",mQuestionNumber);
        onState.putString("mAnswer",mAnswer);
        onState.putIntegerArrayList("number",number);
    }

    private void updateQuestion(){


        if(x<10){ //para que sean 10 preguntas
            a= number.get(x); //obtenemos el valor del arreglo
            ImageView img= (ImageView) findViewById(id.image_view_image1); //creamos un objeto imagen enlazado con el ImageView del xml
            img.setImageResource(Lista.get(a).getFlag());
            //aqui mandamos las 4 opciones y la unica pregunta
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
            if (mScore>5){ //para mandar el score a la siguiente activity dependiendo del score
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
    } //aqui se envia el contador del score al textview
}