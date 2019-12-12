package com.example.qunlthuchi;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.qunlthuchi.adapter.LoaiChiAdapter;
import com.example.qunlthuchi.dao.LoaiChiDAO;
import com.example.qunlthuchi.database.DatabaseHelper;
import com.example.qunlthuchi.model.LoaiChi;

import java.util.ArrayList;
import java.util.List;


public class DanhSachLoaiChiFragment extends Fragment {
    ListView lvLoaiChi;
    List<LoaiChi> listLoaiChi;
    LoaiChiDAO loaiChiDAO;
    LoaiChiAdapter loaiChiAdapter;
    Intent intent;

    public DanhSachLoaiChiFragment() {

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_danh_sach_loai_chi, container, false);
        lvLoaiChi = view.findViewById(R.id.lv_DSLC);
        listLoaiChi = new ArrayList<>();
        loaiChiDAO = new LoaiChiDAO(getActivity());
        listLoaiChi = loaiChiDAO.getAllLoaiChi();

        //adapter
        loaiChiAdapter = new LoaiChiAdapter(getActivity(), listLoaiChi);
        lvLoaiChi.setAdapter(loaiChiAdapter);
        lvLoaiChi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, final long l) {
//                intent = new Intent(getActivity(), SuaLoaiChiActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("maLC", listLoaiChi.get(i).getMaloaichi());
//                bundle.putString("tenLC", listLoaiChi.get(i).getTenloaichi());
//                intent.putExtras(bundle);
//                startActivity(intent);
                final LoaiChi loaiChi = listLoaiChi.get(i);
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.dialog_edit);
                final EditText edSuaMaLoaiChi = dialog.findViewById(R.id.edSuaMaLoaiChi);
                final EditText edSuaTenLoaiChi = dialog.findViewById(R.id.edSuaTenLoaiChi);
                Button btnSuaLoaiChi = dialog.findViewById(R.id.btnSuaLoaiChi);
                edSuaMaLoaiChi.setText(loaiChi.getMaloaichi());
                edSuaTenLoaiChi.setText(loaiChi.getTenloaichi());
                edSuaMaLoaiChi.getText().toString();
                edSuaTenLoaiChi.getText().toString();


                btnSuaLoaiChi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String maLC = loaiChi.getMaloaichi();
                        String tenLC = loaiChi.getTenloaichi();
                        DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
                        databaseHelper.EditData("UPDATE LoaiChi SET maLC = '" + edSuaMaLoaiChi.getText() + "' WHERE maLC ='" + maLC + "'");
                        databaseHelper.EditData("UPDATE LoaiChi SET tenLC = '" + edSuaTenLoaiChi.getText() + "' WHERE tenLC ='" + tenLC + "'");
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_them_loai_chi, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
