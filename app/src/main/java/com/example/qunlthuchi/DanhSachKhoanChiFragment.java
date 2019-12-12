package com.example.qunlthuchi;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.qunlthuchi.adapter.KhoanChiAdapter;
import com.example.qunlthuchi.dao.KhoanChiDAO;
import com.example.qunlthuchi.model.KhoanChi;

import java.util.ArrayList;
import java.util.List;


public class DanhSachKhoanChiFragment extends Fragment {
    ListView lvDSKC;
    List<KhoanChi> listKhoanChi;
    KhoanChiDAO khoanChiDAO;
    KhoanChiAdapter khoanChiAdapter;
    public DanhSachKhoanChiFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_danh_sach_khoan_chi,container,false);
        lvDSKC = view.findViewById(R.id.lv_DSKC);
        listKhoanChi = new ArrayList<>();
        khoanChiDAO = new KhoanChiDAO(getActivity());
        listKhoanChi = khoanChiDAO.getAllKhoanChi();
        //Adapter
        khoanChiAdapter = new KhoanChiAdapter(getActivity(),listKhoanChi);
        lvDSKC.setAdapter(khoanChiAdapter);
        return view;
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_them_khoan_chi,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}
