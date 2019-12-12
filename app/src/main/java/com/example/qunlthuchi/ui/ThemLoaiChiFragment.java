package com.example.qunlthuchi.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qunlthuchi.R;
import com.example.qunlthuchi.dao.LoaiChiDAO;
import com.example.qunlthuchi.model.LoaiChi;

public class ThemLoaiChiFragment extends Fragment {
    private LoaiChiDAO loaiChiDAO;
    public ThemLoaiChiFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        loaiChiDAO = new LoaiChiDAO(getContext());
        View view = inflater.inflate(R.layout.fragment_them_loai_chi, container, false);
        Button btnThem =view.findViewById(R.id.btnThemLoaiChi);
        final EditText edMaLoaiChi =view.findViewById(R.id.edMaLoaiChi);
        final EditText edTenLoaiChi =view.findViewById(R.id.edTenLoaiChi);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maLC =edMaLoaiChi.getText().toString();
                String tenLC =edTenLoaiChi.getText().toString();

                LoaiChi loaiChi = new LoaiChi(maLC,tenLC);
                boolean isSuccess = loaiChiDAO.insertLoaiChi(loaiChi);
                if(isSuccess){
                    Toast.makeText(getActivity(),"Thêm thành công",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getActivity(),"Thêm thất bại", Toast.LENGTH_LONG).show();
                }

            }
        });
        return view;
    }
}
