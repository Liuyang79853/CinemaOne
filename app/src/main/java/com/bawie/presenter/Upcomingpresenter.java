package com.bawie.presenter;


import com.bawie.model.OkHttp;
import com.bawie.model.UpcomingBean;
import com.bawie.view.inter.IMainView;

public class Upcomingpresenter extends BasePresenter<IMainView.recyview2>{

    public void getrecyview2(int userId, String sessionId) {
        OkHttp.getInstance().RecygetData2(new OkHttp.CallBack<UpcomingBean>() {
            @Override
            public void ok(UpcomingBean bean) {
                getView().recyview2(bean);
            }
        });
    }
}
