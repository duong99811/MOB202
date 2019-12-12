package com.example.qunlthuchi.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.qunlthuchi.database.DatabaseHelper;
import com.example.qunlthuchi.model.KhoanChi;
import com.example.qunlthuchi.model.LoaiChi;

import java.util.ArrayList;
import java.util.List;

public class LoaiChiDAO {
    private SQLiteDatabase sqliteDB;
    private DatabaseHelper dbHelper;
    private Context context;

    public LoaiChiDAO(Context context) {
        this.context = context;
        dbHelper = new DatabaseHelper(context);
        sqliteDB = dbHelper.getWritableDatabase();
    }

    public boolean insertLoaiChi(LoaiChi objLoaiChi) {
        try {
            ContentValues values = new ContentValues();
            values.put("maLC", objLoaiChi.getMaloaichi());
            values.put("tenLC", objLoaiChi.getTenloaichi());
            long numInsert = sqliteDB.insert("LoaiChi", null, values);
            if (numInsert <= 0)
                return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    public List<LoaiChi> getAllLoaiChi(){
        List<LoaiChi> listLoaiChi = new ArrayList<>();
        Cursor cursor =sqliteDB.rawQuery("select maLC,tenLC from LoaiChi",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            LoaiChi loaiChi = new LoaiChi();
            loaiChi.setMaloaichi(cursor.getString(0));
            loaiChi.setTenloaichi(cursor.getString(1));
            listLoaiChi.add(loaiChi);
            cursor.moveToNext();
        }
        return listLoaiChi;
    }
    public int xoaLoaiChi(String maLoaiChi) {
        return sqliteDB.delete("LoaiChi", "maLC=?", new String[]{maLoaiChi});
    }
//    public  long update(LoaiChi loaiChi){
//        ContentValues values = new ContentValues();
//        values.put("tenLC",loaiChi.getTenloaichi());
//        long result = sqliteDB.update("LoaiChi",values,"maLC=?",new String[]{}
//        return result;
//    }
}
