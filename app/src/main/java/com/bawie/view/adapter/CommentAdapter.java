package com.bawie.view.adapter;


import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bawie.R;
import com.bawie.model.CommentsBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.SimpleDateFormat;
import java.util.List;

public class CommentAdapter extends BaseQuickAdapter<CommentsBean.ResultBean, BaseViewHolder> {
    public CommentAdapter(int layoutResId, @Nullable List<CommentsBean.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommentsBean.ResultBean item) {
        View view = helper.getView(R.id.iv_commentHeadPic);
        String commentHeadPic = item.getCommentHeadPic();
        Glide.with(mContext).load(commentHeadPic).apply(RequestOptions.bitmapTransform(new CircleCrop())).into((ImageView) view);
        helper.setText(R.id.tv_commentUserName,item.getCommentUserName());
        helper.setText(R.id.tv_commentContent,item.getCommentContent());
        SimpleDateFormat format=new SimpleDateFormat("yyyy"+"年"+"MM"+"月"+"dd"+"日");
        String format1 = format.format(item.getCommentTime());
        helper.setText(R.id.tv_commentTime,format1+"");
    }
}
