package com.example.blue.iamceo.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.blue.iamceo.Activity.ThemNhanVienActivity;
import com.example.blue.iamceo.Adapter.Group;
import com.example.blue.iamceo.Adapter.NhanVienAdapter;
import com.example.blue.iamceo.Database.DatabaseManager;
import com.example.blue.iamceo.NhanVien;
import com.example.blue.iamceo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NhanSuFragment extends Fragment {


    public NhanSuFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_nhan_su, container, false);
        RecyclerView recyclerView=(RecyclerView) view.findViewById(R.id.recycler_kythuat);
        Button btnThemNhanVien=(Button) view.findViewById(R.id.btn_them_nhan_vien);
        btnThemNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ThemNhanVienActivity.class);
                startActivity(intent);
            }
        });
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        List<Group> groups = new ArrayList<>();
        DatabaseManager databaseManager = new DatabaseManager(getContext());
        List<NhanVien> nhanViens = new ArrayList<>();
        List<NhanVien> arrNhanvien = databaseManager.getAllDataTN(NhanVien.NHAN_SU);
        for (int i = 0; i < arrNhanvien.size(); i++) {
            Group group = new Group("", nhanViens);
            group.setNhanVien(arrNhanvien.get(i));
            groups.add(group);

        }
        NhanVienAdapter nhanVienAdapter = new NhanVienAdapter(groups, getContext());
        recyclerView.setAdapter(nhanVienAdapter);
        return view;
    }
}
