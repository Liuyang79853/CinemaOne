package com.bawie.presenter;


import com.bawie.view.inter.IBaseView;

public class BasePresenter<T extends IBaseView> {

    private T mview;

    public void attachView(T mview){
        this.mview = mview;
    }

    public void dataView(){
        this.mview = null;
    }

    public T getView(){
        return mview;
    }


}
