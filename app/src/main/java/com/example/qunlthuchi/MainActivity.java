package com.example.qunlthuchi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.qunlthuchi.ui.ThemKhoanChiFragment;
import com.example.qunlthuchi.ui.ThemLoaiChiFragment;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.itQuanLyLoaiChi:
                fragment = new DanhSachLoaiChiFragment();
                this.setTitle("Danh sách loại chi");
                fragmentTransaction.replace(R.id.lo_Frame, fragment);
                fragmentTransaction.commit();
                return true;
            case R.id.itQuanLyKhoanChi:
                fragment = new DanhSachKhoanChiFragment();
                this.setTitle("Danh sách khoản chi");
                fragmentTransaction.replace(R.id.lo_Frame, fragment);
                fragmentTransaction.commit();
                return true;
            case R.id.itThongKe:
                fragment = new ThongKeFragment();
                this.setTitle("Danh sách thống kê");
                fragmentTransaction.replace(R.id.lo_Frame, fragment);
                fragmentTransaction.commit();
                return true;
            case R.id.itGioiThieu:
                fragment = new GioiThieuFragment();
                this.setTitle("Danh sách giới thiệu");
                fragmentTransaction.replace(R.id.lo_Frame, fragment);
                fragmentTransaction.commit();
                return true;

            case R.id.itThemLoaiChi:
                fragment = new ThemLoaiChiFragment();
                this.setTitle("Thêm loại chi");
                fragmentTransaction.replace(R.id.lo_Frame, fragment);
                fragmentTransaction.commit();
                return true;
            case R.id.itThemKhoanChi:
                fragment = new ThemKhoanChiFragment();
                this.setTitle("Thêm khoản chi");
                fragmentTransaction.replace(R.id.lo_Frame, fragment);
                fragmentTransaction.commit();
                return true;
            case R.id.itThoat:
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
