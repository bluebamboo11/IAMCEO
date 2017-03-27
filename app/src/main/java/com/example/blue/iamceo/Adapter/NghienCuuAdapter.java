package com.example.blue.iamceo.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by blue on 19/03/2017.
 */

public class NghienCuuAdapter extends ArrayAdapter {
    Context context;
    int id;
    public NghienCuuAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context=context;
        id=resource;
    }

    public NghienCuuAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context=context;
        id=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(id, parent, false);

        return itemView;
    }

    @Override
    public int getCount() {
        return 5;
    }
}