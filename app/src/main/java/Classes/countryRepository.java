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
    public static final List<Country> ITEMS = new ArrayList<>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Country> ITEM_MAP = new HashMap<>();

    //private static final int COUNT = 25;

    static {
        /*
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
        */
    }

    private static void addItem(Country item) {
        ITEMS.add(item);
        ITEM_MAP.put(String.valueOf(item.id), item);
    }

    /*

    private static Country  createDummyItem(int position) {
        return new Country(position, "Item " + position, makeDetails(position));
    }
    */

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }




}
