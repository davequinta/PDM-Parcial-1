package quintanilla00025815.pm_parcial_1;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import Classes.DatabaseHelperCountry;

public class addCountry extends AppCompatActivity {

    private EditText txtname;
    private EditText txtcap;
    private EditText txtlang;
    private EditText txtsurface;
    private ImageView pic;
    private DatabaseHelperCountry db;
    private String f_name;
    private ListView lv;
    //private dataAdapter data;
    //private Contact dataModel;
    private Bitmap bp;
    private byte[] photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_country);

        //Instantiate database handler
        db=new DatabaseHelperCountry(this);

       //lv = (ListView) findViewById(R.id.list1);
        pic= (ImageView) findViewById(R.id.imageButton);
        txtname=(EditText) findViewById(R.id.txtname);
        txtcap=(EditText) findViewById(R.id.txtcap);
        txtlang=(EditText) findViewById(R.id.txtlang);
        txtsurface=(EditText) findViewById(R.id.txtsurface);
    }

    public void addCountry(View view){

        String name = txtname.getText().toString();
        photo = profileImage(bp);
        String cap = txtcap.getText().toString();
        String lang = txtlang.getText().toString();
        String surface = txtsurface.getText().toString();
        db.addCountryC(name,photo,cap,lang,surface);

    }

    public void selectImage( View view){
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case 2:
                if(resultCode == RESULT_OK){
                    Uri choosenImage = data.getData();

                    if(choosenImage !=null){

                        bp=decodeUri(choosenImage, 400);
                        pic.setImageBitmap(bp);
                    }
                }
        }
    }


    //COnvert and resize our image to 400dp for faster uploading our images to DB
    protected Bitmap decodeUri(Uri selectedImage, int REQUIRED_SIZE) {

        try {

            // Decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage), null, o);

            // The new size we want to scale to
            // final int REQUIRED_SIZE =  size;

            // Find the correct scale value. It should be the power of 2.
            int width_tmp = o.outWidth, height_tmp = o.outHeight;
            int scale = 1;
            while (true) {
                if (width_tmp / 2 < REQUIRED_SIZE
                        || height_tmp / 2 < REQUIRED_SIZE) {
                    break;
                }
                width_tmp /= 2;
                height_tmp /= 2;
                scale *= 2;
            }

            // Decode with inSampleSize
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage), null, o2);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //Convert bitmap to bytes
    //@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    private byte[] profileImage(Bitmap b){

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.PNG, 0, bos);
        return bos.toByteArray();

    }

    // function to get values from the Edittext and image
    private void getValues(){
        f_name =txtname.getText().toString();
        photo = profileImage(bp);
    }

}
