package com.example.listview_spinner;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class SanPham{
    String ten;
    int gia;
    String loaisua;
    int dungtich;
    String thuonghieu;
    String noisx;
    int imgSP;
    String ttbosung;

    public SanPham(String ten, int gia, String loaisua, int dungtich, String thuonghieu, String noisx, int imgSP, String ttbosung) {
        this.ten = ten;
        this.gia = gia;
        this.loaisua = loaisua;
        this.dungtich = dungtich;
        this.thuonghieu = thuonghieu;
        this.noisx = noisx;
        this.imgSP = imgSP;
        this.ttbosung=ttbosung;
    }

    public String getTtbosung() {
        return ttbosung;
    }

    public void setTtbosung(String ttbosung) {
        this.ttbosung = ttbosung;
    }

    public int getImgSP() {
        return imgSP;
    }

    public void setImgSP(int imgSP) {
        this.imgSP = imgSP;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getLoaisua() {
        return loaisua;
    }

    public void setLoaisua(String loaisua) {
        this.loaisua = loaisua;
    }

    public int getDungtich() {
        return dungtich;
    }

    public void setDungtich(int dungtich) {
        this.dungtich = dungtich;
    }

    public String getThuonghieu() {
        return thuonghieu;
    }

    public void setThuonghieu(String thuonghieu) {
        this.thuonghieu = thuonghieu;
    }

    public String getNoisx() {
        return noisx;
    }

    public void setNoisx(String noisx) {
        this.noisx = noisx;
    }


}
