package com.example.duanhorizon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.duanhorizon.adapters.AdapterSanPham;
import com.example.duanhorizon.model.SanPham;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<SanPham> listSanPham = new ArrayList<>() ;
    private SanPham sanPham ;
    private RecyclerView rcvSP;
    private AdapterSanPham adapterSanPham ;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvSP = findViewById(R.id.rcvSP);
        sanPham = new SanPham(1,"PUBG: BATTLEGROUNDS","149000",112023001,10000);
        listSanPham.add(sanPham);
        sanPham = new SanPham(2,"Hunt: Showdown","499000",112023002,1423);
        listSanPham.add(sanPham);
        sanPham = new SanPham(3,"Arizona Sunshine","1299000",112023003,1862);
        listSanPham.add(sanPham);
        sanPham = new SanPham(4,"Project Zomboid","499000",112023004,1257);
        listSanPham.add(sanPham);
        sanPham = new SanPham(5,"New world","749000",112023005,2315);
        listSanPham.add(sanPham);
        sanPham = new SanPham(6,"Remnant","749000",112023006,1459);
        listSanPham.add(sanPham);
        adapterSanPham = new AdapterSanPham(MainActivity.this,listSanPham);
        rcvSP.setAdapter(adapterSanPham);
        rcvSP.setLayoutManager(new LinearLayoutManager(this));

    }
}