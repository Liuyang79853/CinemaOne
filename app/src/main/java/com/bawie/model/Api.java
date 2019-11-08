package com.bawie.model;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
 *@Auther:刘阳
 *@Date: 2019年
 *@Time:
 *@Description:
 * */public interface Api {

    //banner
    @GET("movieApi/tool/v2/banner")
    Observable<BannerBean> getbanner();
    //热门电影
    @GET("movieApi/movie/v2/findHotMovieList")
    Observable<OnnowBean>getfindHot(@Query("page")int page, @Query("count")int count);
    //即将上映
    @GET("movieApi/movie/v2/findComingSoonMovieList")
    Observable<UpcomingBean> getfindcoming(@Query("page")int page, @Query("count")int count );
    //热门电影
    @GET("movieApi/movie/v2/findHotMovieList")
    Observable<HotmovieBean> getfindHot2(@Query("page") int page, @Query("count") int count);


}
