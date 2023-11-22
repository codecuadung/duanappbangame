package com.example.duanhorizon.model;

public class SanPham {
    private int maSanPham;
    private String tenSanPham;
    private String gia;
    private int maLoai;
    private int soLuongTai;
    private String anhSP;

    public String getAnhSP() {
        return anhSP;
    }

    public void setAnhSP(String anhSP) {
        this.anhSP = anhSP;
    }

    public SanPham(int maSanPham, String tenSanPham, String gia, int maLoai, int soLuongTai, String anhSP) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.maLoai = maLoai;
        this.soLuongTai = soLuongTai;
        this.anhSP = anhSP;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public int getSoLuongTai() {
        return soLuongTai;
    }

    public void setSoLuongTai(int soLuongTai) {
        this.soLuongTai = soLuongTai;
    }

    public SanPham(int maSanPham, String tenSanPham, String gia, int maLoai, int soLuongTai) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.maLoai = maLoai;
        this.soLuongTai = soLuongTai;
    }

    public SanPham() {
    }
}
