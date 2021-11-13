package com.example.giaodientrangchu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.adapter.DiendanAdapter;
import com.example.model.Postdiendan;

import java.util.ArrayList;

public class DienDan extends AppCompatActivity {
    ImageButton imbtnBack, imbtnAdd,imbtnMore;
    ListView lvDienDan;
    ArrayList<Postdiendan> postdiendans;
    DiendanAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dien_dan);

        linkViews();
        initData();
        loadData();
        addEvents();
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
                dialog.show();
            }
        });

    }

    private void loadData() {
        adapter=new DiendanAdapter(DienDan.this,R.layout.list_view_dien_dan,postdiendans);
        lvDienDan.setAdapter(adapter);
    }

    private void initData() {
        postdiendans=new ArrayList<>();
        postdiendans.add(new Postdiendan("Trần Văn An","vài giây trước","Cho mình hỏi cách thanh toán tại bệnh viện như thế nào vậy ạ?"));
        postdiendans.add(new Postdiendan("Hoàng Thị Nga","3 giờ trước","Tôi bị đau lưng thì nên đi khám tại bệnh viện nào vậy mọi người?"));
        postdiendans.add(new Postdiendan("Nguyễn Văn Toàn","9 giờ trước","Có ai từng tiểu phẩu răng khôn tại bệnh viện Y dược chưa cho mình xin review với."));
    }

    private void linkViews() {

        lvDienDan=findViewById(R.id.lvDienDan);
        imbtnBack=findViewById(R.id.imbtnBackdiendan);
        imbtnMore=findViewById(R.id.imbtnMore);
        imbtnAdd=findViewById(R.id.imbtnAdd);
    }
}