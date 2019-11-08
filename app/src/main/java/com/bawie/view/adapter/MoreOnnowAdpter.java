package com.bawie.view.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawie.R;
import com.bawie.model.OnnowBean;
import com.bawie.view.activity.DetailsActivity;
import com.bumptech.glide.Glide;

import java.util.List;

public class MoreOnnowAdpter extends RecyclerView.Adapter {
    private List<OnnowBean.ResultBean> result;
    private Context context;


    public MoreOnnowAdpter(List<OnnowBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.upcomingitem,null);
        ViewHolder viewHoler=new ViewHolder(view);
        return viewHoler;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder viewHolder1 = (ViewHolder) viewHolder;
        viewHolder1.tv.setText(result.get(i).name);
        String imageUrl = result.get(i).imageUrl;
        Glide.with(context).load(imageUrl).into(viewHolder1.img);
        viewHolder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int movieId = result.get(i).movieId;
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("movieId",movieId);
                context.startActivity(intent);
            }
        });
    }




    @Override
    public int getItemCount() {
        return result.size();
    }
    private class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView img;
        private final TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
