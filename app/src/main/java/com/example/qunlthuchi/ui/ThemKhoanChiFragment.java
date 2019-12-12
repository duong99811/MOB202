package com.example.qunlthuchi.ui;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.qunlthuchi.R;
import com.example.qunlthuchi.dao.KhoanChiDAO;
import com.example.qunlthuchi.dao.LoaiChiDAO;
import com.example.qunlthuchi.model.KhoanChi;
import com.example.qunlthuchi.model.LoaiChi;

import java.util.Calendar;
import java.util.List;

public class ThemKhoanChiFragment extends Fragment {
    EditText edmaKC, edtenKC, edTienKC;
    Spinner spnLC;
    TextView tvNgay;
    Button btnNgay;
    Calendar calendar;
    DatePickerDialog dpDialog;
    List<LoaiChi> listLoaiChi;
    Button btnThemKhoanChi;
    LoaiChiDAO loaiChiDAO;
    KhoanChiDAO khoanChiDAO;
    List<KhoanChi> listKhoanChi;
    public ThemKhoanChiFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_them_khoan_chi, container, false);
        edmaKC = view.findViewById(R.id.edMaKC);
        edtenKC = view.findViewById(R.id.edTenKC);
        edTienKC = view.findViewById(R.id.edTienKC);
        tvNgay = view.findViewById(R.id.tvNgay);
        btnNgay = view.findViewById(R.id.btnNgay);
        btnThemKhoanChi = view.findViewById(R.id.btnThemKhoanChi);
        khoanChiDAO = new KhoanChiDAO(getActivity());
        loaiChiDAO = new LoaiChiDAO(getActivity());
        listLoaiChi = loaiChiDAO.getAllLoaiChi();
        //date picker
        btnNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);
                dpDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                        tvNgay.setText(mDay + " / " + mMonth + " / " + mYear);
                    }
                }, day, month, year);
                dpDialog.show();
            }
        });
        //spinner
        spnLC = view.findViewById(R.id.spnLoaiChi);
        getSpinner();
        //Thêm
        btnThemKhoanChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoaiChi loaiChi = (LoaiChi) spnLC.getSelectedItem();
                String maloaichi = loaiChi.getMaloaichi();
                String makhoanchi = edmaKC.getText().toString();
                String tenkhoanchi = edtenKC.getText().toString();
                String sotien = edTienKC.getText().toString();
                String ngaychi = tvNgay.getText().toString();
                KhoanChi khoanChi = new KhoanChi(makhoanchi, tenkhoanchi, maloaichi, sotien, ngaychi);
                boolean isSuccess =khoanChiDAO.insertKhoanChiKhoanChi(khoanChi);
                if(isSuccess){
                    Toast.makeText(getActivity(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getActivity(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    public void getSpinner() {
        ArrayAdapter<LoaiChi> adapter = new ArrayAdapter<LoaiChi>(getActivity(),
                android.R.layout.simple_spinner_item, listLoaiChi);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnLC.setAdapter(adapter);
    }
}
