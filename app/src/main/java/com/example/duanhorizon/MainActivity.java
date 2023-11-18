package com.example.duanhorizon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.FrameLayout;


import com.example.duanhorizon.Fragment.Fragment_SanPham;
import com.example.duanhorizon.Fragment.Fragment_TaiKhoan;
import com.example.duanhorizon.Fragment.Fragment_ThongTin;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentContainer = findViewById(R.id.fragmentContainer);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_home) {
                showFragment(new Fragment_SanPham());
                return true;
            } else if (item.getItemId() == R.id.nav_ThongTin) {
                showFragment(new Fragment_ThongTin());
                return true;
            } else if (item.getItemId() == R.id.nav_TaiKhoan) {
                showFragment(new Fragment_TaiKhoan());
                return true;
            } else {
                return false;
            }
        });


        // Mặc định hiển thị FragmentSanPham khi ứng dụng được khởi chạy
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();

    }
}