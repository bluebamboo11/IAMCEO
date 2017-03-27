package com.example.blue.iamceo.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.blue.iamceo.Database.Database;
import com.example.blue.iamceo.Database.DatabaseManager;
import com.example.blue.iamceo.NhanVien;
import com.example.blue.iamceo.R;

import java.util.List;

/**
 * Created by blue on 19/03/2017.
 */

public class ThemNhanVienAdapter extends ArrayAdapter {
    private Context context;
    private int id;
    private List<NhanVien> arrNhanVien;

    public ThemNhanVienAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<NhanVien> arrNhanVien) {
        super(context, resource, arrNhanVien);
        this.context = context;
        id = resource;
        this.arrNhanVien = arrNhanVien;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder = new ViewHolder();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(id, parent, false);
        viewHolder.imgAdd = (ImageView) itemView.findViewById(R.id.img_add);
        viewHolder.imgAnh = (ImageView) itemView.findViewById(R.id.imgnhanvien);
        viewHolder.txtLuong = (TextView) itemView.findViewById(R.id.txt_luong);
        viewHolder.txtTen = (TextView) itemView.findViewById(R.id.text_ten);
        viewHolder.txtnghe = (TextView) itemView.findViewById(R.id.txt_nghe);
        viewHolder.txtLV = (TextView) itemView.findViewById(R.id.text_lv);

        viewHolder.txtTen.setText(arrNhanVien.get(position).getTen());
        viewHolder.txtLV.setText(arrNhanVien.get(position).getCapDo() + "");
        viewHolder.txtLuong.setText(arrNhanVien.get(position).getLuong() + "");
        viewHolder.txtnghe.setText(arrNhanVien.get(position).getStringNghe());
        Bitmap bitmap= BitmapFactory.decodeByteArray(arrNhanVien.get(position).getAnh(),0,arrNhanVien.get(position).getAnh().length);
        viewHolder.imgAnh.setImageBitmap(bitmap);
        viewHolder.imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseManager databaseManager=new DatabaseManager(context);
                databaseManager.insert(Database.TAB_TRUONGNHOM,arrNhanVien.get(position));
                databaseManager.Delete(arrNhanVien.get(position).getId(),Database.TAB_THEMNHANVIEN);
                arrNhanVien.remove(position);
                notifyDataSetChanged();
                Toast.makeText(context, "Da them nhan vien", Toast.LENGTH_LONG).show();
            }
        });
        return itemView;
    }

    @Override
    public int getCount() {
        return arrNhanVien.size();
    }

    private class ViewHolder {
        ImageView imgAdd;
        TextView txtTen;
        TextView txtLV;
        TextView txtLuong;
        TextView txtnghe;
        ImageView imgAnh;
    }
}

