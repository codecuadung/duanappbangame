package com.example.duanhorizon.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanhorizon.DonHang;
import com.example.duanhorizon.R;
import com.example.duanhorizon.model.SanPham;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterSanPham extends RecyclerView.Adapter<AdapterSanPham.sanPhamViewHolder>{
    private Context mContext ;
    private ArrayList<SanPham> arrayList;
    private ArrayList<SanPham>sanPhamList;
    public void setSanPhamList(ArrayList<SanPham> sanPhamList){
        this.sanPhamList = sanPhamList;
    }
    public AdapterSanPham(Context mContext, ArrayList<SanPham> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public sanPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = ((Activity)mContext).getLayoutInflater().inflate(R.layout.layout_item_sp_1,parent,false);
        return new  sanPhamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull sanPhamViewHolder holder, int position) {
        SanPham sp = arrayList.get(position);
        holder.tenSP.setText(sp.getTenSanPham());
        holder.giaSP.setText(String.valueOf(sp.getGia()));
        Picasso.get().load(sp.getAnhSP()).into(holder.imgAnh);
    }
    @Override
    public int getItemCount() {
        if (arrayList !=null)
            return arrayList.size();
        return 0;
    }
    

    public static class sanPhamViewHolder extends RecyclerView.ViewHolder {
        private ImageButton imgAnh;
        private TextView tenSP , giaSP ;
        public sanPhamViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAnh = itemView.findViewById(R.id.imgSanPham);
            tenSP = itemView.findViewById(R.id.txtTenSP);
            giaSP = itemView.findViewById(R.id.txtGiaSP);
        }
    }
}
