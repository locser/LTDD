package com.example.a19507901_phamhuuloc;

import java.io.Serializable;

public class Sach implements Serializable {
    String ten;
    String tacgia;
    String nhaxb;
    int nam;

    public Sach(String ten, String tacgia, String nhaxb, int nam) {
        this.ten = ten;
        this.tacgia = tacgia;
        this.nhaxb = nhaxb;
        this.nam = nam;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getNhaxb() {
        return nhaxb;
    }

    public void setNhaxb(String nhaxb) {
        this.nhaxb = nhaxb;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    @Override
    public String toString() {
        return "Sach{" +
                "ten='" + ten + '\'' +
                ", tacgia='" + tacgia + '\'' +
                ", nhaxb='" + nhaxb + '\'' +
                ", nam=" + nam +
                '}';
    }
}
