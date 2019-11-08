package com.bawie.presenter;


import com.bawie.model.CommentsBean;
import com.bawie.model.OkHttp;
import com.bawie.view.inter.IMainView;

public class CommentPresenter extends BasePresenter<IMainView.comment>  {

    public void getcomment(int movieId) {
        OkHttp.getInstance().commentdata(movieId, new OkHttp.CallBack<CommentsBean>() {
            @Override
            public void ok(CommentsBean bean) {
                getView().ok(bean);
            }
        });
    }

}
