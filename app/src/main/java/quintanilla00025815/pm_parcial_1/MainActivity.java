package quintanilla00025815.pm_parcial_1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import Classes.Country;
import Classes.DatabaseHelperCountry;

public class MainActivity extends AppCompatActivity {

    ArrayList<Country> countries;

    //Funcion que conecta con el juego
    public void game(View v){
        Intent game=new Intent(this,QuizActivity.class);
        startActivity(game);
    }

    public void learn(View v){
        Intent learn=new Intent(this,CountryListActivity.class);
        learn.putParcelableArrayListExtra("countries", countries);
        startActivity(learn);
    }

    public void edit(View v){
        Intent edit = new Intent(this,addCountry.class);
        startActivity(edit);
    }
    public void question(View v){
        Intent question = new Intent(this,addingActivity.class);
        startActivity(question);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        countries = new ArrayList<>(2);
        DatabaseHelperCountry h =  new DatabaseHelperCountry(this);
        h.addCountry("Afganistan", R.drawable.afganistan,"Kabul","Persa","5431.00");
        h.addCountry("Albania",R.drawable.albania,"Tirana","albanés","5431.00");



        int profile_counts = h.getProfilesCount();
        for (int i=1; i<=profile_counts; ++i){

            String name = h.obtenerCountry(i).getString(1) ;
            System.out.println(name);
            int id = getResources().getIdentifier(name, "drawable", getPackageName());
            System.out.println(id);

            countries.add(new Country(h.obtenerCountry(i).getInt(0), h.obtenerCountry(i).getString(1), h.obtenerCountry(i).getInt(2),
                    h.obtenerCountry(i).getString(3), h.obtenerCountry(i).getString(4), h.obtenerCountry(i).getDouble(5)));
        }


    }
}
