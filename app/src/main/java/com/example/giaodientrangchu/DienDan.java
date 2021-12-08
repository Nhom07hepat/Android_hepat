package com.example.giaodientrangchu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.DiendanAdapter;
import com.example.adapter.LichKhamAdapter;
import com.example.model.Postdiendan;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DienDan extends AppCompatActivity {
    ImageButton imbtnBack, imbtnAdd,imbtnMore;
    ArrayList<Postdiendan> postdiendans;

    RecyclerView recDienDan;
    DiendanAdapter adapter;

    SharedPreferences sharedPreferences;
    public static final String SHARE_PREFERENCES = "share_preferences";
    public  static final String Hoten ="Họ tên";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dien_dan);

        linkViews();
//        initData();
//        loadData();
        addEvents();

    }

    private void addDienDan() {
        androidx.appcompat.app.AlertDialog.Builder builder = new AlertDialog.Builder(DienDan.this);
        builder.setTitle("Xác nhận !!!");
        builder.setMessage("Bạn chắc chắn muốn đăng bài lên diên đàn này?");
        builder.setCancelable(false);
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                DB_DienDan db_dienDan = new DB_DienDan(DienDan.this);
                postdiendans = db_dienDan.getAllDienDan();
                adapter = new DiendanAdapter(postdiendans,DienDan.this);
                recDienDan.setAdapter(adapter);
                LinearLayoutManager manager = new LinearLayoutManager(DienDan.this);
                manager.setOrientation(RecyclerView.VERTICAL);
                recDienDan.setLayoutManager(manager);
            }
        });
        builder.setNegativeButton("No", null);
        builder.show();
    }

    private void addEvents() {

        imbtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DienDan.this,MainActivity.class);
                startActivity(intent);
            }
        });

        imbtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog=new Dialog(DienDan.this);
                dialog.setContentView(R.layout.nut_them_cua_dien_dan);
                TextView txtName = dialog.findViewById(R.id.txtUserName);
                sharedPreferences = getSharedPreferences(SHARE_PREFERENCES,MODE_PRIVATE);
                String hoten = sharedPreferences.getString(Hoten, null);
                if(hoten != null){
                    txtName.setText(hoten);
                }
                Button btnDangBai = dialog.findViewById(R.id.btnDangBai);
                EditText edtContent = dialog.findViewById(R.id.edtContent);
                dialog.show();

                btnDangBai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = txtName.getText().toString().trim();
                        String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
                        String time = mydate.trim();
                        String content = edtContent.getText().toString().trim();
                        DB_DienDan db_dienDan = new DB_DienDan(DienDan.this);
                        Postdiendan p = new Postdiendan(name, time, content);
                        long result = db_dienDan.addDienDan(p);
                        if (result > 0){
                            Toast.makeText(DienDan.this,"Success", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(DienDan.this,"Fail", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                        addDienDan();
                    }
                });


            }
        });

    }



//    private void loadData() {
//        adapter=new DiendanAdapter(DienDan.this,R.layout.list_view_dien_dan,postdiendans);
//        lvDienDan.setAdapter(adapter);
//    }
//
//    private void initData() {
//        postdiendans=new ArrayList<>();
//        postdiendans.add(new Postdiendan("Hoàng Thị Nga","3 giờ trước","Tôi bị đau lưng thì nên đi khám tại bệnh viện nào vậy mọi người?"));
//        postdiendans.add(new Postdiendan("Nguyễn Văn Toàn","9 giờ trước","Có ai từng tiểu phẩu răng khôn tại bệnh viện Y dược chưa cho mình xin review với."));
//    }

    private void linkViews() {

        recDienDan=findViewById(R.id.recDienDan);
        imbtnBack=findViewById(R.id.imbtnBackdiendan);
        imbtnMore=findViewById(R.id.imbtnMore);
        imbtnAdd=findViewById(R.id.imbtnAdd);
    }
}