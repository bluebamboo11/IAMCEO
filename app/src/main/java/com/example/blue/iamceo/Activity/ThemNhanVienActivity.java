package com.example.blue.iamceo.Activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.blue.iamceo.Adapter.ThemNhanVienAdapter;
import com.example.blue.iamceo.Database.DatabaseManager;
import com.example.blue.iamceo.NhanVien;
import com.example.blue.iamceo.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThemNhanVienActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nhan_vien);
        ListView listView = (ListView) findViewById(R.id.list_them_nhan_vien);
        DatabaseManager databaseManager=new DatabaseManager(this);
        ThemNhanVienAdapter themNhanVienAdapter = new ThemNhanVienAdapter(this, R.layout.item_them_nhan_vien, databaseManager.getAllData("ThemNhanVien"));
        listView.setAdapter(themNhanVienAdapter);
    }

    private List<NhanVien> setNhanVien() {
        List<NhanVien> arrNhanvien = new ArrayList<>();
        Random random = new Random();
        int sl = random.nextInt(10);
        for (int i = 0; i < sl; i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.avatar);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] bitMapData = stream.toByteArray();
            NhanVien nhanVien = new NhanVien("Tong Thanh Tung", random.nextInt(5) + 1, bitMapData, 5, 1000, NhanVien.VUi_VE, random.nextInt(2)+1);
            arrNhanvien.add(nhanVien);
        }
        return arrNhanvien;
    }
}
