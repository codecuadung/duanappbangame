package com.example.duanhorizon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duanhorizon.DAO.NguoiDungDAO;
import com.example.duanhorizon.model.NguoiDung;

public class sign_up extends AppCompatActivity {
    EditText edUserdk,edPassdk,edRePassdk,edmaUser;
    Button btndk, btncancel;
    NguoiDungDAO nguoiDungDAO;
    NguoiDung nguoiDung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edmaUser = findViewById(R.id.edmaUser);
        edUserdk = findViewById(R.id.edUserdk);
        edPassdk = findViewById(R.id.edPassdk);
        edRePassdk = findViewById(R.id.edRePassdk);
        btndk = findViewById(R.id.btndk);
        btncancel = findViewById(R.id.btnCancel);

        btndk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mauser = edmaUser.getText().toString();
                String user = edUserdk.getText().toString();
                String pass = edPassdk.getText().toString();
                String repass = edRePassdk.getText().toString();
                nguoiDungDAO = new NguoiDungDAO(getApplicationContext());
                if(mauser.isEmpty()||user.isEmpty()||pass.isEmpty()||repass.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Vui lòng điển đầy đủ thông tin!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!pass.equals(repass)){
                    Toast.makeText(getApplicationContext(),"Mật khẩu không khớp!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (nguoiDungDAO.checkUserExists(mauser)) {
                    Toast.makeText(getApplicationContext(), "mã người dùng đã tồn tại. Vui lòng chọn mã khác.", Toast.LENGTH_SHORT).show();
                    return;
                }

                nguoiDung = new NguoiDung();
                nguoiDung.setMaNguoiDung(mauser);
                nguoiDung.setTenNguoiDung(user);
                nguoiDung.setMatKhau(pass);


                long result = nguoiDungDAO.insert(nguoiDung);
                if(result != -1){
                    Toast.makeText(getApplicationContext(),"Thêm thành công!",Toast.LENGTH_SHORT).show();
                    edmaUser.setText("");
                    edPassdk.setText("");
                    edUserdk.setText("");
                    edRePassdk.setText("");
                    startActivity(new Intent(sign_up.this, login.class));
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(),"Thêm thất bại!",Toast.LENGTH_SHORT).show();
                }
            }
        });`
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        return;
    }
}