package com.example.blue.iamceo.Fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.blue.iamceo.Adapter.CeoAdapter;
import com.example.blue.iamceo.Database.Database;
import com.example.blue.iamceo.Database.DatabaseManager;
import com.example.blue.iamceo.DuAn;
import com.example.blue.iamceo.NhanVien;
import com.example.blue.iamceo.R;
import com.example.blue.iamceo.SaveLoadPreferences;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class CEOFragment extends Fragment {

    private FragmentPagerAdapter fragmentPagerAdapter;
    private DatabaseManager databaseManager;
    private SaveLoadPreferences saveLoadPreferences;
    private static int tongLuong;

    public CEOFragment(FragmentPagerAdapter fragmentPagerAdapter) {
        this.fragmentPagerAdapter = fragmentPagerAdapter;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ceo, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_ceo);
        CeoAdapter ceoAdapter = new CeoAdapter(getContext());
        recyclerView.setHasFixedSize(true);
        databaseManager = new DatabaseManager(getContext());
        saveLoadPreferences = new SaveLoadPreferences(getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(ceoAdapter);
        Button button = (Button) view.findViewById(R.id.btnNextDay);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDay();
                setNhanVien();
                setNangSuat();
                taoDuAn();
                setTongTien();
                fragmentPagerAdapter.notifyDataSetChanged();
            }
        });
        return view;
    }

    private void setDay() {
        int day = saveLoadPreferences.loadInteger(SaveLoadPreferences.TONG_NGAY, 1);
        saveLoadPreferences.saveInteger(SaveLoadPreferences.TONG_NGAY, day + 1);
    }

    private void setNhanVien() {
        List<NhanVien> arrNhanvien = new ArrayList<>();
        Random random = new Random();
        int sl = random.nextInt(10);
        for (int i = 0; i < sl; i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.avatar);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] bitMapData = stream.toByteArray();
            NhanVien nhanVien = new NhanVien("Tong Thanh Tung", random.nextInt(5) + 1, bitMapData, 5, 1000, NhanVien.VUi_VE, random.nextInt(2) + 1);
            arrNhanvien.add(nhanVien);
            DatabaseManager databaseManager = new DatabaseManager(getContext());
            databaseManager.saveThemNhanVien(arrNhanvien);
        }

    }

    private void setNangSuat() {

        List<NhanVien> nhanVienList = databaseManager.getAllData(Database.TAB_NHANVIEN);
        tongLuong = 0;
        Random random = new Random();
        int[] arrint = new int[8];
        for (NhanVien nhanVien : nhanVienList) {
            tongLuong = nhanVien.getLuong() + tongLuong;
            arrint[0] = random.nextInt(100);
            databaseManager.upDate(nhanVien.getId(), arrint, Database.TAB_NHANVIEN);
        }
        nhanVienList = databaseManager.getAllData(Database.TAB_TRUONGNHOM);
        for (NhanVien nhanVien : nhanVienList) {
            tongLuong = nhanVien.getLuong() + tongLuong;
            arrint[0] = random.nextInt(100);
            databaseManager.upDate(nhanVien.getId(), arrint, Database.TAB_NHANVIEN);
        }
    }

    private void taoDuAn() {
        List<DuAn> duAnList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < random.nextInt(10); i++) {
            DuAn duAn = new DuAn("Ten Du An", random.nextInt(5) + 1, (long) 1000, 30, 0, 100);
            duAnList.add(duAn);
        }
        databaseManager.saveThemDuAn(duAnList);

    }

    private void setTongTien() {
        int tongTien = saveLoadPreferences.loadInteger(SaveLoadPreferences.TONG_TIEN, 100000);
        saveLoadPreferences.saveInteger(SaveLoadPreferences.TONG_TIEN, tongTien - tongLuong);
    }
}
