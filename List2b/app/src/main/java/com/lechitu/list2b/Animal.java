package com.lechitu.list2b;

public class Animal {
    private String ten;
    private String mota;
    private int hinh;

    public Animal(String ten, String mota, int hinh) {
        this.ten = ten;
        this.mota = mota;
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public String getMota() {
        return mota;
    }

    public int getHinh() {
        return hinh;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}

