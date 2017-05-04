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
        rCountries.add(new Country(1,"Afganistan",R.drawable.afganistan,"Kabul","Persa",5431.00));
        rCountries.add(new Country(2,"Albania",R.drawable.albania,"Kabul","Persa",5431.00));
        rCountries.add(new Country(3,"Alemania",R.drawable.alemania,"Asda","Aleman",5431.00));
        rCountries.add(new Country(4,"Andorrra",R.drawable.andorra,"Kabul","Persa",5431.00));
        rCountries.add(new Country(5,"Angola",R.drawable.angola,"Kabul","Persa",5431.00));
    }
/*LELOUCH ESTA VIVO F.César*/
    public ArrayList<Country> getrCountries() {
        return rCountries;
    }

    public void setrCountries(ArrayList<Country> rCountries) {
        this.rCountries = rCountries;
    }
}
