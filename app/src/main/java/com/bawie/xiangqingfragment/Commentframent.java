package com.bawie.xiangqingfragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawie.R;
import com.bawie.model.CommentsBean;
import com.bawie.presenter.CommentPresenter;
import com.bawie.view.adapter.CommentAdapter;
import com.bawie.view.inter.IMainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public  class Commentframent extends Fragment implements IMainView.comment {
    @BindView(R.id.critices_recy)
    RecyclerView criticesRecy;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.activity_comment, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        //得到movieid
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);

        CommentPresenter commentPresenter = new CommentPresenter();
        commentPresenter.attachView(this);
        commentPresenter.getcomment(movieId);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        criticesRecy.setLayoutManager(linearLayoutManager);
        return inflate;
    }


    public void comment(CommentsBean bean) {
        List<CommentsBean.ResultBean> result = bean.getResult();
        CommentAdapter comment_adapter = new CommentAdapter(R.layout.commentsitem, result);
        criticesRecy.setAdapter(comment_adapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        criticesRecy.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void ok(CommentsBean commentsBean) {

    }

    @Override
    public void no(String msg) {

    }
}
