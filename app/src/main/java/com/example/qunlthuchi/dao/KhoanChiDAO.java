package com.example.qunlthuchi.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.qunlthuchi.database.DatabaseHelper;
import com.example.qunlthuchi.model.KhoanChi;

import java.util.ArrayList;
import java.util.List;

public class KhoanChiDAO {
    private SQLiteDatabase sqliteDB;
    private DatabaseHelper dbHelper;
    private Context context;

    public KhoanChiDAO(Context context) {
        this.context = context;
        dbHelper = new DatabaseHelper(context);
        sqliteDB = dbHelper.getWritableDatabase();
    }

    public boolean insertKhoanChiKhoanChi(KhoanChi objKhoanChi) {
        try {
            ContentValues values = new ContentValues();
            values.put("maKC", objKhoanChi.getMakhoanchi());
            values.put("tenKC", objKhoanChi.getTenkhoanchi());
            values.put("maLC", objKhoanChi.getMaloaichi());
            values.put("soTien", objKhoanChi.getSotien());
            values.put("ngayChi", objKhoanChi.getNgaychi());
            long numInsert = sqliteDB.insert("KhoanChi", null, values);
            if (numInsert <= 0)
                return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public List<KhoanChi> getAllKhoanChi() {
        List<KhoanChi> listKhoanChi = new ArrayList<>();
        Cursor cursor = dbHelper.getData("select* from KhoanChi");
        listKhoanChi.clear();
        while (cursor.moveToNext()) {
            KhoanChi khoanChi = new KhoanChi();
            khoanChi.setMakhoanchi(cursor.getString(cursor.getColumnIndex("maKC")));
            khoanChi.setTenkhoanchi(cursor.getString(cursor.getColumnIndex("tenKC")));
            khoanChi.setMaloaichi(cursor.getString(cursor.getColumnIndex("maLC")));
            khoanChi.setSotien(cursor.getString(cursor.getColumnIndex("soTien")));
            khoanChi.setNgaychi(cursor.getString(cursor.getColumnIndex("ngayChi")));
            listKhoanChi.add(khoanChi);
        }
        return listKhoanChi;
    }
    public int xoaKhoanChi(String maKC) {
        return sqliteDB.delete("KhoanChi", "maKC=?", new String[]{maKC});
    }
}
