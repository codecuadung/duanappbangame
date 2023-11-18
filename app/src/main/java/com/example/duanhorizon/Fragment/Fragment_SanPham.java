package com.example.duanhorizon.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duanhorizon.MainActivity;
import com.example.duanhorizon.R;
import com.example.duanhorizon.adapters.AdapterSanPham;
import com.example.duanhorizon.model.SanPham;

import java.util.ArrayList;

public class Fragment_SanPham extends Fragment {
    private ArrayList<SanPham> listSanPham = new ArrayList<>() ;
    private SanPham sanPham ;
    private RecyclerView rcvSP;
    private AdapterSanPham adapterSanPham ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment__san_pham, container, false);
        rcvSP = v.findViewById(R.id.rcvSP);
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
        adapterSanPham = new AdapterSanPham(getActivity(),listSanPham);
        rcvSP.setAdapter(adapterSanPham);
        rcvSP.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }
}