package com.bawie.view.inter;

import com.bawie.model.BannerBean;
import com.bawie.model.HotmovieBean;
import com.bawie.model.OnnowBean;
import com.bawie.model.UpcomingBean;

/*
 *@Auther:刘阳
 *@Date: 2019年
 *@Time:
 *@Description:
 * */public interface IMainView {

    interface banner extends IBaseView{
        void banner(BannerBean bannerBean);
    }
    interface recyview extends IBaseView{
        void recyview(OnnowBean onnowBean);
    }
    interface recyview2 extends IBaseView{
        void recyview2(UpcomingBean upcomingBean);
    }
    interface recyview3 extends IBaseView{
        void recyview3(HotmovieBean hotmovieBean);
    }

}
