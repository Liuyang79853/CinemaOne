package com.bawie.model;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
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

    //推荐影院
    @GET("movieApi/cinema/v1/findRecommendCinemas?page=1&count=10")
    Observable<TuijianBean> gettuijian();
    //推荐影院
    @GET("movieApi/cinema/v1/findNearbyCinemas?page=1&count=10")
    Observable<FujinBean> getfujin();
    //电影详情
    @GET("movieApi/movie/v2/findMoviesDetail")
    Observable<DetailsBean>getDetails(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("movieId") int movieId);
    //电影评论
    @GET("movieApi/movie/v1/verify/movieComment")
    Observable<CommentsBean> getComments(@Query("movieId") int movieId,
                                         @Query("page") int page,
                                         @Query("count") int count);

    //添加影片评论
    @FormUrlEncoded
    @POST("movie1erify/movieComment")
    Observable<WriterreviewsBean> getWriter(@Header("userId") int userid,
                                            @Header("sessionId") String sessionId,
                                            @Field("movieId") int movieId,
                                            @Field("commentContent") String commentContent,
                                            @Field("score") double score
    );


}
