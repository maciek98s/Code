package com.example.assignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String Database_Name = "Cooking.db";
    public static final String Table_Name = "recipes";
    public static final String COL1 = "ID";
    public static final String COL2 = "RecipeName";
    public static final String COL3 = "Style";
    public static final String COL4 = "AverageCreationTime";




    public DatabaseHelper(@Nullable Context context) {
        super(context, Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ Table_Name + " (ID INTEGER primary key Autoincrement,RecipeName text,Style text,AverageCreationTime text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if EXISTS "+Table_Name);
        onCreate(db);

    }

    public boolean insertData(String RecipeName,String Style,String AverageCreationTime)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,RecipeName);
        contentValues.put(COL3,Style);
        contentValues.put(COL4,AverageCreationTime);
        long result = db.insert(Table_Name,null,contentValues);
        if (result == -1)
            return  false;
        else
            return true;

    }

}
