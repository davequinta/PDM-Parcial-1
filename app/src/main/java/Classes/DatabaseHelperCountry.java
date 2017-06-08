package Classes;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import quintanilla00025815.pm_parcial_1.R;

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
    public static final String TABLE_IDFULL = TABLE_QUESTIONS+"."+COLUMN_IDTPREGUNTA;
    // Create Statement for Products Table
    private static final String CREATE_TABLE_COUNTRY = "CREATE TABLE " + TABLE_COUNTRY + "  (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NAME + " TEXT, " +
            COLUMN_FLAG + " BLOB, " +
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
            COLUMN_IMG + " INTEGER, " +
             " FOREIGN KEY ("+COLUMN_IDTPREGUNTA+") REFERENCES "+TABLE_TYPEQUEST+"("+COLUMN_IDTPREGUNTA+"));";




    public DatabaseHelperCountry(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // onCreate should always create your most up to date database
        // This method is called when the app is newly installed
        db.execSQL(CREATE_TABLE_COUNTRY);
        db.execSQL(CREATE_TABLE_TYPE);
        db.execSQL(CREATE_TABLE_QUESTIONS);
        String sql =
                "INSERT or replace INTO "+ TABLE_COUNTRY +"("+COLUMN_NAME+"," +COLUMN_FLAG+","+ COLUMN_CAPITAL+","+ COLUMN_LANG+","+ COLUMN_SURFACE+") VALUES('Afganistan','afganistan','Kabul','Persa',5431.00)" ;
        db.execSQL(sql);
        String type= "INSERT or replace INTO "+ TABLE_TYPEQUEST+"("+COLUMN_TYPE+")VALUES('¿Cuál es la Moneda de: ?')";
        db.execSQL(type);
        String type2= "INSERT or replace INTO "+ TABLE_TYPEQUEST+"("+COLUMN_TYPE+")VALUES('¿De que pais es esta bandera: ?')";
        db.execSQL(type2);
        String type3= "INSERT or replace INTO "+ TABLE_TYPEQUEST+"("+COLUMN_TYPE+")VALUES('¿Cuál es la capital de ?')";
        db.execSQL(type3);
        String pregun= "INSERT or replace INTO "+ TABLE_QUESTIONS+"("+COLUMN_IDTPREGUNTA+","+COLUMN_RESP+","+COLUMN_IMG+")VALUES(1,'Dolar','afganistan')";
        db.execSQL(pregun);
        String pregun2= "INSERT or replace INTO "+ TABLE_QUESTIONS+"("+COLUMN_IDTPREGUNTA+","+COLUMN_RESP+","+COLUMN_IMG+")VALUES(2,'Afganistan','afganistan')";
        db.execSQL(pregun2);
        String pregun3= "INSERT or replace INTO "+ TABLE_QUESTIONS+"("+COLUMN_IDTPREGUNTA+","+COLUMN_RESP+","+COLUMN_IMG+")VALUES(1,'Yen','japon')";
        db.execSQL(pregun3);
        String pregun4= "INSERT or replace INTO "+ TABLE_QUESTIONS+"("+COLUMN_IDTPREGUNTA+","+COLUMN_RESP+","+COLUMN_IMG+")VALUES(1,'Colon','esa')";
        db.execSQL(pregun4);
        String pregun5= "INSERT or replace INTO "+ TABLE_QUESTIONS+"("+COLUMN_IDTPREGUNTA+","+COLUMN_RESP+","+COLUMN_IMG+")VALUES(2,'El Salvador','esa')";
        db.execSQL(pregun5);
        String pregun6= "INSERT or replace INTO "+ TABLE_QUESTIONS+"("+COLUMN_IDTPREGUNTA+","+COLUMN_RESP+","+COLUMN_IMG+")VALUES(2,'Chile','chile')";
        db.execSQL(pregun6);
        String pregun7= "INSERT or replace INTO "+ TABLE_QUESTIONS+"("+COLUMN_IDTPREGUNTA+","+COLUMN_RESP+","+COLUMN_IMG+")VALUES(1,'Boliviano','afganistan')";
        db.execSQL(pregun7);
        String pregun8= "INSERT or replace INTO "+ TABLE_QUESTIONS+"("+COLUMN_IDTPREGUNTA+","+COLUMN_RESP+","+COLUMN_IMG+")VALUES(1,'Euro','alemania')";
        db.execSQL(pregun8);
        String pregun9= "INSERT or replace INTO "+ TABLE_QUESTIONS+"("+COLUMN_IDTPREGUNTA+","+COLUMN_RESP+","+COLUMN_IMG+")VALUES(1,'Real','brasil')";
        db.execSQL(pregun9);
        String pregun10= "INSERT or replace INTO "+ TABLE_QUESTIONS+"("+COLUMN_IDTPREGUNTA+","+COLUMN_RESP+","+COLUMN_IMG+")VALUES(3,'Guatemala','guatemala')";
        db.execSQL(pregun10);
         String sql = "INSERT or replace INTO "+ TABLE_COUNTRY +"("+COLUMN_NAME+"," +COLUMN_FLAG+","+ COLUMN_CAPITAL+","+ COLUMN_LANG+","+ COLUMN_SURFACE+") VALUES('Afganistan','R.drawable.afganistan','Kabul','Persa',5431.00)" ;
        db.execSQL(sql);
        String sql2 =
                "INSERT or replace INTO "+ TABLE_COUNTRY +"("+COLUMN_NAME+"," +COLUMN_FLAG+","+ COLUMN_CAPITAL+","+ COLUMN_LANG+","+ COLUMN_SURFACE+") VALUES('Albania','R.drawable.albania','Tirana','Albanés',28748)" ;
        db.execSQL(sql2);
        String sql3 =
                "INSERT or replace INTO "+ TABLE_COUNTRY +"("+COLUMN_NAME+"," +COLUMN_FLAG+","+ COLUMN_CAPITAL+","+ COLUMN_LANG+","+ COLUMN_SURFACE+") VALUES('Alemania','R.drawable.alemania','Berlín','Alemán',357022)" ;
        db.execSQL(sql3);
        String sql4 =
                "INSERT or replace INTO "+ TABLE_COUNTRY +"("+COLUMN_NAME+"," +COLUMN_FLAG+","+ COLUMN_CAPITAL+","+ COLUMN_LANG+","+ COLUMN_SURFACE+") VALUES('Andorra','R.drawable.andorra','Andorra la Vieja','Catalán',478)" ;
        db.execSQL(sql4);
        String sql5 =
                "INSERT or replace INTO "+ TABLE_COUNTRY +"("+COLUMN_NAME+"," +COLUMN_FLAG+","+ COLUMN_CAPITAL+","+ COLUMN_LANG+","+ COLUMN_SURFACE+") VALUES('Angola','R.drawable.angola','Luanda','Portugues',1246700)" ;
        db.execSQL(sql5);
        String sql6 =
                "INSERT or replace INTO "+ TABLE_COUNTRY +"("+COLUMN_NAME+"," +COLUMN_FLAG+","+ COLUMN_CAPITAL+","+ COLUMN_LANG+","+ COLUMN_SURFACE+") VALUES('Antigua Barbuda','R.drawable.antigua_barbuda','Saint Johns','Ingles',442.6)" ;
        db.execSQL(sql6);
        String sql7 =
                "INSERT or replace INTO "+ TABLE_COUNTRY +"("+COLUMN_NAME+"," +COLUMN_FLAG+","+ COLUMN_CAPITAL+","+ COLUMN_LANG+","+ COLUMN_SURFACE+") VALUES('Bahamas','R.drawable.bahamas','Nasáu','Ingles',13880)" ;
        db.execSQL(sql7);
        String sql8 =
                "INSERT or replace INTO "+ TABLE_COUNTRY +"("+COLUMN_NAME+"," +COLUMN_FLAG+","+ COLUMN_CAPITAL+","+ COLUMN_LANG+","+ COLUMN_SURFACE+") VALUES('Bolivia','R.drawable.bolivia','Sucre','Español',1098581)" ;
        db.execSQL(sql8);
        String sql9 =
                "INSERT or replace INTO "+ TABLE_COUNTRY +"("+COLUMN_NAME+"," +COLUMN_FLAG+","+ COLUMN_CAPITAL+","+ COLUMN_LANG+","+ COLUMN_SURFACE+") VALUES('Brasil','R.drawable.brasil','Brasilia','Portugues',8515770)" ;
        db.execSQL(sql9);
        String sql10 =
                "INSERT or replace INTO "+ TABLE_COUNTRY +"("+COLUMN_NAME+"," +COLUMN_FLAG+","+ COLUMN_CAPITAL+","+ COLUMN_LANG+","+ COLUMN_SURFACE+") VALUES('Britania','R.drawable.britania_f','Bri','Japones',85770)" ;
        db.execSQL(sql10);
        String sql11 =
                "INSERT or replace INTO "+ TABLE_COUNTRY +"("+COLUMN_NAME+"," +COLUMN_FLAG+","+ COLUMN_CAPITAL+","+ COLUMN_LANG+","+ COLUMN_SURFACE+") VALUES('Canada','R.drawable.canada','Ottawa','Ingles',202080)" ;
        db.execSQL(sql11);
        String sql12 =
                "INSERT or replace INTO "+ TABLE_COUNTRY +"("+COLUMN_NAME+"," +COLUMN_FLAG+","+ COLUMN_CAPITAL+","+ COLUMN_LANG+","+ COLUMN_SURFACE+") VALUES('Chile','R.drawable.chile','Santiago','Español',756102)" ;
        db.execSQL(sql12);
        String sql13 =
                "INSERT or replace INTO "+ TABLE_COUNTRY +"("+COLUMN_NAME+"," +COLUMN_FLAG+","+ COLUMN_CAPITAL+","+ COLUMN_LANG+","+ COLUMN_SURFACE+") VALUES('Dinamarca','R.drawable.dinamarca','Copenhague','Danes',43094)" ;
        db.execSQL(sql13);
        String sql14 =
                "INSERT or replace INTO "+ TABLE_COUNTRY +"("+COLUMN_NAME+"," +COLUMN_FLAG+","+ COLUMN_CAPITAL+","+ COLUMN_LANG+","+ COLUMN_SURFACE+") VALUES('Egipto','R.drawable.egipto','El Cairo','Arabe Egipcio',1001450)" ;
        db.execSQL(sql14);
        String sql15 =
                "INSERT or replace INTO "+ TABLE_COUNTRY +"("+COLUMN_NAME+"," +COLUMN_FLAG+","+ COLUMN_CAPITAL+","+ COLUMN_LANG+","+ COLUMN_SURFACE+") VALUES('El Salvador','R.drawable.esa','San Salvador','Español',21041)" ;
        db.execSQL(sql15);
        String sql16 =
                "INSERT or replace INTO "+ TABLE_COUNTRY +"("+COLUMN_NAME+"," +COLUMN_FLAG+","+ COLUMN_CAPITAL+","+ COLUMN_LANG+","+ COLUMN_SURFACE+") VALUES('Grecia','R.drawable.grecia','Atenas','Griego',131957)" ;
        db.execSQL(sql16);
        String sql17 =
                "INSERT or replace INTO "+ TABLE_COUNTRY +"("+COLUMN_NAME+"," +COLUMN_FLAG+","+ COLUMN_CAPITAL+","+ COLUMN_LANG+","+ COLUMN_SURFACE+") VALUES('Guatemala','R.drawable.guatemala','Guatemala','Español',108889)" ;
        db.execSQL(sql17);
        String sql18 =
                "INSERT or replace INTO "+ TABLE_COUNTRY +"("+COLUMN_NAME+"," +COLUMN_FLAG+","+ COLUMN_CAPITAL+","+ COLUMN_LANG+","+ COLUMN_SURFACE+") VALUES('India','R.drawable.india','Nueva Delhi','Indi',3 287 263)" ;
        db.execSQL(sql18);
        String sql19 =
                "INSERT or replace INTO "+ TABLE_COUNTRY +"("+COLUMN_NAME+"," +COLUMN_FLAG+","+ COLUMN_CAPITAL+","+ COLUMN_LANG+","+ COLUMN_SURFACE+") VALUES('Italia','R.drawable.italia','Roma','Italiano',301340)" ;
        db.execSQL(sql19);
        String sql20 =
                "INSERT or replace INTO "+ TABLE_COUNTRY +"("+COLUMN_NAME+"," +COLUMN_FLAG+","+ COLUMN_CAPITAL+","+ COLUMN_LANG+","+ COLUMN_SURFACE+") VALUES('Japón','R.drawable.japon','Tokio','Japones',377915)" ;
        db.execSQL(sql20);
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

    public void addCountryC(String name, byte[] flag, String capital, String lang, String surface){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_FLAG,flag);
        values.put(COLUMN_CAPITAL,capital);
        values.put(COLUMN_LANG,lang);
        values.put(COLUMN_SURFACE,surface);
        db.insert(TABLE_COUNTRY, null,values);
        db.close();

        Log.d("LIST", "addCountryC: Se guardo ");

    }

    public void addQuestion(int idT, String resp, int img){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_IDTPREGUNTA, idT);
        values.put(COLUMN_RESP, resp);
        values.put(COLUMN_IMG, img);
    }

    public Cursor obtenerCountry(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_ID, COLUMN_NAME, COLUMN_FLAG, COLUMN_CAPITAL, COLUMN_LANG, COLUMN_SURFACE};

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

    public Cursor obtenerCountry(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_ID, COLUMN_NAME, COLUMN_FLAG, COLUMN_CAPITAL, COLUMN_LANG, COLUMN_SURFACE};

        Cursor cursor =
                db.query(TABLE_COUNTRY,
                        projection,
                        " Name =?",
                        new String[] { name },
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

    public Cursor obtenerTipoPregunta(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_IDTPREGUNTA,COLUMN_TYPE};

        Cursor cursor =
                db.query(TABLE_TYPEQUEST,
                        projection,
                        " _idTipoPregunta =?",
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

    public Cursor obtenerTipoPregunta(String tipo){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_IDTPREGUNTA,COLUMN_TYPE};

        Cursor cursor =
                db.query(TABLE_TYPEQUEST,
                        projection,
                        " TipoPregunta =?",
                        new String[] { tipo },
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
    public Cursor obtenerTipoPregunta2(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_IDTPREGUNTA,COLUMN_TYPE};

        String rawQuery = "SELECT "+COLUMN_TYPE +" FROM " + TABLE_QUESTIONS + " INNER JOIN " + TABLE_TYPEQUEST
                + " ON " + TABLE_TYPEQUEST+"."+COLUMN_IDTPREGUNTA + " = " + TABLE_IDFULL
                + " WHERE " + TABLE_TYPEQUEST+"."+COLUMN_IDTPREGUNTA + " = " +  id;
        Cursor c = db.rawQuery(
                rawQuery,
                null
        );
        if (c != null)
            c.moveToFirst();
        //System.out.println(c.getString(0));
        db.close();
        return c;
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

    public int getProfilesCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        int ret=(int) DatabaseUtils.queryNumEntries(db,TABLE_COUNTRY);
        return ret;
    }

    public int getTypeCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        int ret=(int) DatabaseUtils.queryNumEntries(db,TABLE_TYPEQUEST);
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
