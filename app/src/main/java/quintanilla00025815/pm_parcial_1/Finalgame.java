package quintanilla00025815.pm_parcial_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
            mScoreView.setText("" + s);
            if(Integer.parseInt(s)>5){
                ImageView img= (ImageView) findViewById(R.id.image_view_image2);
                img.setImageResource(R.drawable.winner);
            }
            else{
                ImageView img= (ImageView) findViewById(R.id.image_view_image2);
                img.setImageResource(R.drawable.losser);
            }
        }
    }
}
