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

        // Nhận dữ liệu từ Bundle
        Bundle bundle = getArguments();

        // Khởi tạo adapter và gán nó vào RecyclerView
        adapterSanPham = new AdapterSanPham(getActivity(), listSanPham);
        listSanPham.addAll(sanPhamDAO.getAll());
        rcvSP.setAdapter(adapterSanPham);
        rcvSP.setLayoutManager(new LinearLayoutManager(getActivity()));
        Log.d("DEBUG", "Total SanPham: " + listSanPham.size());
        if (bundle != null) {
            String loaiSanPhamId = bundle.getString("maLoai");

            if (loaiSanPhamId != null) {

                // Hiển thị sản phẩm của loại đã chọn
                hienThiLoaiSP(loaiSanPhamId);

                // Thông báo rằng dữ liệu đã thay đổi
                adapterSanPham.notifyDataSetChanged();
            }
        }

        return v;
    }


    private void hienThiLoaiSP(String loaiSanPhamID) {
        ArrayList<SanPham> loaiList = new ArrayList<>();
        for (SanPham sanPham : listSanPham) {
            if (sanPham.getMaLoai() == Integer.parseInt(loaiSanPhamID)) {
                loaiList.add(sanPham);
            }
        }

        // Cập nhật dữ liệu trong listSanPham mà không thay đổi đối tượng trỏ đến
        listSanPham.clear();
        listSanPham.addAll(loaiList);

        adapterSanPham.setSanPhamList(listSanPham);
        adapterSanPham.notifyDataSetChanged();
    }


}
