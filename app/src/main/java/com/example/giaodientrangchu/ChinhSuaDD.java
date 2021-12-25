package com.example.giaodientrangchu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.model.Postdiendan;

import java.util.Calendar;

public class ChinhSuaDD extends AppCompatActivity {

    EditText edtContent;
    TextView txtUserName, txtTimeUpdate;
    int id;
    Button btnSuaBai;
    SharedPreferences sharedPreferences;
    public static final String SHARE_PREFERENCES = "share_preferences";
    public  static final String Hoten ="Họ tên";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinh_sua_dd);
        Postdiendan p = (Postdiendan) getIntent().getExtras().getSerializable("Diễn Đàn");
        edtContent = findViewById(R.id.edtContent);
        txtUserName = findViewById(R.id.txtUserName);
        txtTimeUpdate = findViewById(R.id.txtTimeUpdate);
        btnSuaBai = findViewById(R.id.btnSuaBai);
        id = p.getId();
        edtContent.setText(p.getContent());
        sharedPreferences = getSharedPreferences(SHARE_PREFERENCES,MODE_PRIVATE);
        String hoten = sharedPreferences.getString(Hoten, null);
        if(hoten != null){
            txtUserName.setText(hoten);
        }
        btnSuaBai.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = txtUserName.getText().toString().trim();
                String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
                txtTimeUpdate.setText(mydate);
                String time = txtTimeUpdate.getText().toString().trim();
                String content = edtContent.getText().toString().trim();
                Postdiendan p = new Postdiendan(id,name,time,content);
                if(content.equals("") || name.equals("")||time.equals("")){
                    Toast.makeText(ChinhSuaDD.this,"Vui lòng nhập nội dung bài đăng",Toast.LENGTH_SHORT).show();
                }
                else{
                    DB_DienDan db_dienDan = new DB_DienDan(ChinhSuaDD.this);
                    int result = db_dienDan.updateDD(p);
                    if(result >0){
                        Toast.makeText(ChinhSuaDD.this,"Updated",Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(ChinhSuaDD.this,"Failed",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }
}