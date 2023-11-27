package com.example.duanhorizon.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duanhorizon.DAO.LoaiSanPhamDAO;
import com.example.duanhorizon.R;
import com.example.duanhorizon.adapters.AdapterTheLoai;
import com.example.duanhorizon.model.LoaiSanPham;

import java.util.ArrayList;
import java.util.List;

public class Fragment_TheLoai extends Fragment {
    private RecyclerView rcv;
    private AdapterTheLoai adapter;
    private List<LoaiSanPham> listTheloai;
    private LoaiSanPhamDAO dao;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment__the_loai, container, false);
        rcv = view.findViewById(R.id.recyclerViewTheLoai);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcv.setLayoutManager(layoutManager);
        //khởi tạo dao và adapter
        dao = new LoaiSanPhamDAO(getContext());
        listTheloai = new ArrayList<>();
        adapter = new AdapterTheLoai(listTheloai);

        AdapterTheLoai.OnItemClickListener clickListener = new AdapterTheLoai.OnItemClickListener() {
            @Override
            public void onItemClick(LoaiSanPham loaiSanPham) {
                Fragment_TheLoai.this.onItemClick(loaiSanPham);
            }
        };
        adapter.setOnItemClickListener(clickListener);
        //load dữ liệu từ csdl
        listTheloai.addAll(dao.getAll());
        rcv.setAdapter(adapter);
        return view;
    }
    public void onItemClick(LoaiSanPham loaiSanPham){
        Log.d("DEBUG", "MaLoai Clicked: " + loaiSanPham.getMaLoai());
        Fragment_SanPham fragmentSanPham = new Fragment_SanPham();
        //Truyền dữ liệu theloai
        Bundle bundle = new Bundle();
        bundle.putString("maLoai", String.valueOf(loaiSanPham.getMaLoai()));
        fragmentSanPham.setArguments(bundle);

        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragmentSanPham);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}