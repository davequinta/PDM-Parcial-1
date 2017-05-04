package Classes;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;



import quintanilla00025815.pm_parcial_1.R;

/**
 * Created by David on 01-May-17.
 */

public class countryRepository {
    private ArrayList<Country> rCountries = new ArrayList<>();
    private HashMap<Integer,Country> pCountries = new HashMap<>();


    public countryRepository() {
        saveCountry(new Country(1,"Afganistan",R.drawable.afganistan,"Kabul","Persa",5431.00));
        saveCountry(new Country(2,"Albania",R.drawable.albania,"Kabul","Persa",5431.00));
        saveCountry(new Country(3,"Alemania",R.drawable.alemania,"Asda","Aleman",5431.00));
        saveCountry(new Country(4,"Andorrra",R.drawable.andorra,"Kabul","Persa",5431.00));
        saveCountry(new Country(5,"Angola",R.drawable.angola,"Kabul","Persa",5431.00));
    }
/*LELOUCH ESTA VIVO F.César*/

    private void saveCountry(Country pCountry){pCountries.put(pCountry.getId(),pCountry);
    }

    public List<Country> getCountry(){
        Map<Integer,Country> map = new TreeMap<>(pCountries);
        return new ArrayList<>(map.values());
    }




}
