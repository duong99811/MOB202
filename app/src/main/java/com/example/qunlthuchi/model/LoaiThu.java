package com.example.qunlthuchi.model;

public class LoaiThu {
    private String maloaithu;
    private String tenloaithu;

    public LoaiThu(String maloaithu, String tenloaithu) {
        this.maloaithu = maloaithu;
        this.tenloaithu = tenloaithu;
    }

    public LoaiThu() {
    }

    public String getMaloaithu() {
        return maloaithu;
    }

    public void setMaloaithu(String maloaithu) {
        this.maloaithu = maloaithu;
    }

    public String getTenloaithu() {
        return tenloaithu;
    }

    public void setTenloaithu(String tenloaithu) {
        this.tenloaithu = tenloaithu;
    }
}
