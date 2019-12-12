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
import com.example.qunlthuchi.dao.KhoanChiDAO;
import com.example.qunlthuchi.model.KhoanChi;

import java.util.List;

public class KhoanChiAdapter extends BaseAdapter {
    Context context;
    KhoanChiDAO khoanChiDAO;
    List<KhoanChi> listKhoanChi;

    public KhoanChiAdapter(Context context, List<KhoanChi> listKhoanChi) {
        this.context = context;
        this.listKhoanChi = listKhoanChi;
        khoanChiDAO = new KhoanChiDAO(context);
    }

    @Override
    public int getCount() {
        return listKhoanChi.size();
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
        KhoanChiHolder khoanChiHolder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.lv_khoan_chi,viewGroup,false);
            khoanChiHolder = new KhoanChiHolder();
            khoanChiHolder.tvMaKC =view.findViewById(R.id.tvMaKC);
            khoanChiHolder.tvTienKC = view.findViewById(R.id.tvTienKC);
            khoanChiHolder.tvNgayKC = view.findViewById(R.id.tvNgayKC);
            khoanChiHolder.imgXoaKC = view.findViewById(R.id.imgXoaKC);
            view.setTag(khoanChiHolder);
        }else {
            khoanChiHolder =(KhoanChiHolder) view.getTag();
        }
        khoanChiHolder.tvMaKC.setText(listKhoanChi.get(i).getMakhoanchi());
        khoanChiHolder.tvTienKC.setText(listKhoanChi.get(i).getSotien());
        khoanChiHolder.tvNgayKC.setText(listKhoanChi.get(i).getNgaychi());
        khoanChiHolder.imgXoaKC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result= khoanChiDAO.xoaKhoanChi(listKhoanChi.get(i).getMakhoanchi());
                if (result>0){
//                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    listKhoanChi.clear();
                    listKhoanChi = khoanChiDAO.getAllKhoanChi();
                    ondatasetchange(listKhoanChi);
                }
            }
        });
        return view;
    }
    public void ondatasetchange(List<KhoanChi> khoanChis) {
        this.listKhoanChi = khoanChis;
        notifyDataSetChanged();
    }
    public class KhoanChiHolder{
        TextView tvMaKC,tvTienKC,tvNgayKC;
        ImageView imgXoaKC;
    }

}
