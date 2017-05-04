package quintanilla00025815.pm_parcial_1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
    static final String EXTRA_ID = "quintanilla00025815.pm_parcial_1";
    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details);
        int cte = Integer.parseInt(getIntent().getStringExtra(EXTRA_ID));
        ImageView imgFlag = (ImageView)findViewById(R.id.img_Flag);
        TextView txtCap = (TextView)findViewById(R.id.txt_Cap);
        TextView txtLang = (TextView)findViewById(R.id.txt_Lang);
        TextView txtSurf = (TextView)findViewById(R.id.txt_Surface);
        countryRepository repo = new countryRepository();
        Country pais = repo.getClicked(cte);
        mToolbar = (Toolbar) findViewById(R.id.toolbar2);
        mToolbar.setTitle(pais.getName());
        imgFlag.setImageResource(pais.getFlag());
        txtCap.setText("CAPITAL: "+ pais.getCapital());
        txtLang.setText("OFFICIAL LANG: "+pais.getOfficial_language());
        txtSurf.setText("SURFACE: "+pais.getSurface());


    }
}
