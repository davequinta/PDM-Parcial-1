package Classes;

import quintanilla00025815.pm_parcial_1.*;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by David on 03-May-17.
 */

public class mainLearning extends AppCompatActivity {

    private ListView listCountries;
    private myAdapter listAdapter;
    private countryRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learning);

        listCountries = (ListView) findViewById(R.id.countries_listView);
        repository = new countryRepository();
        listAdapter = new myAdapter(this, repository.getCountry());
        listCountries.setAdapter(listAdapter);

        listCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Country currentCountry = listAdapter.getItem(position);

                Intent mostrarInfo = new Intent(view.getContext(), countryDetails.class);

                mostrarInfo.putExtra(countryDetails.id, String.valueOf(currentCountry.getId()));

                startActivity(mostrarInfo);
            }
        });

    }
}
