package com.example.duanhorizon.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duanhorizon.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_GioHang#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_GioHang extends Fragment {

<<<<<<< HEAD:app/src/main/java/com/example/duanhorizon/Fragment/Fragment_ThongTin.java
    public Fragment_ThongTin() {
        // Required empty public constructor
    }


    public static Fragment_ThongTin newInstance() {
        Fragment_ThongTin fragment = new Fragment_ThongTin();
=======
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_GioHang() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_ThongTin.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_GioHang newInstance(String param1, String param2) {
        Fragment_GioHang fragment = new Fragment_GioHang();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
>>>>>>> b57e4928fddd96be69c15e93f750885a9b840773:app/src/main/java/com/example/duanhorizon/Fragment/Fragment_GioHang.java
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
        return inflater.inflate(R.layout.fragment__gio_hang, container, false);
    }
}