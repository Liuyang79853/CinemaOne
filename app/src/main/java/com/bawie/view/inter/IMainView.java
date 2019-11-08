package com.bawie.view.inter;

import com.bawie.model.BannerBean;
import com.bawie.model.CommentsBean;
import com.bawie.model.DetailsBean;
import com.bawie.model.FujinBean;
import com.bawie.model.HotmovieBean;
import com.bawie.model.OnnowBean;
import com.bawie.model.TuijianBean;
import com.bawie.model.UpcomingBean;
import com.bawie.model.WriterreviewsBean;

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
    interface ITui extends IBaseView{
        void ok(TuijianBean tuijianBean);
        void no(String msg);
    }
    interface IFujin extends IBaseView{
        void ok(FujinBean fujinBean);
        void no(String msg);
    }
    interface detail extends IBaseView{
        void ok(DetailsBean detailsBean);
        void no(String msg);
    }
    interface comment extends IBaseView{
        void ok(CommentsBean commentsBean);
        void no(String msg);
    }
    interface writerReviews extends IBaseView{
        void ok(WriterreviewsBean writerreviewsBean);
        void no(String msg);
    }
    interface writerReviewspresenter extends IBaseView{
        void ok(WriterreviewsBean writerreviewsBean);
        void no(String msg);
    }
}
