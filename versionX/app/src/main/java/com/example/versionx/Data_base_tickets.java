package com.example.versionx;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.appcompat.app.AlertDialog;

public class Data_base_tickets extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="tickets.db";
    public static final String TABLE_NAME="tickets_table";
    public static final String COL_1="Ticket_number";
    public static final String COL_2="Date";
    public static final String COL_3="Sujet";
    public static final String COL_4="Source";
    public static final String COL_5="Priorite";
    public static final String COL_6="Description";




    public Data_base_tickets(Context context){
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table "+ TABLE_NAME +
                "(Ticket_number INTEGER PRIMARY KEY AUTOINCREMENT ," +
                " Date TEXT , Sujet TEXT, Source TEXT, Priorite TEXT ,Description TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }

    public boolean insertTickets(String Date, String Sujet , String Source, String Priorite, String Description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2,Date);
        contentValues.put(COL_3,Sujet);
        contentValues.put(COL_4,Source);
        contentValues.put(COL_5,Priorite);
        contentValues.put(COL_6,Description);


        Long result=db.insert(TABLE_NAME,null,contentValues);

        if(result==-1)
            return false;
        else
            return true;
    }

    public Cursor getAllTickets(){

        SQLiteDatabase db=this.getWritableDatabase();

        Cursor result=db.rawQuery("select * From "+ TABLE_NAME ,null);
        return result;
    }

    public Cursor getTickets(String User){

        SQLiteDatabase db=this.getWritableDatabase();

        Cursor result=db.rawQuery("select * From "+ TABLE_NAME +" where Source =?",new String[]{User});
        return result;
    }


    public void drop(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }



}

