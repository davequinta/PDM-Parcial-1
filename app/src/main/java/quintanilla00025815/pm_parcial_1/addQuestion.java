package quintanilla00025815.pm_parcial_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import Classes.DatabaseHelperCountry;

public class addQuestion extends AppCompatActivity {

    DatabaseHelperCountry h;

    String selectedCountry;
    String selectedQuestion;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        h = new DatabaseHelperCountry(this);

        Spinner countrySpinner = (Spinner) findViewById(R.id.spinner_country);

        ArrayAdapter<String> adapterC = new ArrayAdapter<>(this, R.layout.spinner_layout);

        int countries_count = h.getCountriesCount();

        for (int i=1; i<=countries_count; ++i){

            adapterC.add(h.obtenerCountry(i).getString(1));
        }

        countrySpinner.setAdapter(adapterC);

        Spinner QuestionSpinner = (Spinner) findViewById(R.id.spinner_question);

        ArrayAdapter<String> adapterQ = new ArrayAdapter<>(this, R.layout.spinner_layout);

        int type_count = h.getTypeCount();

        for (int i=1; i<=type_count; ++i){

            adapterQ.add(h.obtenerTipoPregunta(i).getString(1));
        }

        QuestionSpinner.setAdapter(adapterQ);
    }
/*
    public class questionSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            selectedQuestion = parent.getItemAtPosition(pos).toString();
        }

        public void onNothingSelected(AdapterView parent) {
            // Do nothing.
        }
    }*/

    public void agregarPregunta(View view){
        //h.addQuestion();
    }

}
