package Classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import Classes.Country;
import quintanilla00025815.pm_parcial_1.R;

/**
 * Created by David on 01/05/2017.
 */

public class myAdapter extends ArrayAdapter<Country>{

    public myAdapter(Context context, List<Country> objects) {

        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (null == convertView) {
            convertView = inflater.inflate(
                    R.layout.itemrow,
                    parent,
                    false);
        }

        //Reference of the elementos of itemrow.xml

        ImageView img = (ImageView) convertView.findViewById(R.id.imgFlag);
        TextView txt_name = (TextView) convertView.findViewById(R.id.txtName);
        Country scountry = getItem(position);
        img.setImageResource(scountry.getFlag());
        txt_name.setText(scountry.getName());

        return convertView;
    }

}
