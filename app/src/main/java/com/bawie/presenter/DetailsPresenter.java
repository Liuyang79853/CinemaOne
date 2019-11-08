package com.bawie.presenter;


import com.bawie.model.DetailsBean;
import com.bawie.model.OkHttp;
import com.bawie.view.inter.IMainView;

public class DetailsPresenter extends BasePresenter<IMainView.detail> {
    public void getdetail(int userId, String sessionId, int movieId) {
        OkHttp.getInstance().datailsgetdata(userId, sessionId, movieId, new OkHttp.CallBack<DetailsBean>() {
            @Override
            public void ok(DetailsBean bean) {
                getView().ok(bean);
            }
        });
    }
}
