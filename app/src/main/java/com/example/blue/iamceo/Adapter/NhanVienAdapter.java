package com.example.blue.iamceo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.blue.iamceo.Activity.NhanVienActivity;
import com.example.blue.iamceo.NhanVien;
import com.example.blue.iamceo.R;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import java.util.List;
import java.util.Random;

/**
 * Created by blue on 17/03/2017.
 */

public class NhanVienAdapter extends ExpandableRecyclerViewAdapter<NhanVienAdapter.GenreViewHolder, NhanVienAdapter.ArtistViewHolder> {

    public NhanVienAdapter(List<? extends ExpandableGroup> groups, Context context) {
        super(groups);
        this.context = context;
    }

    private int i = 0;
    private Context context;

    @Override
    public GenreViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_nhan_vien, parent, false);

        Log.e("posti", (i++) + "");
        return new GenreViewHolder(itemView);
    }

    @Override
    public ArtistViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_nhan_vien, parent, false);
        CardView cardView = (CardView) itemView.findViewById(R.id.item);
        cardView.setBackgroundColor(context.getResources().getColor(R.color.colorItem));
        return new ArtistViewHolder(itemView);
    }


    @Override
    public void onBindChildViewHolder(ArtistViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        Random random = new Random();
        int nangsuat = random.nextInt(100);
        Group group1 = (Group) group;
        List nhanVienList =  group1.getItems();
        NhanVien nhanVien= (NhanVien) nhanVienList.get(childIndex);
        try {
            holder.txtTen.setText(nhanVien.getTen());
            holder.txtcapdo.setText("LV " + nhanVien.getCapDo());
            holder.txtNangXuat.setText(nhanVien.getNangSuat()[0] + " %");

            switch (nhanVien.getCamXUc()) {
                case 0:
                    holder.imgCamXuc.setImageResource(R.drawable.ic_sentiment_very_satisfied_black_24dp);
                    break;
                case 1:
                    holder.imgCamXuc.setImageResource(R.drawable.ic_sentiment_satisfied_black_24dp);
                    break;
                case 2:
                    holder.imgCamXuc.setImageResource(R.drawable.ic_sentiment_neutral_black_24dp);
                    break;
                case 3:
                    holder.imgCamXuc.setImageResource(R.drawable.ic_sentiment_dissatisfied_black_24dp);
                    break;
                default:
                    break;
            }
        } catch (NullPointerException e) {

        }
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NhanVienActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public void onBindGroupViewHolder(GenreViewHolder holder, int flatPosition, ExpandableGroup group) {
        Random random = new Random();
        int nangsuat = random.nextInt(100);
        Group group1 = (Group) group;
        NhanVien nhanVien = group1.getNhanVien();
        try {
            holder.txtTen.setText(nhanVien.getTen());
            holder.txtcapdo.setText("LV " + nhanVien.getCapDo());
            holder.txtNangXuat.setText(nhanVien.getNangSuat()[0] + " %");
            switch (nhanVien.getCamXUc()) {
                case 0:
                    holder.imgCamXuc.setImageResource(R.drawable.ic_sentiment_very_satisfied_black_24dp);
                    break;
                case 1:
                    holder.imgCamXuc.setImageResource(R.drawable.ic_sentiment_satisfied_black_24dp);
                    break;
                case 2:
                    holder.imgCamXuc.setImageResource(R.drawable.ic_sentiment_neutral_black_24dp);
                    break;
                case 3:
                    holder.imgCamXuc.setImageResource(R.drawable.ic_sentiment_dissatisfied_black_24dp);
                    break;
                default:
                    break;
            }
        } catch (NullPointerException e) {

        }
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NhanVienActivity.class);
                context.startActivity(intent);
            }
        });
    }

    public class GenreViewHolder extends GroupViewHolder {
        ImageView imageView;
        TextView txtTen;
        TextView txtcapdo;
        TextView txtNangXuat;
        ImageView imgCamXuc;

        public GenreViewHolder(View itemView) {

            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.next_nhan_vien);
            txtTen = (TextView) itemView.findViewById(R.id.txt_ten);
            txtcapdo = (TextView) itemView.findViewById(R.id.txt_capdo);
            txtNangXuat = (TextView) itemView.findViewById(R.id.txt_nangxuat);
            imgCamXuc = (ImageView) itemView.findViewById(R.id.img_cam_xuc);
        }

    }

    public class ArtistViewHolder extends ChildViewHolder {
        ImageView imageView;
        TextView txtTen;
        TextView txtcapdo;
        TextView txtNangXuat;
        ImageView imgCamXuc;

        public ArtistViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.next_nhan_vien);

            txtTen = (TextView) itemView.findViewById(R.id.txt_ten);
            txtcapdo = (TextView) itemView.findViewById(R.id.txt_capdo);
            txtNangXuat = (TextView) itemView.findViewById(R.id.txt_nangxuat);
            imgCamXuc = (ImageView) itemView.findViewById(R.id.img_cam_xuc);
        }
    }
}
