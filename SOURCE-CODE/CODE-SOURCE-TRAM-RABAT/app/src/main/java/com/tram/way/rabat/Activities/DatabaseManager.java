package com.tram.way.rabat.Activities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.Attributes;

public class DatabaseManager  extends SQLiteOpenHelper {
    SQLiteDatabase db;
    public static final String KEY_STA = "id";
    public static final String KEY_LIGNE = "idligneref";
    public static final String KEY_NAME = "Nom";
    public static final String KEY_LOCAL = "Localisation";
    public static final String KEY_VILLE = "NomVille";
    private  static final String DATABASE_NAME="tram.db";
    private static final  int DATABASE_VERSION=2;
    public DatabaseManager(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {


   String strSql="CREATE TABLE Station(id  integer PRIMARY KEY autoincrement, KEY_NAME,KEY_LOCAL, KEY_VILLE ,KEY_LIGNE )";
        String strSqlc="CREATE TABLE IF NOT EXISTS Contact(id  INTEGER PRIMARY KEY AUTOINCREMENT, Nom VARCHAR(255),Email VARCHAR(255),Message VARCHAR(255))";
      db.execSQL(strSql);
       db.execSQL(strSqlc);
        Log.i("Database ","onCreateContact invoked");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion > 2) {
            db.execSQL("DROP TABLE IF EXISTS Contact");
        }
      // db.execSQL("DROP TABLE IF EXISTS Contact");
       onCreate(db);
        Log.i("Database ","onUpgrade invoked");

    }
//Insertion de la table Station
    public void insertStasion(String name, String local, String namevile, int idRef )
    {
         name=name.replace("'","''");
        local=local.replace("'","''");
        namevile=namevile.replace("'","''");
         String sql="INSERT INTO Station(id,Nom,Localisation,NomVille,idligneref) values('"+name+ "', '" + local + "', '" + namevile + "','" + idRef + "') ";

        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL(sql);
        Log.i("Database ","insertStasion invoked");

    }
    public boolean addContact(String no, String em, String me)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put("Nom",no);
        contentValues.put("Email",em);
        contentValues.put("Message",me);

        db.insert("Contact",null,contentValues);

        return true;
    }

    //Insertion de la table Contact
 /*   public void insertContact(String name, String mail, String msg)
    {
        name=name.replace("'","''");
        mail=mail.replace("'","''");
        msg=msg.replace("'","''");
        String sql="INSERT INTO Contact(Nom ,Email,Message) values('"+name+ "', '" + mail + "', '" + msg + "') ";

        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL(sql);
        Log.i("Database ","insertContact invoked");

    }*/


  /*  public Station getoneStation(int id)
    {
         SQLiteDatabase db=this.getReadableDatabase();
         Cursor c=db.query("Station",new String[]{"idSta","Nom","Localisation","NomVille","idligneref"},"idSta=?",new String[]{String.valueOf(id)},null,null,null);


         c.moveToFirst();
         Station s1=new Station(c.getString(1));
         return s1;
    }*/
 /*  public void deleteAllCountries()
   {
       SQLiteDatabase db=this.getWritableDatabase();

       db.delete("StationData", null , null);

       db.close();

   }*/



    public Cursor getInformation(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor;// objects that retrieves information from the database
        String[] projections = {KEY_NAME};
        String orderBy = KEY_LIGNE+" DESC";
        String limit = "100";


        cursor = db.query("Station",projections,null,null,null,null,orderBy,limit); // the nulls have to do with where clause info

        return cursor;
    }
    public void deleteInformation(String whereClause , String[] whereArgs, SQLiteDatabase db){


        db.delete("Station",whereClause,whereArgs);


     //   Log.i(TAG,"One row is deleted with username: "+ Arrays.toString(whereArgs));
    }

    public Cursor fetchStationByIDLigne(String inputText) throws SQLException {

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor mCursor = null;
        if (inputText == null  ||  inputText.length () == 0)  {
            mCursor = db.query("Station", new String[] {KEY_STA,KEY_NAME, KEY_LOCAL, KEY_VILLE,KEY_LIGNE},
                    null, null, null, null, null);

        }
        else {
            mCursor = db.query(true, "Station", new String[] {KEY_NAME},
                    KEY_LIGNE+ inputText  , null,null, null, null, null);
        }
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }


 /*  public List<String> read()
    {
        List<StationData> data=new ArrayList<>();
        String sql="SELECT Nom FROM Station";
        Cursor cursor=this.getReadableDatabase().rawQuery(sql,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            StationData staD=new StationData(cursor.getString(0));
            data.add(staD);
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }
    public List<StationData> read2()
    {
        List<StationData> data=new ArrayList<>();
        String sql="SELECT * FROM Station WHERE idligneref=2";
        Cursor cursor=this.getReadableDatabase().rawQuery(sql,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            StationData staD=new StationData(cursor.getString(0));
            data.add(staD);
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }


    public SimpleCursorAdapter populateListVewDB()
    {
        String  colums[]={ KEY_STA,KEY_NAME};
        Cursor cursor=db.query("Station",colums,null,null,null);


    }*/
}
