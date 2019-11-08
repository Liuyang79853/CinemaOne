package com.bawie.model;


import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/*
 *@Auther:刘阳
 *@Date: 2019年
 *@Time:
 *@Description:
 * */public class OkHttp {
    private static final OkHttp okHttp = new OkHttp();
    private final Api api;

    public static OkHttp getInstance() {
        return okHttp;
    }

    private OkHttp() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constant.URL)
                .build();

        api = retrofit.create(Api.class);

    }

    public void bannergetdata(final CallBack callBack) {
        api.getbanner().subscribeOn(Schedulers.io()  )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                        callBack.ok(bannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
    public void RecygetData(final CallBack callBack) {
        api.getfindHot(1, 10).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OnnowBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(OnnowBean onnowBean) {
                        callBack.ok(onnowBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void RecygetData2(final CallBack callBack) {
        api.getfindcoming(1, 10).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UpcomingBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UpcomingBean upcomingBean) {
                        callBack.ok(upcomingBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void RecygetData3(final CallBack callBack) {
        api.getfindHot2(1, 10).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotmovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotmovieBean hotmovieBean) {
                        callBack.ok(hotmovieBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //推荐影院
    public void getTuijian(final CallBack callBack){
        api.gettuijian()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TuijianBean>() {
                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TuijianBean tuijianBean) {
                        callBack.ok(tuijianBean);
                    }
                });
    }
    //附近影院
    public void getFujin(final CallBack callBack){
        api.getfujin()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FujinBean>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FujinBean fujinBean) {
                        callBack.ok(fujinBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
    //影片详情
    public void datailsgetdata(int userId, String sessionId, int movieId, final CallBack callBack){
        api.getDetails(userId, sessionId, movieId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DetailsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DetailsBean detailsBean) {
                        callBack.ok(detailsBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //影片评论
    public void commentdata(int movieId, final CallBack callBack){
        api.getComments(movieId,1,10).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<CommentsBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(CommentsBean commentsBean) {
                callBack.ok(commentsBean);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void writerReviewsget(int userid, String sessionId, int movieId, String commentContent, double score, final CallBack callBack){
        api.getWriter(userid,sessionId,movieId,commentContent,score).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<WriterreviewsBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(WriterreviewsBean writerreviewsBean) {
                callBack.ok(writerreviewsBean);
            }

            @Override
            public void onError(Throwable e) {
                WriterreviewsBean ww = new WriterreviewsBean();
                ww.message=e.getMessage();
                callBack.ok(ww);
            }

            @Override
            public void onComplete() {

            }
        });
    }


    public interface CallBack<B> {
        void ok(B b);
    }

}
