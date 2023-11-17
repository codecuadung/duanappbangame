package com.example.duanhorizon.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "APPBANGAME";
    public static final int DB_VERSION = 1;
    static final String CREATE_TABLE_NGUOI_DUNG = ""+
            "CREATE TABLE NguoiDung (\n" +
            "    maNguoiDung TEXT NOT NULL PRIMARY KEY ,\n" +
            "    tenNguoiDung TEXT NOT NULL,\n" +
            "    matKhau TEXT NOT NULL,\n" +
            "    vaiTro INTEGER CHECK (vaiTro IN (0, 1)) NOT NULL\n" +
            ")";
    //1 :quyền admin
    //2 :quyền user

    static final String CREATE_TABLE_SAN_PHAM = ""+
           "CREATE TABLE SanPham (\n" +
            "    maSanPham INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    tenSanPham TEXT NOT NULL,\n" +
            "    gia INTEGER NOT NULL,\n" +
            "    soLuongTai INTEGER NOT NULL,\n" +
            "    maLoai INTEGER NOT NULL,\n" +
            "    FOREIGN KEY (maLoai) REFERENCES LoaiSanPham(maLoai)\n" +
            ")\n";
    static final String CREATE_TABLE_LOAI_SAN_PHAM = ""+
            "CREATE TABLE LoaiSanPham (\n" +
            "    maLoai INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    TenLoaiSanPham TEXT NOT NULL\n" +
            ")";
    static final String CREATE_TABLE_PHIEU_MUA = ""+
            "CREATE TABLE PhieuMua (\n" +
            "    maPhieuMua INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    maNguoiDung INTEGER NOT NULL,\n" +
            "    maSanPham INTEGER NOT NULL,\n" +
            "    ngay DATE NOT NULL,\n" +
            "    FOREIGN KEY (maNguoiDung) REFERENCES NguoiDung(maNguoiDung),\n" +
            "    FOREIGN KEY (maSanPham) REFERENCES SanPham(maSanPham)\n" +
            ")";
    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_NGUOI_DUNG);
        db.execSQL(CREATE_TABLE_SAN_PHAM);
        db.execSQL(CREATE_TABLE_LOAI_SAN_PHAM);
        db.execSQL(CREATE_TABLE_PHIEU_MUA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion>oldVersion){
            String dropNguoiDung = "DROP TABLE IF EXISTS NguoiDung";
            db.execSQL(dropNguoiDung);
            String dropSanPham = "DROP TABLE IF EXISTS SanPham";
            db.execSQL(dropSanPham);
            String dropLoaiSanPham = "DROP TABLE IF EXISTS LoaiSanPham";
            db.execSQL(dropLoaiSanPham);
            String dropPhieuMua = "DROP TABLE IF EXISTS PhieuMua";
            db.execSQL(dropPhieuMua);
        }
    }
}
