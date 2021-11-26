package com.example.giaodientrangchu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.model.LichKhamDaHuy;
import com.example.model.LichKhamht;

import java.util.ArrayList;

public class DB_HUY extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;
    public static  final  String DB_NAME_HUY = "booking_huy.db";
    public  static final  String TBL_NAME_HUY="LichKham_huy";

    public DB_HUY(@Nullable Context context) {
        super(context, DB_NAME_HUY, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME_HUY+ "(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, date TEXT, time TEXT)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TBL_NAME_HUY);
        onCreate(db);
    }

    public ArrayList<LichKhamDaHuy> getAllLichKhamht(){
        ArrayList<LichKhamDaHuy> lichKhamDaHuys = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+ TBL_NAME_HUY, null );
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String date = cursor.getString(2);
                String time = cursor.getString(3);
                LichKhamDaHuy l1 = new LichKhamDaHuy(id, name,date, time);
                lichKhamDaHuys.add(l1);

            }while (cursor.moveToNext());
        }
        return lichKhamDaHuys;
    }



    public long addLichKhamht(LichKhamht l) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", l.getName());
        values.put("date", l.getDate());
        values.put("time",l.getTime());
        return sqLiteDatabase.insert(TBL_NAME_HUY,null,values);

    }
}
