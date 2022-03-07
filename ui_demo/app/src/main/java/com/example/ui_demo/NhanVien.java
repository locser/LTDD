package com.example.ui_demo;

import android.graphics.drawable.Drawable;
import android.net.Uri;

public class NhanVien {
    String maNV;
    String tenNV;
    String gioitinh;
    String donvi;
    Drawable d;

    public NhanVien(String maNV, String tenNV, String gioitinh, String donvi, Drawable d) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioitinh = gioitinh;
        this.donvi = donvi;
        this.d= d;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Drawable getD() {
        return d;
    }

    public void setD(Drawable d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNV='" + maNV +
                ", tenNV='" + tenNV +
                ", gioitinh='" + gioitinh +
                ", donvi='" + donvi +
                '}';
    }
}
