package com.example.giaodientrangchu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.model.LichKhamht;

import java.util.ArrayList;
import java.util.Currency;

public class DBBooking extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;
    public static  final  String DB_NAME = "booking.db";
    public  static final  String TBL_NAME="LichKham";

    public DBBooking(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME+ "(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, date TEXT, time TEXT)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TBL_NAME);
        onCreate(db);
    }

    public long addLichKham(LichKhamht l) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", l.getName());
        values.put("date", l.getDate());
        values.put("time",l.getTime());
        return sqLiteDatabase.insert(TBL_NAME,null,values);


    }
    public ArrayList<LichKhamht> getAllLichKhamht(){
    ArrayList<LichKhamht> lichKhamhts = new ArrayList<>();
    SQLiteDatabase sqLiteDatabase = getReadableDatabase();
    Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+ TBL_NAME, null );
    if(cursor.moveToFirst()){
        do{
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String date = cursor.getString(2);
            String time = cursor.getString(3);
            LichKhamht l = new LichKhamht(id, name,date, time);
            lichKhamhts.add(l);

        }while (cursor.moveToNext());
    }
    return lichKhamhts;
    }

    public int updateLK(LichKhamht l) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", l.getName());
        values.put("date", l.getDate());
        values.put("time",l.getTime());
        return sqLiteDatabase.update(TBL_NAME,values, "id=?",new String[]{String.valueOf(l.getId())});

    }

    public int deleteLK(int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.delete(TBL_NAME,"id=?",new String[]{String.valueOf(id)});
    }
}
