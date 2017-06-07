package Classes;


import android.content.Context;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import quintanilla00025815.pm_parcial_1.QuizActivity;
import quintanilla00025815.pm_parcial_1.R;


/**
 * Created by David on 01-May-17.
 */

public class countryRepository {
    private Context context;

    private HashMap<Integer,Country> pCountries = new HashMap<>();
    public countryRepository() {

        saveCountry(new Country(1,"Afganistan",R.drawable.afganistan,"Kabul","Persa",5431.00));
       saveCountry(new Country(2,"Albania", R.drawable.albania,"Kabul","Persa",5431.00));
        saveCountry(new Country(3,"Alemania",R.drawable.alemania,"Munich","Aleman",5431.00));
        saveCountry(new Country(4,"Andorrra",R.drawable.andorra,"Kabul","Persa",5431.00));
        saveCountry(new Country(5,"Angola",R.drawable.angola,"Kabul","Persa",5431.00));
        saveCountry(new Country(6,"Antigua Barbuda",R.drawable.antigua_barbuda,"Kabul","Persa",5431.00));
        saveCountry(new Country(7,"Bahamas",R.drawable.bahamas,"Kabul","Persa",5431.00));
        saveCountry(new Country(8,"Bolivia",R.drawable.bolivia,"Kabul","Persa",5431.00));
        saveCountry(new Country(9,"Brazil",R.drawable.brasil,"Kabul","Persa",5431.00));
        saveCountry(new Country(10,"Britania",R.drawable.britania_f,"Kabul","Persa",5431.00));
        saveCountry(new Country(11,"Canada",R.drawable.canada,"canada","Persa",5431.00));
        saveCountry(new Country(12,"Chile",R.drawable.chile,"Kabul","Persa",5431.00));
        saveCountry(new Country(13,"Dinamarca",R.drawable.dinamarca,"Kabul","Persa",5431.00));
        saveCountry(new Country(14,"Egipto",R.drawable.egipto,"Kabul","Persa",5431.00));
        saveCountry(new Country(15,"El Salvador",R.drawable.esa,"Kabul","Persa",5431.00));
        saveCountry(new Country(16,"Grecia",R.drawable.grecia,"Kabul","Persa",5431.00));
        saveCountry(new Country(17,"Guatemala",R.drawable.guatemala,"Kabul","Persa",5431.00));
        saveCountry(new Country(18,"India",R.drawable.india,"Kabul","Persa",5431.00));
        saveCountry(new Country(19,"Italia",R.drawable.italia,"Kabul","Persa",5431.00));
        saveCountry(new Country(20,"Japón",R.drawable.japon,"Kabul","Persa",5431.00));
    }
/*LELOUCH ESTA VIVO F.César*/

    private void saveCountry(Country pCountry){pCountries.put(pCountry.getId(),pCountry);
    }

    public List<Country> getCountry(){
        Map<Integer,Country> map = new TreeMap<>(pCountries);
        return new ArrayList<>(map.values());
    }
    public Country getClicked(int id){
        Country c = pCountries.get(id);
        return c;
    }




}
