package com.example.ui_demo;

import android.graphics.drawable.Drawable;
import android.net.Uri;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien implements Serializable {

    String maNV;
    String tenNV;
    String gioitinh;
    String donvi;
    String imageUri;

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, String gioitinh, String donvi, String imageUri) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioitinh = gioitinh;
        this.donvi = donvi;
        this.imageUri = imageUri;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
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

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNV='" + maNV +
                ", tenNV='" + tenNV +
                ", gioitinh='" + gioitinh +
                ", donvi='" + donvi +
                ", imageUri='" + imageUri +
                '}';
    }

}
