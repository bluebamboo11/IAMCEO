package com.example.blue.iamceo.Activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.blue.iamceo.Adapter.ThemDuAnAdapter;
import com.example.blue.iamceo.Database.Database;
import com.example.blue.iamceo.Database.DatabaseManager;
import com.example.blue.iamceo.DuAn;
import com.example.blue.iamceo.R;

import java.util.List;

public class ThemDuAnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_du_an);
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.list_du_an);
        ThemDuAnAdapter themDuAnAdapter=new ThemDuAnAdapter(taoDuAn(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(themDuAnAdapter);
        DividerItemDecoration dividerItemDecoration =new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider));
        recyclerView.addItemDecoration(dividerItemDecoration);

    }
    public List<DuAn> taoDuAn(){
        DatabaseManager databaseManager=new DatabaseManager(this);
        return databaseManager.getAllDataDuAn(Database.TAB_THEMDUAN);
    }
}
