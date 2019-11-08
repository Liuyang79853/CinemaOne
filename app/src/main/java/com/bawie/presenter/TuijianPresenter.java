package com.bawie.presenter;


import com.bawie.model.OkHttp;
import com.bawie.model.TuijianBean;
import com.bawie.view.inter.IMainView;

public class TuijianPresenter extends BasePresenter<IMainView.ITui>{
    public void setTuijian (){
        OkHttp.getInstance().getTuijian(new OkHttp.CallBack<TuijianBean>() {
            @Override
            public void ok(TuijianBean tuijianBean) {
                getView().ok(tuijianBean);
            }

        });
    }
}
