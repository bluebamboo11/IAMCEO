package com.example.blue.iamceo.Activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.blue.iamceo.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class NhanVienActivity extends AppCompatActivity {
    Button btnThangChuc;
    Button btnThuong;
    Button btnLuong;
    Button btnXathai;
    GraphView graphView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien);
        graphView = (GraphView) findViewById(R.id.graph_view);
        setGraphView();
        setEven();


    }

    private void setGraphView() {
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 50),
                new DataPoint(1, 80),
                new DataPoint(2, 85),
                new DataPoint(3, 75),
                new DataPoint(4, 90),
                new DataPoint(5, 60),
                new DataPoint(6, 75),
                new DataPoint(7, 95),
                new DataPoint(8, 95),
        });
        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 100),
                new DataPoint(1, 100),
                new DataPoint(2, 100),
                new DataPoint(3, 100),
                new DataPoint(4, 100),
                new DataPoint(5, 100),
                new DataPoint(6, 100),
                new DataPoint(7, 100),
                new DataPoint(8, 100),
        });
        series1.setColor(getResources().getColor(R.color.colorAccent));
        graphView.addSeries(series);
        graphView.addSeries(series1);
        graphView.setTitle("Do thi nang suat lao dong");
        graphView.getViewport().setMinX(100);
        graphView.getGridLabelRenderer().setHorizontalAxisTitleColor(getResources().getColor(R.color.colorPrimary));
        graphView.getGridLabelRenderer().setVerticalAxisTitleColor(getResources().getColor(R.color.colorPrimary));
        graphView.getGridLabelRenderer().setHorizontalAxisTitle("Day");
        graphView.getGridLabelRenderer().setPadding((int) getResources().getDimension(R.dimen.activity_horizontal_margin));
        graphView.getGridLabelRenderer().setVerticalAxisTitle("% nang suat");
    }

    private void setEven() {
        btnThangChuc = (Button) findViewById(R.id.btn_thang_chuc);
        btnThuong = (Button) findViewById(R.id.btn_thuong);
        btnLuong = (Button) findViewById(R.id.btn_tang_luong);
        btnXathai = (Button) findViewById(R.id.btn_xa_thai);
        btnThangChuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog("Thang Chuc", "Ban muon thang chuc nhan vien Tong Thanh Tung len truong Phong");
            }
        });
        btnThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog("Thuong", "Ban muon thuong nhan vien Tong Thanh Tung 50% Luong");
            }
        });
        btnLuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog("Tang Luong", "Ban muon tang luong nhan vien Tong Thanh Tung them 10%");
            }
        });
        btnXathai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog("Duoi viec", "Ban muon duoi viec nhan vien Tong Thanh Tung len truong Phong");
            }
        });
    }

    private void openDialog(String title, String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                NhanVienActivity.this);

        alertDialogBuilder.setTitle(title);

        alertDialogBuilder
                .setMessage(message)
                .setCancelable(true)
                .setPositiveButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                dialog.cancel();
                            }
                        })

                .setNegativeButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                dialog.cancel();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }
}
