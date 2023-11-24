package com.example.duanhorizon.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duanhorizon.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_TaiKhoan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_TaiKhoan extends Fragment {

    public Fragment_TaiKhoan() {
        // Required empty public constructor
    }


    public static Fragment_TaiKhoan newInstance() {
        Fragment_TaiKhoan fragment = new Fragment_TaiKhoan();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__tai_khoan, container, false);
    }
}