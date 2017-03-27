package com.example.blue.iamceo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.blue.iamceo.Database.Database;
import com.example.blue.iamceo.Database.DatabaseManager;
import com.example.blue.iamceo.DuAn;
import com.example.blue.iamceo.R;

import java.util.List;

/**
 * Created by blue on 22/03/2017.
 */

public class ThemDuAnAdapter extends RecyclerView.Adapter<ThemDuAnAdapter.ViewHolder> {
    private List<DuAn> duAnList;
    private Context context;

    public ThemDuAnAdapter(List<DuAn> duAnList, Context context) {
        this.duAnList = duAnList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

         View itemView = inflater.inflate(R.layout.item_them_da, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtTen.setText(duAnList.get( position).getTen());
        holder.txtCapdo.setText("LV "+duAnList.get( position).getCapdo());
        holder.txtTien.setText(duAnList.get( position).getTien()+" $");
        holder.txtHan.setText("Day "+duAnList.get( position).getHan());
    }

    @Override
    public int getItemCount() {
        return duAnList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTen;
        TextView txtCapdo;
        TextView txtTien;
        TextView txtHan;
        ImageView imgAdd;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTen = (TextView) itemView.findViewById(R.id.txt_ten);
            txtHan = (TextView) itemView.findViewById(R.id.txt_han);
            txtTien = (TextView) itemView.findViewById(R.id.txt_tien);
            imgAdd = (ImageView) itemView.findViewById(R.id.img_add);
            txtCapdo = (TextView) itemView.findViewById(R.id.txt_capdo);
            imgAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatabaseManager databaseManager=new DatabaseManager(context);
                    databaseManager.insert( duAnList.get(getAdapterPosition()), Database.TAB_DUAN);
                    databaseManager.Delete(duAnList.get(getAdapterPosition()).getId(),Database.TAB_THEMDUAN);
                    duAnList.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());

                }
            });
        }
    }
}
