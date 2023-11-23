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
        // ... (phần khai báo và khởi tạo listSanPham)

// ... (phần khởi tạo adapterSanPham và RecyclerView)

        listSanPham.add(sanPham);
        adapterSanPham = new AdapterSanPham(getActivity(),listSanPham);
        rcvSP.setAdapter(adapterSanPham);
        rcvSP.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }
}