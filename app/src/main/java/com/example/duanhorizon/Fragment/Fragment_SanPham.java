package com.example.duanhorizon.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duanhorizon.DAO.SanPhamDAO;
import com.example.duanhorizon.MainActivity;
import com.example.duanhorizon.R;
import com.example.duanhorizon.adapters.AdapterSanPham;
import com.example.duanhorizon.model.SanPham;

import java.util.ArrayList;

public class Fragment_SanPham extends Fragment {
    private ArrayList<SanPham> listSanPham = new ArrayList<>();
    private RecyclerView rcvSP;
    private AdapterSanPham adapterSanPham;
    private SanPhamDAO sanPhamDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment__san_pham, container, false);
        rcvSP = v.findViewById(R.id.rcvSP);
        sanPhamDAO = new SanPhamDAO(getActivity());
        listSanPham.addAll(sanPhamDAO.getAll());

        // Khởi tạo adapter và gán nó vào RecyclerView
        adapterSanPham = new AdapterSanPham(getActivity(), listSanPham);
        rcvSP.setAdapter(adapterSanPham);
        rcvSP.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Thông báo rằng dữ liệu đã thay đổi
        adapterSanPham.notifyDataSetChanged();

        return v;
    }

}
