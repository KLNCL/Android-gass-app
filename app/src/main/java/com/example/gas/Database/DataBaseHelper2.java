package com.example.gas.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper2 extends SQLiteOpenHelper {

    //oder db
    public static final String DATABASE2 = "Order.bd";

    public static final String TABLE_NAME = "Order_Table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "ADDRESS";
    public static final String COL_4 = "GAS";
    public static final String COL_5 = "NUMBER";
    public static final String COL_6 = "STORE";

    public DataBaseHelper2(@Nullable Context context) {
        super(context, "orderdb",
                null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //order table
        sqLiteDatabase.execSQL("create table "+ TABLE_NAME +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+" NAME TEXT, " +
                "ADDRESS TEXT, GAS TEXT, NUMBER INTEGER,STORE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    // insert data for the order
    public boolean insertData(String name, String address, String gas, String number, String store) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,address);
        contentValues.put(COL_4,gas);
        contentValues.put(COL_5,number);
        contentValues.put(COL_6,store);
        long results = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if (results == -1)
            return false;
        else
            return true;
    }
    // view data for the order
    public Cursor getAllData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor results = sqLiteDatabase.rawQuery(" select * from "+ TABLE_NAME,null);
        return results;
    }

    // updatedata data in order
    public boolean updateData (String id,String name, String address, String gas,String number,String store){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,address);
        contentValues.put(COL_4,gas);
        contentValues.put(COL_5,number);
        contentValues.put(COL_6,store);
        sqLiteDatabase.update(TABLE_NAME,contentValues,"id=?",new  String[]{id});
        return true;
    }

    //delete data in order
    public Integer deleteData(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,"ID = ?",new String[]{id});
    }
}
