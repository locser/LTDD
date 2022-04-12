package com.example.sqlitedemo;

public class Author {
    private int id;
    private String ten;
    private String diachi;
    private String email;

    public Author(int id, String ten, String diachi, String email) {
        this.id = id;
        this.ten = ten;
        this.diachi = diachi;
        this.email = email;
    }
    public Author() {
        this.id = 0;
        this.ten = null;
        this.diachi = null;
        this.email = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", ten='" + ten +
                ", diachi='" + diachi +
                ", email='" + email +
                '}';
    }
}
