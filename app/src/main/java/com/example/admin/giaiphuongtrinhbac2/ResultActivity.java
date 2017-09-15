package com.example.admin.giaiphuongtrinhbac2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView tv_ketqua;
    Button btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv_ketqua = (TextView) findViewById(R.id.tv_ketqua);

        //get lấy Intnet đã gọi
        Intent callerIntent = getIntent();

        //get lay bundle đã gửi
        Bundle packBundle = callerIntent.getBundleExtra("GuiSoLieu");

        //get lấy số liệu đã gửi qua
        int a = packBundle.getInt("SoA");
        int b = packBundle.getInt("SoB");
        int c = packBundle.getInt("SoC");

        //Xử lí Giải phuong trình bậc 2
        GiaiPTB2(a,b,c);

        //nhấn nút back trở lại màn hình chính
        //tạo sự kiện
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
              //tạo Intent quay lại màn hình chính
               Intent backMain = new Intent(ResultActivity.this, MainActivity.class);
              startActivity(backMain);
       }
     });


    }

     private void GiaiPTB2(int a, int b, int c){
         if(a==0)
         {
             if(b==0)
             {
                 if(c==0) tv_ketqua.setText("Phương trình vô số nghiệm");
                 else tv_ketqua.setText("Phuong trình vô nghiệm");
             }
             else
             {
                 if(c==0) tv_ketqua.setText("Phương trình vô số nghiệm");
                 else tv_ketqua.setText("X = "+String.valueOf(-c/b));
             }
         }
         else
         {
             float delta = b*b - 4*a*c;
             if(delta < 0) tv_ketqua.setText("Phương trình vô nghiệm");
             if(delta == 0) tv_ketqua.setText("X = "+String.valueOf(-b/(2*a)));
             if(delta > 0) tv_ketqua.setText("X1 = "+String.valueOf((-b+Math.sqrt(delta))/(2*a))
                                     +" và "+" X2 = "+String.valueOf((-b-Math.sqrt(delta))/(2*a)));
         }

     }
}
