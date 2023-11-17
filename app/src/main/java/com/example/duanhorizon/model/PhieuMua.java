package com.example.duanhorizon.model;

import java.util.Date;

public class PhieuMua {
private int maPhieuMua;
private int maNguoiDung;
private int maSanPham;
private Date ngay;

    public int getMaPhieuMua() {
        return maPhieuMua;
    }

    public void setMaPhieuMua(int maPhieuMua) {
        this.maPhieuMua = maPhieuMua;
    }

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public PhieuMua(int maPhieuMua, int maNguoiDung, int maSanPham, Date ngay) {
        this.maPhieuMua = maPhieuMua;
        this.maNguoiDung = maNguoiDung;
        this.maSanPham = maSanPham;
        this.ngay = ngay;
    }

    public PhieuMua() {
    }
}
