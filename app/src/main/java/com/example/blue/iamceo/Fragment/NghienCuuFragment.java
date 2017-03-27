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

import com.example.blue.iamceo.Activity.NghienCuuActivity;
import com.example.blue.iamceo.Adapter.Group;
import com.example.blue.iamceo.Adapter.NhanVienAdapter;
import com.example.blue.iamceo.NhanVien;
import com.example.blue.iamceo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NghienCuuFragment extends Fragment {


    public NghienCuuFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_nghien_cuu, container, false);
        RecyclerView recyclerView=(RecyclerView) view.findViewById(R.id.recycler_kythuat);
        Button buttonNghienCuu=(Button) view.findViewById(R.id.btn_nghien_cuu);
        buttonNghienCuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), NghienCuuActivity.class);
                startActivity(intent);
            }
        });
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        List<NhanVien> nhanViens = new ArrayList<>();
        List<Group> groups = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            nhanViens.add(new NhanVien());
        }
        for (int i = 0; i < 5; i++) {
            groups.add(new Group("",nhanViens));
        }

        NhanVienAdapter nhanVienAdapter = new NhanVienAdapter(groups, getContext());
        recyclerView.setAdapter(nhanVienAdapter);
        return view;
    }

}
