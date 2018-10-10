package com.example.sql.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sql.model.Intern;

import java.util.ArrayList;
import java.util.List;

public class DbOpenHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "Intership";

    private static final String TABLE_NAME = "Interns";
    private static final String NAME = "Name";
    private static final String F_NAME = "Family Name";
    private static final String AGE = "Age";
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + " ( _id integer primary key autoincrement, "
    + NAME + " TEXT, " + F_NAME + ", TEXT " + AGE + ", INTEGER)";

    public DbOpenHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    onCreate(sqLiteDatabase);
    }

    public boolean saveData (String name, String fName, String age){
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv = new ContentValues();
    cv.put(NAME, name);
    cv.put(F_NAME, fName);
    cv.put(AGE, age);
    long result = db.insert(TABLE_NAME, null, cv);
    if (result == -1)
        return false;
    else
        return true;
    }

    public List<Intern> getAllIntern(){
    List<Intern> info = new ArrayList<>();
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery("select * from " + TABLE_NAME, null);
    if (cursor.moveToFirst()){
        do {
            Intern intern = new Intern();
            intern.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            intern.setName(cursor.getString(cursor.getColumnIndex(DbOpenHelper.NAME)));
            intern.setName(cursor.getString(cursor.getColumnIndex(DbOpenHelper.F_NAME)));
            intern.setName(cursor.getString(cursor.getColumnIndex(DbOpenHelper.AGE)));
            info.add(intern);
        }while (cursor.moveToNext());
    }
    db.close();
    return info;
    }
}
