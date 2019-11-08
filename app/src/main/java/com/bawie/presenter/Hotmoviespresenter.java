package com.bawie.presenter;


import com.bawie.model.HotmovieBean;
import com.bawie.model.OkHttp;
import com.bawie.view.inter.IMainView;

public class Hotmoviespresenter extends BasePresenter<IMainView.recyview3>{

    public void getrecyview3() {
        OkHttp.getInstance().RecygetData3(new OkHttp.CallBack<HotmovieBean>() {
            @Override
            public void ok(HotmovieBean bean) {
                getView().recyview3(bean);
            }
        });
    }
}
