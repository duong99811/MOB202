package com.example.qunlthuchi.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qunlthuchi.R;
import com.example.qunlthuchi.dao.LoaiChiDAO;

public class SuaLoaiChiActivity extends AppCompatActivity {
    EditText edTenLC, edMaLC;
    Button btnSuaLC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_loai_chi);
        edMaLC = findViewById(R.id.edSuaMaLoaiChi);
        edTenLC = findViewById(R.id.edSuaTenLoaiChi);
        btnSuaLC = findViewById(R.id.btnSuaLoaiChi);

//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        if (bundle == null) {
//            edMaLC.setText(bundle.getString("maLC"));
//            edTenLC.setText(bundle.getString("tenLC"));
//        }
        btnSuaLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
