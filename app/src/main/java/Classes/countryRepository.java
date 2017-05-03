package Classes;

import java.lang.reflect.Array;
import java.util.ArrayList;

import quintanilla00025815.pm_parcial_1.R;

/**
 * Created by David on 01-May-17.
 */

public class countryRepository {
   private ArrayList<Country> rCountries = new ArrayList<>();

    public countryRepository() {
        rCountries.add(new Country("Afganistan",R.drawable.afganistan,"Kabul","Persa",5431.00));
        rCountries.add(new Country("Albania",R.drawable.albania,"Kabul","Persa",5431.00));
        rCountries.add(new Country("Alemania",R.drawable.alemania,"Asda","Aleman",5431.00));
        rCountries.add(new Country("Andorrra",R.drawable.andorra,"Kabul","Persa",5431.00));
        rCountries.add(new Country("Angola",R.drawable.angola,"Kabul","Persa",5431.00));
    }
/*LELOUCH ESTA VIVO F.César*/
    public ArrayList<Country> getrCountries() {
        return rCountries;
    }

    public void setrCountries(ArrayList<Country> rCountries) {
        this.rCountries = rCountries;
    }
}
