package quintanilla00025815.pm_parcial_1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Finalgame extends AppCompatActivity {
    private TextView mScoreView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalgame);
        mScoreView = (TextView)findViewById(R.id.score2);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String s = extras.getString("SCORE");
            mScoreView.setText("" + s +"/10");
            if(Integer.parseInt(s)>5){
                ImageView img= (ImageView) findViewById(R.id.image_view_image2);
                img.setImageResource(R.drawable.winner);
            }
            /*sape*/
            else{
                ImageView img= (ImageView) findViewById(R.id.image_view_image2);
                img.setImageResource(R.drawable.losser);
            }
        }
    }
    public void restarBut(View view){
        Intent i = new Intent(getBaseContext(), MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
    /*FLAG_ACTIVITY_CLEAR_TOP
    * Si la actividad que se está iniciando ya se está ejecutando en la tarea actual,
     * entonces en lugar de iniciar una nueva instancia de esa actividad,
     * todas las demás actividades en la parte superior de la misma se cerrarán y
     * esta Intención se entregará a la parte superior) Como un nuevo intento.
    * */
}
