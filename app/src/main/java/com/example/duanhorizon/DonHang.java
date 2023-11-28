package com.example.duanhorizon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duanhorizon.database.DbHelper;
import com.example.duanhorizon.model.SanPham;
import com.squareup.picasso.Picasso;

public class DonHang extends AppCompatActivity {
    ImageView imgAnhSP;
    TextView txtTenSP,txtSoLuongTai,txtDungLuong,txtGia,txtmota;
    Button btnMua;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_don_hang);
        imgAnhSP = findViewById(R.id.imgSanPhamdonhang);
        txtGia = findViewById(R.id.txtGiaChiTiet);
        txtTenSP = findViewById(R.id.txtTenSP);
        txtSoLuongTai = findViewById(R.id.txtSoLuongTai);
        txtDungLuong = findViewById(R.id.txtDungLuong);
        txtmota = findViewById(R.id.txtMoTaChiTiet);
        btnMua = findViewById(R.id.btnMuaHangChiTiet);

        dbHelper = new DbHelper(this);

        // Lấy dữ liệu xác định sp
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String maSP = bundle.getString("maSP", "");

            // Sử dụng phương thức getSanPham từ dbHelper để lấy thông tin sản phẩm
            SanPham sanPham = dbHelper.getSanPham(maSP);

            if (sanPham != null) {
                // Hiển thị thông tin sản phẩm lên các TextView
                txtTenSP.setText("Tên: " + sanPham.getTenSanPham());
                txtGia.setText("Giá: " + String.valueOf(sanPham.getGia()) + "VND");
                txtSoLuongTai.setText("Số lượng tải: " + String.valueOf(sanPham.getSoLuongTai()));
                txtDungLuong.setText("Dung lượng: " + sanPham.getDungLuong());
                txtmota.setText(sanPham.getMoTa());

                // Sử dụng Picasso để tải và hiển thị ảnh sản phẩm
                Picasso.get().load(sanPham.getAnhSP()).into(imgAnhSP);
            } else {
                // Xử lý trường hợp sản phẩm không tồn tại
                Log.d("DonHangActivity", "Không tìm thấy sản phẩm với mã: " + maSP);
            }
        }
    }
}