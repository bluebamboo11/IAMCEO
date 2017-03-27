package com.example.blue.iamceo.Activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.blue.iamceo.Adapter.DuAnAdapter;
import com.example.blue.iamceo.Database.Database;
import com.example.blue.iamceo.Database.DatabaseManager;
import com.example.blue.iamceo.R;

public class DuAnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_du_an);
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.list_du_an);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DatabaseManager databaseManager=new DatabaseManager(this);
         DuAnAdapter duAnAdapter=new DuAnAdapter(this, databaseManager.getAllDataDuAn(Database.TAB_DUAN) );
        recyclerView.setAdapter(duAnAdapter);
        recyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration =new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider));
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}
