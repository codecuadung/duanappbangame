package com.example.duanhorizon.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duanhorizon.database.DbHelper;
import com.example.duanhorizon.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungDAO {
    private SQLiteDatabase db;
    public NguoiDungDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public long insert(NguoiDung obj) {
        ContentValues values = new ContentValues();
        values.put("maNguoiDung", obj.getMaNguoiDung());
        values.put("tenNguoiDung", obj.getTenNguoiDung());
        values.put("matKhau", obj.getMatKhau());
        values.put("vaiTro",1);
        return db.insert("NguoiDung", null, values);
    }
    public long updatePass(NguoiDung obj) {
        ContentValues values = new ContentValues();
        values.put("tenNguoiDung", obj.getTenNguoiDung());
        values.put("matKhau", obj.getMatKhau());
        return db.update("NguoiDung", values, "maNguoiDung=?", new String[]{String.valueOf(obj.getMaNguoiDung())});
    }
    public int delete(String id){
        return db.delete("NguoiDung","maNguoiDung=?",new String[]{id});
    }
    public List<NguoiDung>getAll(){
        String sql = "SELECT * FROM NguoiDung";
        return getData(sql);
    }
    @SuppressLint("Range")
    public List<NguoiDung> getData(String sql, String...selectionArgs){
        List<NguoiDung>list = new ArrayList<NguoiDung>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            NguoiDung obj = new NguoiDung();
            obj.setMaNguoiDung((c.getString(c.getColumnIndex("maNguoiDung"))));
            obj.setTenNguoiDung(c.getString(c.getColumnIndex("tenNguoiDung")));
            obj.setMatKhau(c.getString(c.getColumnIndex("matKhau")));
            list.add(obj);
        }
        return list;
    }
    public boolean checkUserExists(String mauser) {
        String sql = "SELECT * FROM NguoiDung WHERE maNguoiDung=?";
        List<NguoiDung> list = getData(sql, mauser);
        return !list.isEmpty();
    }

    public NguoiDung getid(String id){
        String sql = "SELECT * FROM NguoiDung WHERE maNguoiDung=?";
        List<NguoiDung>list = getData(sql,id);
        return list.get(0);
    }
    public int checkLogin(String id,String password){
        String sql = "SELECT * FROM NguoiDung WHERE tenNguoiDung=? AND matKhau=?";
        List<NguoiDung>list = getData(sql,id,password);
        if(list.size()==0)
            return -1;
        return 1;

    }

}
