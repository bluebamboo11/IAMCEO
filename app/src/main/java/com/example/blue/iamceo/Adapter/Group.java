package com.example.blue.iamceo.Adapter;

import android.os.Parcel;

import com.example.blue.iamceo.NhanVien;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by blue on 17/03/2017.
 */

public class Group extends ExpandableGroup {
 NhanVien nhanVien;

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public Group(String title, List <NhanVien>items ) {
        super(title, items);

    }

    public Group(Parcel in) {
        super(in);
    }


}
