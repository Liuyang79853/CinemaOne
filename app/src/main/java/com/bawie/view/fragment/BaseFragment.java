package com.bawie.view.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bawie.presenter.BasePresenter;
import com.bawie.view.inter.IBaseView;

public abstract class BaseFragment<F extends BasePresenter> extends Fragment implements IBaseView {

    public F f;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(setLayout(), container, false);

        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        f = setFrag();
        f.attachView(this);
        initData();


    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int setLayout();

    protected abstract F setFrag();

    public <T extends View> T getViewId(int id) {
        return getView().findViewById(id);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        f.dataView();
    }
}
