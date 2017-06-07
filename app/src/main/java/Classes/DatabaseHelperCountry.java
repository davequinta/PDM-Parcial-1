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

    // Definition of table and column Preguntas table
    public static final String TABLE_QUESTIONS = "Pregunta";
    public static final String COLUMN_IDQ = "_idPregunta";
    public static final String COLUMN_IDTPREGUNTA = "_idTipoPregunta";
    public static final String COLUMN_RESP= "Respuesta";
    public static final String COLUMN_IMG= "Qimage";

    // Definition of table and column Tipo de Preguntas table
    public static final String TABLE_TYPEQUEST = "TipoPregunta";
    public static final String COLUMN_TYPE = "TipoPregunta";
    // Create Statement for Products Table
    private static final String CREATE_TABLE_COUNTRY = "CREATE TABLE " + TABLE_COUNTRY + "  (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NAME + " TEXT, " +
            COLUMN_FLAG + " INTEGER, " +
            COLUMN_CAPITAL + " TEXT, " +
            COLUMN_LANG + " TEXT, " +
            COLUMN_SURFACE + " TEXT " +
            ");";
    private static final String CREATE_TABLE_TYPE = "CREATE TABLE " + TABLE_TYPEQUEST+ "  (" +
            COLUMN_IDTPREGUNTA + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_TYPE + " TEXT " +
            ");";
    private static final String CREATE_TABLE_QUESTIONS = "CREATE TABLE " + TABLE_QUESTIONS + "  (" +
            COLUMN_IDQ + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_IDTPREGUNTA + " INTEGER, " +
            COLUMN_RESP + " TEXT, " +
            COLUMN_IMG + " TEXT, " +
             " FOREIGN KEY ("+COLUMN_IDTPREGUNTA+") REFERENCES "+TABLE_TYPEQUEST+"("+COLUMN_IDTPREGUNTA+"));";




    public DatabaseHelperCountry(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // onCreate should always create your most up to date database
        // This method is called when the app is newly installed
        db.execSQL(CREATE_TABLE_COUNTRY);
        String sql =
                "INSERT or replace INTO TABLE_COUNTRY (COLUMN_NAME, COLUMN_FLAG, COLUMN_CAPITAL, COLUMN_LANG, COLUMN_SURFACE)" +
                        " VALUES('Afganistan','R.drawable.afganistan','Kabul','Persa',5431.00)" ;
        db.execSQL(sql);
        String type= "INSERT or replace INTO TABLE_TYPEQUEST(COLUMN_TYPE)"+"VALUES('¿Cuál es la Moneda de: ?')";
        db.execSQL(type);
        String pregun= "INSERT or replace INTO TABLE_QUESTIONS(COLUMNIDTPREGUNTA,COLUMN_RESP,COLUMN_IMG)"+"VALUES(1,'dolar','R.drawable.afganistan')";
        db.execSQL(pregun);
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
        String[] projection = {COLUMN_ID, COLUMN_NAME,COLUMN_FLAG, COLUMN_RESP, COLUMN_IMG};

        Cursor cursor =
                db.query(TABLE_COUNTRY,
                        projection,
                        " _idPregunta =?",
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
    public Cursor obtenerTipo(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_IDTPREGUNTA,COLUMN_TYPE};

        Cursor cursor =
                db.query(TABLE_TYPEQUEST,
                        projection,
                        " _idPregunta =?",
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
    public int getPreguntasCount() {
        SQLiteDatabase db = this.getReadableDatabase();

        int ret=(int) DatabaseUtils.queryNumEntries(db,TABLE_QUESTIONS);
        return ret;
    }
    public Cursor obtenerPregunta(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_IDQ, COLUMN_IDTPREGUNTA,COLUMN_RESP, COLUMN_IMG};

        Cursor cursor =
                db.query(TABLE_QUESTIONS,
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

    public int getProfilesCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        int ret=(int) DatabaseUtils.queryNumEntries(db,TABLE_COUNTRY);
        return ret;
    }

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
}
