package com.example.qunlthuchi.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "DATABASE", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableLoaiChi = "create table LoaiChi(maLC text primary key,tenLC text)";
        String createTableKhoanChi = "create table KhoanChi(maKC text primary key,tenKC text,maLC text,soTien decimal,ngayChi text)";
        sqLiteDatabase.execSQL(createTableLoaiChi);
        sqLiteDatabase.execSQL(createTableKhoanChi);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("drop table if exists LoaiChi");
    sqLiteDatabase.execSQL("drop table if exists KhoanChi");
    onCreate(sqLiteDatabase);
    }
    public Cursor getData(String sql){
        SQLiteDatabase  db = getReadableDatabase();
        return db.rawQuery(sql,null);
    }
    public void  EditData(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }
}
