package com.example.admin.giaiphuongtrinhbac2;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt_SoA, edt_SoB, edt_SoC;
    Button btn_giai, btn_hoithoat;
    Button btn_thoat, btn_uchiu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_SoA = (EditText) findViewById(R.id.edt_SoA);
        edt_SoB = (EditText) findViewById(R.id.edt_SoB);
        edt_SoC = (EditText) findViewById(R.id.edt_SoC);

        btn_hoithoat = (Button) findViewById(R.id.btn_hoithoat);

        btn_giai = (Button) findViewById(R.id.btn_giai);
        btn_giai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tạo Intent để mở ResultActivity
                Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);

                int a = Integer.parseInt(edt_SoA.getText().toString());
                int b =Integer.parseInt(edt_SoB.getText().toString());
                int c =Integer.parseInt(edt_SoC.getText().toString());

                //tạo Bundle để gửi dữ liệu
                Bundle bundle = new Bundle();
                bundle.putInt("SoA", a);  //key and value
                bundle.putInt("SoB", b);
                bundle.putInt("SoC", c);

                //đưa Bundle vào Intent
                myIntent.putExtra("GuiSoLieu", bundle);

                //start cái Activity thông qua Intent
                startActivity(myIntent);

                //get Intent BackMain
                Intent callBack = new Intent();
            }
        });

        btn_hoithoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog);
                dialog.setTitle("Giải Phương Trình Bậc 2");
                dialog.setCancelable(false);
                dialog.show();

                btn_thoat = (Button) dialog.findViewById(R.id.btn_thoat);
                btn_uchiu = (Button) dialog.findViewById(R.id.btn_uchiu);

                btn_thoat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"Bạn đã thoát giải phương trình bậc 2", Toast.LENGTH_SHORT);
                        finish();
                    }
                });
                btn_uchiu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


            }
        });


    }
}
