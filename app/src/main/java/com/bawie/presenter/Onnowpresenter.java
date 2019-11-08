package com.bawie.presenter;


import com.bawie.model.OkHttp;
import com.bawie.model.OnnowBean;
import com.bawie.view.inter.IMainView;

public class Onnowpresenter extends BasePresenter<IMainView.recyview>{

   public void getrecyview() {
       OkHttp.getInstance().RecygetData(new OkHttp.CallBack<OnnowBean>() {
           @Override
           public void ok(OnnowBean bean) {
               getView().recyview(bean);
           }
       });
   }
}
