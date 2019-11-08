package com.bawie.Fragmenttwo;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawie.R;
import com.bawie.model.FujinBean;
import com.bawie.presenter.FujinPresenter;
import com.bawie.view.adapter.FujinAdapter;
import com.bawie.view.fragment.BaseFragment;
import com.bawie.view.inter.IMainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class YinyuanTwoFragment extends BaseFragment<FujinPresenter> implements IMainView.IFujin {


    @BindView(R.id.re_fujin)
    RecyclerView reFujin;
    Unbinder unbinder;
    private LinearLayoutManager linearLayoutManager;
    private FujinAdapter fujinAdapter;


    @Override
    protected void initData() {
        f.setFujin();
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        reFujin.setLayoutManager(linearLayoutManager);


    }

    @Override
    protected void initView() {

    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_yinyuan_two;
    }

    @Override
    protected FujinPresenter setFrag() {
        return new FujinPresenter();
    }

    @Override
    public void ok(FujinBean fujinBean) {
        List<FujinBean.ResultBean> list = fujinBean.getResult();
        fujinAdapter = new FujinAdapter(getContext(),list);
        reFujin.setAdapter(fujinAdapter);
    }

    @Override
    public void no(String msg) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}