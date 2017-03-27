package com.example.blue.iamceo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.blue.iamceo.Adapter.NghienCuuAdapter;
import com.example.blue.iamceo.R;

public class NghienCuuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngien_cuu);
        ListView listView=(ListView) findViewById(R.id.list_nghien_cuu);
        NghienCuuAdapter nghienCuuAdapter=new NghienCuuAdapter(this, R.layout.item_nghien_cuu);
        listView.setAdapter(nghienCuuAdapter);
    }
}
