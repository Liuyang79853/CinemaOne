package com.bawie.xiangqingfragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.bawie.model.DetailsBean;
import com.bawie.presenter.DetailsPresenter;
import com.bawie.view.adapter.NoticeAdapter;
import com.bawie.view.inter.IMainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Noticeframent extends Fragment implements IMainView.detail {
    @BindView(R.id.sp)
    RecyclerView sp;
    Unbinder unbinder;
    private String sessionId;
    private SharedPreferences aa;
    private int userId;
    private NoticeAdapter noticeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.activity_notice, container, false);
        aa = getActivity().getSharedPreferences("aa", Context.MODE_PRIVATE);
        userId = aa.getInt("userId", 1);
        sessionId = aa.getString("sessionId", "");
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        DetailsPresenter detailsPresenter = new DetailsPresenter();
        detailsPresenter.getdetail(userId, sessionId, movieId);
        detailsPresenter.attachView(this);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }


    public void detail(DetailsBean detailsBean) {
        List<DetailsBean.ResultBean.ShortFilmListBean> shortFilmList = detailsBean.result.shortFilmList;
        noticeAdapter = new NoticeAdapter(shortFilmList, getContext());
        sp.setAdapter(noticeAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        sp.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        noticeAdapter.initview();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }

    @Override
    public void ok(DetailsBean detailsBean) {

    }

    @Override
    public void no(String msg) {

    }
}
