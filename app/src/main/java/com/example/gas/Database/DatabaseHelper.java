package com.example.gas.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    //signup db
    public static final String databasename = "Mydb";


    public DatabaseHelper(@Nullable Context context) {
        super(context,"Mydb",
                null, 1);
    }
    //loging table
    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {

        MyDatabase.execSQL("create table allusers(email TEXT primary key, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int i, int i1) {
        MyDatabase.execSQL("drop Table if exists allusers");
        onCreate(MyDatabase);


    }

    //signup db data part

    public boolean insertData(String email,String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long result = MyDatabase.insert("allusers",null,contentValues);

        if (result == -1){
            return false;
        }else {
            return true;
        }

    }
    public boolean checkEmail(String email){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("select * from allusers where email = ?",
                new String[]{email});

        if (cursor.getCount() > 0){
            return true;
        }else {
            return false;
        }
    }
    //check user name and password
    public boolean checkEmailPassword(String email,String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery
                ("select * from allusers where email = ? and password = ?",new String[]{email,password});

        if (cursor.getCount() > 0){
            return true;
        }else {
            return false;
        }

    }


}
