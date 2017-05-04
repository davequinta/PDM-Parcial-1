package quintanilla00025815.pm_parcial_1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import Classes.Country;
import Classes.countryRepository;
import quintanilla00025815.pm_parcial_1.*;
/**
 * Created by David on 03-May-17.
 */

public class countryDetails extends AppCompatActivity {
    static final String id = "code";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details);

        int idFinal = Integer.parseInt(getIntent().getStringExtra(id));

        TextView npais = (TextView)findViewById(R.id.txt_Name);
        ImageView image = (ImageView)findViewById(R.id.img_Flag);
        TextView ncapital = (TextView)findViewById(R.id.txt_Cap);
        TextView idioma = (TextView)findViewById(R.id.txt_Lang);
        TextView superficie = (TextView)findViewById(R.id.txt_Surface);

        countryRepository buscarPais = new countryRepository();
        Country pais = buscarPais.getCountries(idFinal);

        npais.setText(pais.getName()+"");
        image.setImageResource(pais.getFlag());
        ncapital.setText("Capital: "+ pais.getCapital());
        idioma.setText("Idioma: "+pais.getOfficial_language());
        superficie.setText("Superficie: "+pais.getSurface());


    }
}
