package com.example.qunlthuchi.model;

public class LoaiChi {
    private String maloaichi;
    private String tenloaichi;

    public LoaiChi() {
    }

    public LoaiChi(String maloaichi, String tenloaichi) {
        this.maloaichi = maloaichi;
        this.tenloaichi = tenloaichi;
    }

    public String getMaloaichi() {
        return maloaichi;
    }

    public void setMaloaichi(String maloaichi) {
        this.maloaichi = maloaichi;
    }

    public String getTenloaichi() {
        return tenloaichi;
    }

    public void setTenloaichi(String tenloaichi) {
        this.tenloaichi = tenloaichi;
    }

    @Override
    public String toString() {
        return maloaichi +" | "+ tenloaichi;
    }
}
