package com.bawie.presenter;


import android.util.Log;

import com.bawie.model.BannerBean;
import com.bawie.model.OkHttp;
import com.bawie.view.inter.IMainView;


public class BannerPresenter extends BasePresenter<IMainView.banner> {
   public void getbanner(){
       OkHttp.getInstance().bannergetdata(new OkHttp.CallBack<BannerBean>() {
           @Override
           public void ok(BannerBean o) {
               Log.i("bbbbbb", "ok: "+o.message);
               getView().banner(o);
           }
       });
   }
}
