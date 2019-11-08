package com.bawie.view.adapter;

import android.content.Context;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bawie.R;
import com.bawie.model.HotmovieBean;
import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MoreHotmoviesAdpter extends RecyclerView.Adapter {
    private List<HotmovieBean.ResultBean> result;
    private Context context;

    public MoreHotmoviesAdpter(List<HotmovieBean.ResultBean> result, Context context) {
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
        viewHolder1.text.setText(result.get(i).name);
        String horizontalImage = result.get(i).horizontalImage;
       Glide.with(context).load(horizontalImage).into(viewHolder1.bigimg);
        String imageUrl = result.get(i).imageUrl;
        Glide.with(context).load(imageUrl).into(viewHolder1.image);
        viewHolder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int movieId = result.get(i).movieId;
                //Intent intent = new Intent(context, DetailsActivity.class);
                //intent.putExtra("movieId",movieId);
                //context.startActivity(intent);
            }
        });
    }




    @Override
    public int getItemCount() {
        return result.size();
    }
    private class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView bigimg;
        private final TextView text;
        private final ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           bigimg = itemView.findViewById(R.id.bigimage);
            text = itemView.findViewById(R.id.tv1);
            image = itemView.findViewById(R.id.img);
        }
    }
}
