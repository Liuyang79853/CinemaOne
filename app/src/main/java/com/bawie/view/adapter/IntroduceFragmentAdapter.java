package com.bawie.view.adapter;



import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bawie.R;
import com.bawie.model.DetailsBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

//导演
public class IntroduceFragmentAdapter extends BaseQuickAdapter<DetailsBean.ResultBean.MovieDirectorBean, BaseViewHolder> {

    public IntroduceFragmentAdapter(int layoutResId, @Nullable List<DetailsBean.ResultBean.MovieDirectorBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DetailsBean.ResultBean.MovieDirectorBean item) {
        View view = helper.getView(R.id.iv_introduce_photo);
        String photo = item.photo;
        Glide.with(mContext).load(photo).into((ImageView) view);
        helper.setText(R.id.tv_introduce_name,item.name);
    }
}
