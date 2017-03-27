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

import com.example.blue.iamceo.Activity.DuAnActivity;
import com.example.blue.iamceo.Activity.ThemDuAnActivity;
import com.example.blue.iamceo.Adapter.Group;
import com.example.blue.iamceo.Adapter.NhanVienAdapter;
import com.example.blue.iamceo.Database.Database;
import com.example.blue.iamceo.Database.DatabaseManager;
import com.example.blue.iamceo.NhanVien;
import com.example.blue.iamceo.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class KyThuatFragment extends Fragment {
    private List<NhanVien> arrNhanVien;

    public KyThuatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ky_thuat, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_kythuat);
        Button btnThem = (Button) view.findViewById(R.id.btnThemDuAn);
        Button btnDuAN = (Button) view.findViewById(R.id.btnDuAN);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ThemDuAnActivity.class);
                getContext().startActivity(intent);
            }
        });
        btnDuAN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DuAnActivity.class);
                getContext().startActivity(intent);
            }
        });

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        DatabaseManager databaseManager = new DatabaseManager(getContext());


        List<Group> groups = new ArrayList<>();
        List<NhanVien> arrNhanvien = databaseManager.getAllDataTN(NhanVien.KY_THUAT, Database.TAB_TRUONGNHOM);
        for (int i = 0; i < arrNhanvien.size(); i++) {
            List<NhanVien> nhanViens = databaseManager.getAllData(NhanVien.KY_THUAT, arrNhanvien.get(i).getId());
            Group group = new Group("", nhanViens);
            group.setNhanVien(arrNhanvien.get(i));
            groups.add(group);

        }
        NhanVienAdapter nhanVienAdapter = new NhanVienAdapter(groups, getContext());
        recyclerView.setAdapter(nhanVienAdapter);
        return view;
    }

}
