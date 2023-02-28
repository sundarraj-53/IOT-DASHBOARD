package com.example.iotdash;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper{

    public DBHandler(Context context) {
        super(context, "Sign_up",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

//        Email Text,
        db.execSQL("create Table User_details(Username Text primary key,Email Text,Password Text,CPassword_col Text)"); //Executing the query
    }
    public boolean insertData(String Username,String Email,String Password,String confirm_Password){
//        String Email

        SQLiteDatabase db=this.getWritableDatabase();  //Writing in the Database

        ContentValues values = new ContentValues(); // creating the object for the content values

        values.put("Username",Username);
        values.put("Email",Email);
        values.put("Password",Password);
        values.put("CPassword_col",confirm_Password); //getting the values

        long result=db.insert("User_details",null,values);  //insert the values on the table

        if(result==-1){
            return false;
        }
        else{
            return true;
        }

    }
    public Boolean  checkEmail(String Username,String Email){
//        , String Email
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from User_details where Username=? or Email=?",new String[]{Username,Email});
//          Email
//        Email=? or
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean checkEmailPassword(String Username,String Email,String Password){
//        String Email,
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from User_details where Username=? or Email=? and Password=?",new String[]{Username,Email,Password});
//
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF  EXISTS User_details");
    }
}
