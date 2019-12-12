package com.example.qunlthuchi.model;

public class KhoanChi {
    private String makhoanchi;
    private String tenkhoanchi;
    private String maloaichi;
    private String sotien;
    private String ngaychi;

    public KhoanChi() {
    }

    public KhoanChi(String makhoanchi, String tenkhoanchi, String maloaichi, String sotien, String ngaychi) {
        this.makhoanchi = makhoanchi;
        this.tenkhoanchi = tenkhoanchi;
        this.maloaichi = maloaichi;
        this.sotien = sotien;
        this.ngaychi = ngaychi;
    }

    public String getMakhoanchi() {
        return makhoanchi;
    }

    public void setMakhoanchi(String makhoanchi) {
        this.makhoanchi = makhoanchi;
    }

    public String getTenkhoanchi() {
        return tenkhoanchi;
    }

    public void setTenkhoanchi(String tenkhoanchi) {
        this.tenkhoanchi = tenkhoanchi;
    }

    public String getMaloaichi() {
        return maloaichi;
    }

    public void setMaloaichi(String maloaichi) {
        this.maloaichi = maloaichi;
    }

    public String getSotien() {
        return sotien;
    }

    public void setSotien(String sotien) {
        this.sotien = sotien;
    }

    public String getNgaychi() {
        return ngaychi;
    }

    public void setNgaychi(String ngaychi) {
        this.ngaychi = ngaychi;
    }

    @Override
    public String toString() {
        return makhoanchi +" | "+sotien+" | "+ngaychi;
    }
}
