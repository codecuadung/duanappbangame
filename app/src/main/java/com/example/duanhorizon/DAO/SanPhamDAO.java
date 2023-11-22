package com.example.duanhorizon.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.duanhorizon.database.DbHelper;

public class SanPhamDAO {
    private SQLiteDatabase db;

    public SanPhamDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);


    }
}
