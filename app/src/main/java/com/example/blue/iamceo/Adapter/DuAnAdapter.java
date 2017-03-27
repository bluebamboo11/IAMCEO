package com.example.blue.iamceo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.blue.iamceo.DuAn;
import com.example.blue.iamceo.R;

import java.util.List;

/**
 * Created by blue on 22/03/2017.
 */

public class DuAnAdapter extends RecyclerView.Adapter<DuAnAdapter.ViewHolder>{
   private Context context;

    public DuAnAdapter(Context context, List<DuAn> duAnList) {
        this.context = context;
        this.duAnList = duAnList;
    }

    private List<DuAn>duAnList;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_du_an, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtTen.setText(duAnList.get( position).getTen());
        holder.txtCapdo.setText("LV "+duAnList.get( position).getCapdo());
        holder.txtTien.setText(duAnList.get( position).getTien()+" $");
        holder.txtHan.setText("Day "+duAnList.get( position).getHan());
        holder.progressBarTienDo.setProgress(duAnList.get( position).getTiendo());
    }

    @Override
    public int getItemCount() {
        return duAnList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTen;
        TextView txtCapdo;
        TextView txtTien;
        TextView txtHan;
        ProgressBar progressBarTienDo;
        public ViewHolder(View itemView) {
            super(itemView);
            txtTen = (TextView) itemView.findViewById(R.id.txt_ten);
            txtHan = (TextView) itemView.findViewById(R.id.txt_han);
            txtTien = (TextView) itemView.findViewById(R.id.txt_tien);
           txtCapdo = (TextView) itemView.findViewById(R.id.txt_capdo);
            progressBarTienDo=( ProgressBar) itemView.findViewById(R.id.progressbar_tiendo);
        }
    }
}
