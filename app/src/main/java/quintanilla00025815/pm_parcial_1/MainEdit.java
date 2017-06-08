package quintanilla00025815.pm_parcial_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import Classes.DatabaseHelperCountry;

public class MainEdit extends AppCompatActivity {

    DatabaseHelperCountry helperCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_edit);

        helperCountry = new DatabaseHelperCountry(this);
    }

    public void agregar(View view){
        
    }
}
