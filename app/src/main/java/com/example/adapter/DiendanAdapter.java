package com.example.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giaodientrangchu.Activity_Binhluan;
import com.example.giaodientrangchu.ChinhSuaDD;
import com.example.giaodientrangchu.DBBooking;
import com.example.giaodientrangchu.DB_DienDan;
import com.example.giaodientrangchu.DB_HUY;
import com.example.giaodientrangchu.DB_LichHT;
import com.example.giaodientrangchu.DatLich2_Activity;
import com.example.giaodientrangchu.DienDan;
import com.example.giaodientrangchu.LichKham;
import com.example.giaodientrangchu.MainActivity;
import com.example.giaodientrangchu.R;
import com.example.model.LichKhamht;
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
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Dialog dialog;
                dialog = new Dialog(context);
                dialog.setContentView(R.layout.custom_layout);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);
                Button btnXoa = dialog.findViewById(R.id.btnXoaDD);
                Button btnSua = dialog.findViewById(R.id.btnSua);
                dialog.show();
                btnXoa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DB_DienDan db_dienDan = new DB_DienDan(context);
                        int result = db_dienDan.deleteDD(p.getId());
                        if (result > 0) {
                            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                            postdiendans.remove(p);
                            notifyDataSetChanged();

                        } else {
                            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }

                });
                btnSua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, ChinhSuaDD.class);
                        intent.putExtra("Diễn Đàn",p);
                        context.startActivity(intent);
                        dialog.dismiss();
                    }
                });


                return false;
            }
        });
                holder.btnCommentDienDan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, Activity_Binhluan.class);
                context.startActivity(intent);
            }
        });
        holder.imbMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dau_ba_cham_dien_dan);
                dialog.show();
                Button btnLuubaiviet = dialog.findViewById(R.id.btnLuubaiviet);
                Button btnAnbaiviet = dialog.findViewById(R.id.btnAnbaiviet);
                Button btnSaochep = dialog.findViewById(R.id.btnSaochep);
                Button btnBaiVietYeuThich = dialog.findViewById(R.id.btnBaiVietYeuThich);

                btnLuubaiviet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"Lưu bài viết thành công",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                btnBaiVietYeuThich.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"Đã thêm vào bài viết yêu thích",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                btnSaochep.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"Đã sao chép bài viết này",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                btnAnbaiviet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();


                    }
                });
            }
        });
    }


    @Override
    public int getItemCount() {
        return postdiendans.size();
    }

    class DienDanVH extends RecyclerView.ViewHolder {
        TextView txtName, txtTime, txtContent;
        Button btnCommentDienDan;
        CardView cardView;
        ImageButton imbMore;


        public DienDanVH(@NonNull View view) {
            super(view);
            txtName = (TextView) view.findViewById(R.id.txtName_User);
            txtTime = (TextView) view.findViewById(R.id.txtThoiGian);
            txtContent = (TextView) view.findViewById(R.id.txtContent);
            btnCommentDienDan = (Button) view.findViewById(R.id.btnCommentDienDan);
            cardView = view.findViewById(R.id.mCardview);
            imbMore = view.findViewById(R.id.imbtnMore);

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
