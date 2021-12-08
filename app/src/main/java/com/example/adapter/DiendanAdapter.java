package com.example.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giaodientrangchu.Activity_Binhluan;
import com.example.giaodientrangchu.DienDan;
import com.example.giaodientrangchu.LichKham;
import com.example.giaodientrangchu.MainActivity;
import com.example.giaodientrangchu.R;
import com.example.model.Postdiendan;

import java.util.ArrayList;
import java.util.List;

public class DiendanAdapter extends RecyclerView.Adapter<DiendanAdapter.DienDanVH>{
    ArrayList<Postdiendan> postdiendans = null;
    Context context;

    public DiendanAdapter(ArrayList<Postdiendan> postdiendans, Context context) {
        this.postdiendans = postdiendans;
        this.context = context;
    }

    @NonNull
    @Override
    public DienDanVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_view_dien_dan, parent, false);
        DienDanVH vh = new DienDanVH(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull DienDanVH holder, int position) {
        Postdiendan p = postdiendans.get(position);
        holder.txtName.setText(p.getName());
        holder.txtTime.setText(p.getTime());
        holder.txtContent.setText(p.getContent());

    }

    @Override
    public int getItemCount() {
        return postdiendans.size();
    }

    class DienDanVH extends RecyclerView.ViewHolder{
        TextView txtName, txtTime, txtContent;
        Button btnCommentDienDan;

        public DienDanVH(@NonNull View view) {
            super(view);
            txtName = (TextView) view.findViewById(R.id.txtName_User);
            txtTime = (TextView) view.findViewById(R.id.txtThoiGian);
            txtContent = (TextView) view.findViewById(R.id.txtContent);
            btnCommentDienDan = (Button) view.findViewById(R.id.btnCommentDienDan);
        }
    }
//    Activity context;
//    int item_listview;
//    List<Postdiendan> postdiendanList;
//
//
//
//    public DiendanAdapter(Activity context, int item_listview, List<Postdiendan> postdiendanList) {
//        this.context = context;
//        this.item_listview = item_listview;
//        this.postdiendanList = postdiendanList;
//    }
//
//
//    @Override
//    public int getCount() {
//        return postdiendanList.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return postdiendanList.get(i);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        ViewHolder holder=null;
//        if(view==null){
//            holder= new ViewHolder();
//            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view=inflater.inflate(item_listview,null);
//            holder.txtUserName=view.findViewById(R.id.txtName_User);
//            holder.txtUserTime=view.findViewById(R.id.txtThoiGian);
//            holder.txtUserQuestion=view.findViewById(R.id.txtQuestion);
//            holder.imbtnMore=view.findViewById(R.id.imbtnMore);
//            holder.btnComment=view.findViewById(R.id.btnCommentDienDan);
//            view.setTag(holder);
//
//        } else {
//            holder= (ViewHolder) view.getTag();
//
//        }
//        Postdiendan postdiendan=postdiendanList.get(i);
//        holder.txtUserName.setText(postdiendan.getUserName());
//        holder.txtUserTime.setText(postdiendan.getUserTime());
//        holder.btnComment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(context, Activity_Binhluan.class);
//                context.startActivity(intent);
//            }
//        });
//        holder.txtUserQuestion.setText(postdiendan.getUserContent());
//        holder.imbtnMore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final Dialog dialog=new Dialog(context);
//                dialog.setContentView(R.layout.dau_ba_cham_dien_dan);
//                dialog.show();
//            }
//        });
//
//        return view;
//    }
//
//    public  static  class  ViewHolder{
//        TextView txtUserName, txtUserTime, txtUserQuestion;
//        Button btnComment;
//        ImageButton imbtnMore;
//    }
}
