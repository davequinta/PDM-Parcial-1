package Classes;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by David on 05-Jun-17.
 */

public class DatabaseHelperCountry extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "countries.db";
    private static final int DATABASE_VERSION = 1;
    // For all Primary Keys _id should be used as column name
    public static final String COLUMN_ID = "_id";

    // Definition of table and column names of Country table
    public static final String TABLE_COUNTRY = "Country";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_FLAG= "Flag";
    public static final String COLUMN_CAPITAL = "Capital";
    public static final String COLUMN_LANG = "Lang";
    public static final String COLUMN_SURFACE = "Surface";




    // Create Statement for Products Table
    private static final String CREATE_TABLE_COUNTRY = "CREATE TABLE " + TABLE_COUNTRY + "  (" +
            COLUMN_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_NAME + " TEXT, " +
            COLUMN_FLAG + " INTEGER " +
            COLUMN_CAPITAL + " TEXT " +
            COLUMN_LANG + " TEXT " +
            COLUMN_SURFACE + " TEXT " +
            ");";




    public DatabaseHelperCountry(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // onCreate should always create your most up to date database
        // This method is called when the app is newly installed
        db.execSQL(CREATE_TABLE_COUNTRY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addCountry(String name, int flag, String capital, String lang, String surface){
        SQLiteDatabase db = this.getWritableDatabase();
        //String image= "hora_de_aventura";
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_FLAG,flag);
        values.put(COLUMN_CAPITAL,capital);
        values.put(COLUMN_LANG,lang);
        values.put(COLUMN_SURFACE,surface);
        db.insert(TABLE_COUNTRY, null,values);
        db.close();

    }
    public Cursor obtener(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_ID, COLUMN_NAME,COLUMN_FLAG, COLUMN_CAPITAL, COLUMN_LANG, COLUMN_SURFACE};

        Cursor cursor =
                db.query(TABLE_COUNTRY,
                        projection,
                        " _id =?",
                        new String[] { String.valueOf(id) },
                        null,
                        null,
                        null,
                        null);
        if (cursor != null)
            cursor.moveToFirst();
        // System.out.println("El nombre es " +  cursor.getString(2) );
        db.close();
        return cursor;
    }
    /*
    public int getProfilesCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        int ret=(int) DatabaseUtils.queryNumEntries(db,TABLE_SERIES);
        return ret;
    }
    */

    public void updateCountry(String nombre, String id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",nombre);
        int i = db.update(TABLE_COUNTRY,
                values,
                " id = ?",
                new String[] { String.valueOf( id ) });
        db.close();
    }
    public boolean deleteCountry(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            db.delete(TABLE_COUNTRY,
                    " _id = ?",
                    new String[] { String.valueOf (id ) });
            db.close();
            return true;

        }catch(Exception ex){
            return false;
        }


    }
