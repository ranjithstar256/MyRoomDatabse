package com.example.mydatabse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabHelpr extends SQLiteOpenHelper {
    SQLiteDatabase sq;
    public DatabHelpr(Context context) {
        super(context, "dejjtails.db", null,1);
        sq=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table students (Name text, Password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void svdata(ContentValues cv) {
        sq.insert("students",null,cv);
    }

    public String retrpw(String nameuser) {

       Cursor c= sq.query("students",null,"Name=?",new String[]{nameuser}
        ,null,null,null);

       c.moveToFirst();

       if (c.getCount()<1){
           return "not exists";
       }
        String pw =c.getString(c.getColumnIndex("Password"));

      return pw;
    }

    public void updpw(String s3, ContentValues cv) {


        sq.update("students",cv,"Name ='"+s3+"'",null);


    }
}
