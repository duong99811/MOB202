package com.example.qunlthuchi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qunlthuchi.R;
import com.example.qunlthuchi.dao.LoaiChiDAO;
import com.example.qunlthuchi.model.LoaiChi;

import java.util.List;

public class LoaiChiAdapter extends BaseAdapter {
    Context context;
    LoaiChiDAO loaiChiDAO;
    List<LoaiChi> listLoaiChi;

    public LoaiChiAdapter(Context context, List<LoaiChi> listLoaiChi) {
        this.context = context;
        this.listLoaiChi = listLoaiChi;
        loaiChiDAO = new LoaiChiDAO(context);
    }

    @Override
    public int getCount() {
        return listLoaiChi.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LoaiChiHolder loaiChiHolder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.lv_loai_chi,viewGroup,false);
            loaiChiHolder = new LoaiChiHolder();
            loaiChiHolder.tvMaLC = view.findViewById(R.id.tvMaLC);
            loaiChiHolder.tvTenLC =view.findViewById(R.id.tvTenLC);
            loaiChiHolder.imgXoaLoaiChi = view.findViewById(R.id.imgXoaLC);
            view.setTag(loaiChiHolder);
        }else{
            loaiChiHolder = (LoaiChiHolder) view.getTag();
        }
        loaiChiHolder.tvMaLC.setText(listLoaiChi.get(i).getMaloaichi());
        loaiChiHolder.tvTenLC.setText(listLoaiChi.get(i).getTenloaichi());
        loaiChiHolder.imgXoaLoaiChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = loaiChiDAO.xoaLoaiChi(listLoaiChi.get(i).getMaloaichi());
                if (result>0){
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    listLoaiChi.clear();
                    listLoaiChi = loaiChiDAO.getAllLoaiChi();
                    ondatasetchange(listLoaiChi);
                }
            }
        });
        return view;
    }
    public void ondatasetchange(List<LoaiChi> loaiChis) {
        this.listLoaiChi = loaiChis;
        notifyDataSetChanged();
    }
    public class LoaiChiHolder{
        TextView tvMaLC,tvTenLC;
        ImageView imgXoaLoaiChi;
    }
}
