package com.example.blue.iamceo;

/**
 * Created by blue on 15/03/2017.
 */

public class NhanVien {
    public static final int KY_THUAT = 1;
    public static final int NHAN_SU = 2;
    public static final int HANH_PHUC = 0;
    public static final int VUi_VE = 1;
    public static final int BINH_THUONG = 2;
    public static final int KHONG_HAI_LONG = 3;
    private String ten;
    private int capDo;
    private byte[] anh;
    private int nangLuc;
    private int luong;
    private int[] nangSuat;
    private int camXUc;
    private int nghe;
    private int id;
    private int thucLuc;


    public NhanVien() {
    }

    public NhanVien(String ten, int capDo, byte[] anh, int nangLuc, int luong, int camXUc, int nghe) {
        this.ten = ten;
        this.capDo = capDo;
        this.anh = anh;
        this.nangLuc = nangLuc;
        this.luong = luong;
        this.camXUc = camXUc;
        this.nghe = nghe;
    }
    public NhanVien( int capDo,String ten, byte[] anh, int nangLuc, int luong, int nghe) {
        this.ten = ten;
        this.capDo = capDo;
        this.anh = anh;
        this.nangLuc = nangLuc;
        this.luong = luong;
     this.nghe = nghe;

    }

    public NhanVien(int id,String ten, int capDo, byte[] anh, int nangLuc, int luong,  int camXUc, int nghe, int[] nangSuat) {
        this.ten = ten;
        this.capDo = capDo;
        this.anh = anh;
        this.nangLuc = nangLuc;
        this.luong = luong;
        this.nangSuat = nangSuat;
        this.camXUc = camXUc;
        this.nghe = nghe;
        this.id = id;
    }

    public NhanVien(int id, String ten, int capDo, byte[] anh, int nangLuc, int luong, int camXUc, int nghe ) {
        this.ten = ten;
        this.capDo = capDo;
        this.anh = anh;
        this.nangLuc = nangLuc;
        this.luong = luong;
        this.camXUc = camXUc;
        this.nghe = nghe;
        this.id = id;
    }

    public int getThucLuc() {
        return thucLuc;
    }

    public void setThucLuc(int thucLuc) {
        this.thucLuc = thucLuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getNghe() {
        return nghe;
    }

    public String getStringNghe() {
        if (nghe == 1) {
            return "Ky Thuat";
        } else {
            return "Nhan Su";
        }

    }

    public void setNghe(int nghe) {
        this.nghe = nghe;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public int[] getNangSuat() {
        return nangSuat;
    }

    public void setNangSuat(int[] nangSuat) {
        this.nangSuat = nangSuat;
    }

    public int getCamXUc() {
        return camXUc;
    }

    public void setCamXUc(int camXUc) {
        this.camXUc = camXUc;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getCapDo() {
        return capDo;
    }

    public void setCapDo(int capDo) {
        this.capDo = capDo;
    }

    public byte[] getAnh() {
        return anh;
    }

    public void setAnh(byte[] anh) {
        this.anh = anh;
    }


    public int getNangLuc() {
        return nangLuc;
    }

    public void setNangLuc(int nangLuc) {
        this.nangLuc = nangLuc;
    }
}
