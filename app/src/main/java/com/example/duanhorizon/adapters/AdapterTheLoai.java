package com.example.duanhorizon.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanhorizon.R;
import com.example.duanhorizon.model.LoaiSanPham;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterTheLoai extends RecyclerView.Adapter<AdapterTheLoai.TheLoaiViewHolder> {
    private List<LoaiSanPham> listLoaiSanPham;

    public AdapterTheLoai(List<LoaiSanPham> listLoaiSanPham) {
        this.listLoaiSanPham = listLoaiSanPham;
    }

    @NonNull
    @Override
    public TheLoaiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_theloai,parent,false);
        return new TheLoaiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TheLoaiViewHolder holder, int position) {
        LoaiSanPham loaiSanPham = listLoaiSanPham.get(position);
        // Load ảnh từ URL bằng Picasso
        Picasso.get().load(loaiSanPham.getAnhTL()).into(holder.imgTheLoai);

        holder.txtTheLoai.setText(loaiSanPham.getTenLoai());

    }

    @Override
    public int getItemCount() {
        return listLoaiSanPham.size();
    }

    public static class TheLoaiViewHolder extends RecyclerView.ViewHolder{
        public ImageButton imgTheLoai;
        public TextView txtTheLoai;
        public TheLoaiViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTheLoai = itemView.findViewById(R.id.imgTheLoai);
            txtTheLoai = itemView.findViewById(R.id.txtTheLoai);
        }
    }
}
