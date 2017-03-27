package com.example.blue.iamceo;

/**
 * Created by blue on 22/03/2017.
 */

public class DuAn {
    private String ten;
    private int capdo;
    private Long tien;
    private int han;
    private int tiendo;
    private int id;
    private int congviec;


    public DuAn(String ten, int capdo, Long tien, int han, int tiendo, int congviec) {
        this.ten = ten;
        this.capdo = capdo;
        this.tien = tien;
        this.han = han;
        this.tiendo = tiendo;

        this.congviec = congviec;
    }

    public DuAn(int id, String ten, int capdo, Long tien, int han, int tiendo, int congviec) {
        this.ten = ten;
        this.capdo = capdo;
        this.tien = tien;
        this.han = han;
        this.tiendo = tiendo;
        this.id = id;
        this.congviec = congviec;
    }

    public int getCongviec() {
        return congviec;
    }

    public void setCongviec(int congviec) {
        this.congviec = congviec;
    }

    public String getTen() {
        return ten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getCapdo() {
        return capdo;
    }

    public void setCapdo(int capdo) {
        this.capdo = capdo;
    }

    public Long getTien() {
        return tien;
    }

    public void setTien(Long tien) {
        this.tien = tien;
    }

    public int getHan() {
        return han;
    }

    public void setHan(int han) {
        this.han = han;
    }

    public int getTiendo() {
        return tiendo;
    }

    public void setTiendo(int tiendo) {
        this.tiendo = tiendo;
    }
}
