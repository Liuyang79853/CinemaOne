package com.bawie.view.fragment;

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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawie.R;
import com.bawie.model.DetailsBean;
import com.bawie.presenter.DetailsPresenter;
import com.bawie.view.adapter.StillsAdapter;
import com.bawie.view.inter.IMainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Stillsframent extends Fragment implements IMainView.detail {
    @BindView(R.id.jz)
    RecyclerView jz;
    Unbinder unbinder;
    private String sessionId;
    private SharedPreferences aa;
    private int userId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.activity_still, container, false);
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void ok(DetailsBean detailsBean) {
        List<String> posterList = detailsBean.result.posterList;
        StillsAdapter stillsAdapter = new StillsAdapter(posterList, getContext());
        jz.setAdapter(stillsAdapter);
        GridLayoutManager linearLayoutManager1=new GridLayoutManager(getContext(),5);
        jz.setLayoutManager(linearLayoutManager1);
    }

    @Override
    public void no(String msg) {

    }
}
