package com.bawie.view.activity;

import android.os.Bundle;

import com.bawie.presenter.BasePresenter;
import com.bawie.view.inter.IBaseView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    public P p;

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        p =setPresenter();
        p.attachView(this);
        initData();

}

    protected abstract void initData();

    protected abstract P setPresenter();

    protected abstract int initLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        p.dataView();
    }
}
