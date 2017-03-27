package com.example.blue.iamceo.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.blue.iamceo.DuAn;
import com.example.blue.iamceo.NhanVien;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by blue on 21/03/2017.
 */

public class DatabaseManager {
    private SQLiteDatabase datasource;


    public DatabaseManager(Context context) {
        datasource = Database.initDatabase(context, Database.DATA_NAME);
    }
    // get data truong nhom
    public List<NhanVien> getAllDataTN(int nghe,String tab) {
        List<NhanVien> nhanVienList = new ArrayList<>();
        Cursor cursor = datasource.rawQuery("SELECT * FROM " + tab + " WHERE nghe = ? ", new String[]{nghe + ""});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            NhanVien nhanVien = getDataNhanVien(cursor);
            nhanVienList.add(nhanVien);
            cursor.moveToNext();
        }
        return nhanVienList;
    }
    // get data them nhan vien
    public List<NhanVien> getAllData(String tab_name) {
        List<NhanVien> nhanVienList = new ArrayList<>();
        Cursor cursor = datasource.rawQuery("SELECT * FROM " + tab_name, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            NhanVien nhanVien = getDataNhanVien(cursor);
            nhanVienList.add(nhanVien);
            cursor.moveToNext();
        }
        return nhanVienList;
    }

    // get data nhan vien theo nghe
    public List<NhanVien> getAllData(int nghe, int idTruongNhom) {
        List<NhanVien> nhanVienList = new ArrayList<>();
        Cursor cursor = datasource.rawQuery("SELECT * FROM " + Database.TAB_NHANVIEN + " WHERE nghe = ? AND idtruongnhom = ? ", new String[]{nghe + "", idTruongNhom + ""});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            NhanVien nhanVien = getDataNhanVien(cursor);
            nhanVienList.add(nhanVien);
            cursor.moveToNext();
        }
        return nhanVienList;
    }

    // Xóa một đối tượng trong bảng theo ID
    public void Delete(int id, String tab) {
        datasource.delete(tab, "ID = ?", new String[]{id + ""});

    }

    public void upDate(int id, int[] nangsuat, String tab) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nangsuat", converArrayToString(nangsuat));
        datasource.update(tab, contentValues, "id = ?", new String[]{id + ""});
    }

    private NhanVien getDataNhanVien(Cursor cursor) {
        int id = cursor.getInt(0);
        String ten = cursor.getString(1);
        int capdo = cursor.getInt(2);
        byte[] anh = cursor.getBlob(3);
        int NangLuc = cursor.getInt(4);
        int camsuc = cursor.getInt(5);
        int nghe = cursor.getInt(6);
        int luong = cursor.getInt(8);
        int[] nangsuat = converStringToArray(cursor.getString(7));
        return new NhanVien(id, ten, capdo, anh, NangLuc, luong, camsuc, nghe, nangsuat);
    }

    // lay du lieu mot san pham tu CSDL
    public NhanVien getDataIteam(int id) {
        Cursor cursor = datasource.rawQuery("SELECT * FROM " + Database.TAB_NHANVIEN + " WHERE ID = ? ", new String[]{id + ""});
        cursor.moveToFirst();
        String ten = cursor.getString(1);
        int capdo = cursor.getInt(2);
        byte[] anh = cursor.getBlob(3);
        int NangLuc = cursor.getInt(4);
        int camsuc = cursor.getInt(5);
        int nghe = cursor.getInt(6);
        int luong = cursor.getInt(8);
        return new NhanVien(id, ten, capdo, anh, NangLuc, luong, camsuc, nghe);
    }

    // Thêm một đối tượng vào bảng
    public void insert(String tab_name, NhanVien nhanVien) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ten", nhanVien.getTen());
        contentValues.put("capdo", nhanVien.getCapDo());
        contentValues.put("anh", nhanVien.getAnh());
        contentValues.put("nangluc", nhanVien.getNangLuc());
        contentValues.put("camxuc", nhanVien.getCamXUc());
        contentValues.put("nghe", nhanVien.getNghe());
        contentValues.put("luong", nhanVien.getLuong());
//        contentValues.put("nangsuat",converArrayToString(nhanVien.getNangSuat()));
        datasource.insert(tab_name, null, contentValues);
    }

    private String converArrayToString(int[] arrNangXuat) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : arrNangXuat) {
            stringBuilder.append(i);
            stringBuilder.append(",");
        }

        return stringBuilder.toString();
    }

    private int[] converStringToArray(String nangSuat) {
        int[] intNangSuat = new int[8];
        try {

            String[] arrNangSuat = nangSuat.split(",");
            Log.e("null", nangSuat);
            int i = 0;
            for (String a : arrNangSuat) {
                intNangSuat[i] = Integer.parseInt(a);
                i++;
            }


        } catch (NullPointerException e) {

        }
        return intNangSuat;
    }

    public List<DuAn> getAllDataDuAn(String tab) {
        List<DuAn> duAnList = new ArrayList<>();

        Cursor cursor = datasource.rawQuery("SELECT * FROM " + tab + "", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            DuAn duAn = getDataDuAn(cursor);
            duAnList.add(duAn);
            cursor.moveToNext();
        }
        return duAnList;
    }

    public void insert(DuAn duAn, String tab) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ten", duAn.getTen());
        contentValues.put("capdo", duAn.getCapdo());
        contentValues.put("congviec", duAn.getCongviec());
        contentValues.put("tien", duAn.getTien());
        contentValues.put("tiendo", duAn.getTiendo());
        contentValues.put("han", duAn.getHan());
        datasource.insert(tab, null, contentValues);
    }

    private DuAn getDataDuAn(Cursor cursor) {
        int id = cursor.getInt(0);
        String ten = cursor.getString(1);
        int capdo = cursor.getInt(2);
        Long tien = cursor.getLong(3);
        int tiendo = cursor.getInt(4);
        int han = cursor.getInt(5);
        int congviec = cursor.getInt(6);
        return new DuAn(id, ten, capdo, tien, han, tiendo, congviec);
    }

    public void saveThemNhanVien(List<NhanVien> nhanVienList) {

        datasource.execSQL("DELETE FROM " + Database.TAB_THEMNHANVIEN + ";");
        for (NhanVien nhanVien : nhanVienList) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("ten", nhanVien.getTen());
            contentValues.put("capdo", nhanVien.getCapDo());
            contentValues.put("anh", nhanVien.getAnh());
            contentValues.put("nangluc", nhanVien.getNangLuc());
            contentValues.put("nghe", nhanVien.getNghe());
            contentValues.put("camxuc", nhanVien.getCamXUc());
            contentValues.put("luong", nhanVien.getLuong());
            datasource.insert(Database.TAB_THEMNHANVIEN, null, contentValues);
        }

    }

    public void saveThemDuAn(List<DuAn> duAnList) {
        datasource.execSQL("DELETE FROM " + Database.TAB_THEMDUAN + ";");

        for (DuAn duAn : duAnList) {
            insert(duAn, Database.TAB_THEMDUAN);
        }
    }

}
