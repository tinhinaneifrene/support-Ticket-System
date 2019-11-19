package com.example.versionx;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Authentification.db";
    public static final String TABLE_NAME="Authentification_table";
    public static final String COL_1="ID";
    public static final String COL_2="UserName";
    public static final String COL_3="PassWord";

    public SQLiteDataBaseHelper(Context context){
        super(context,DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table "+ TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , UserName TEXT unique, PassWord TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String UserName, String Password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2,UserName);
        contentValues.put(COL_3,Password);

        Long result=db.insertWithOnConflict(TABLE_NAME,COL_2,contentValues,SQLiteDatabase.CONFLICT_IGNORE);
        if(result==-1)
            return false;
        else
            return true;
    }
    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor result=db.rawQuery("select * from "+ TABLE_NAME,null);
        return result;
    }

    public Boolean verification(String UserName1){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result=db.rawQuery("select * from TABLE_NAME where UserName =?",new String[]{UserName1});
        if (result.getCount() > 0)
            return false;
        else
            return true;
    }
}
