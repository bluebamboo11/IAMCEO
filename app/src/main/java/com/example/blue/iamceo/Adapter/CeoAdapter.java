package com.example.blue.iamceo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.blue.iamceo.R;
import com.example.blue.iamceo.SaveLoadPreferences;

/**
 * Created by blue on 17/03/2017.
 */

public class CeoAdapter extends RecyclerView.Adapter<CeoAdapter.ViewHolder> {
    Context context;

    public CeoAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_ceo, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SaveLoadPreferences saveLoadPreferences=new SaveLoadPreferences(context);
        holder.txtTongNguoi.setText("Nhan su "+saveLoadPreferences.loadInteger(SaveLoadPreferences.TONG_NGUOI,8));
        holder.txtTongTien.setText("Von "+saveLoadPreferences.loadInteger(SaveLoadPreferences.TONG_TIEN,100000));
        holder.txtTongNgay.setText("Day "+saveLoadPreferences.loadInteger(SaveLoadPreferences.TONG_NGAY,1));
        holder.txtTongLV.setText("Lv "+saveLoadPreferences.loadInteger(SaveLoadPreferences.TONG_LV,1));
        holder.txtTongNextLV.setText("Next lv "+saveLoadPreferences.loadInteger(SaveLoadPreferences.TONG_LV,1)*100000);
        holder.txtKyThuatNguoi.setText("Nhan su "+saveLoadPreferences.loadInteger(SaveLoadPreferences.KY_THUAT_NGUOI,6));
        holder.txtKyThuatLV.setText("Lv "+saveLoadPreferences.loadInteger(SaveLoadPreferences.KY_THUAT_LV,1));
        holder.txtKyThuatNextLV.setText("Next lv "+saveLoadPreferences.loadInteger(SaveLoadPreferences.TONG_LV,1)*10000);
        holder.txtNhanSuNguoi.setText("Nhan su "+saveLoadPreferences.loadInteger(SaveLoadPreferences.NHAN_SU_NGUOI,2));
        holder.txtNhanSuLV.setText("Lv "+saveLoadPreferences.loadInteger(SaveLoadPreferences.NHAN_SU_LV,1));
        holder.txtNhanSuNextLv.setText("Next lv "+saveLoadPreferences.loadInteger(SaveLoadPreferences.TONG_LV,1)*1000);
        holder.txtNghienCuuNguoi.setText("Nhan su "+saveLoadPreferences.loadInteger(SaveLoadPreferences.NGHIEN_CUU_NGUOI,1));
        holder.txtNghienCuuLV.setText("Lv "+saveLoadPreferences.loadInteger(SaveLoadPreferences.NGHIEN_CUU_LV,1));
        holder.txtNghienCuuNextLV.setText("Next lv "+saveLoadPreferences.loadInteger(SaveLoadPreferences.TONG_LV,1)*1000);
        holder.txtTenCongTY.setText("Cong ty "+saveLoadPreferences.loadString(SaveLoadPreferences.TEN_CONG_TY,"Apple"));
    }


    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTongNguoi;
        TextView txtTongTien;
        TextView txtTongNgay;
        TextView txtTongLV;
        TextView txtTongNextLV;
        TextView txtKyThuatNguoi;
        TextView txtKyThuatLV;
        TextView txtKyThuatNextLV;
        TextView txtNhanSuNguoi;
        TextView txtNhanSuLV;
        TextView txtNhanSuNextLv;
        TextView txtNghienCuuNguoi;
        TextView txtNghienCuuLV;
        TextView txtNghienCuuNextLV;
        TextView txtTenCongTY;
        Button btnUpTong;
        Button btnUpKYThuat;
        Button btnUpNhanSu;
        Button btnUpNghienCuu;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTongTien = (TextView) itemView.findViewById(R.id.txt_tongtien);
            txtTongNguoi = (TextView) itemView.findViewById(R.id.txt_tongNhanSu);
            txtTongLV = (TextView) itemView.findViewById(R.id.txt_Tonglv);
            txtTongNextLV = (TextView) itemView.findViewById(R.id.txt_nextLvTong);
            txtKyThuatNguoi = (TextView) itemView.findViewById(R.id.txt_nhansuKT);
            txtKyThuatLV = (TextView) itemView.findViewById(R.id.txt_lvKyThuat);
            txtTongNgay = (TextView) itemView.findViewById(R.id.txt_tongNgay);
            txtKyThuatNextLV = (TextView) itemView.findViewById(R.id.txt_nextlvKT);
            txtNhanSuNguoi = (TextView) itemView.findViewById(R.id.txt_nhansuNS);
            txtNhanSuLV = (TextView) itemView.findViewById(R.id.txt_lvNHansu);
            txtNhanSuNextLv = (TextView) itemView.findViewById(R.id.txt_nextLVNS);
            txtNghienCuuNguoi = (TextView) itemView.findViewById(R.id.txt_nhansuST);
            txtNghienCuuLV = (TextView) itemView.findViewById(R.id.txt_lvSangTao);
            txtNghienCuuNextLV = (TextView) itemView.findViewById(R.id.txt_nextLvST);
            txtTenCongTY = (TextView) itemView.findViewById(R.id.txt_tencongty);
            btnUpTong = (Button) itemView.findViewById(R.id.btn_nextLvTong);
            btnUpKYThuat = (Button) itemView.findViewById(R.id.btn_nextLvKT);
            btnUpNhanSu = (Button) itemView.findViewById(R.id.btn_nextLvNS);
            btnUpNghienCuu = (Button) itemView.findViewById(R.id.btn_nextLvSt);
        }
    }
}