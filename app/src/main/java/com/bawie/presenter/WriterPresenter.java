package com.bawie.presenter;


import com.bawie.model.OkHttp;
import com.bawie.model.WriterreviewsBean;
import com.bawie.view.inter.IMainView;

public  class WriterPresenter extends BasePresenter<IMainView.writerReviews>implements IMainView.writerReviewspresenter {

    public void getwriterReview(int userid, String sessionId, int movieId, String coment, double score) {
        OkHttp.getInstance().writerReviewsget(userid, sessionId, movieId, coment, score, new OkHttp.CallBack<WriterreviewsBean>() {
            @Override
            public void ok(WriterreviewsBean bean) {
               getView().ok(bean);
            }
        });
    }

    @Override
    public void ok(WriterreviewsBean writerreviewsBean) {

    }

    @Override
    public void no(String msg) {

    }
}
