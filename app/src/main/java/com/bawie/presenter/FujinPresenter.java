package com.bawie.presenter;


import com.bawie.model.FujinBean;
import com.bawie.model.OkHttp;
import com.bawie.view.inter.IMainView;

public class FujinPresenter extends BasePresenter<IMainView.IFujin> {
     public void setFujin(){
         OkHttp.getInstance().getFujin(new OkHttp.CallBack<FujinBean>() {
             @Override
             public void ok(FujinBean o) {
                 getView().ok(o);
             }
         });
     }

}
