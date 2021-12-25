package com.example.giaodientrangchu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.model.LichKhamht;
import com.example.model.Postdiendan;

import java.util.ArrayList;

public class DB_DienDan extends SQLiteOpenHelper {
    public DB_DienDan(@Nullable Context context) {
        super(context, "diendan.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tbl_DienDan (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, time TEXT, content TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbl_DienDan");
        onCreate(db);

    }

    public long addDienDan(Postdiendan p) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", p.getName());
        values.put("time", p.getTime());
        values.put("content", p.getContent());

        return db.insert("tbl_DienDan",null, values);

    }

    public ArrayList<Postdiendan> getAllDienDan(){
        ArrayList<Postdiendan> postdiendans = new ArrayList<>();
        SQLiteDatabase db  = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tbl_DienDan", null);
        if(cursor.moveToFirst()){
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String time = cursor.getString(2);
                String content = cursor.getString(3);
                Postdiendan p = new Postdiendan(id,name, time, content);
                postdiendans.add(p);

            }while (cursor.moveToNext());
        }

        return postdiendans;

    }
    public int deleteDD(int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.delete("tbl_DienDan","id=?",new String[]{String.valueOf(id)});
    }

    public int updateDD(Postdiendan p) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", p.getName());
        values.put("time",p.getTime());
        values.put("content", p.getContent());
        return sqLiteDatabase.update("tbl_DienDan",values, "id=?",new String[]{String.valueOf(p.getId())});
    }
}
