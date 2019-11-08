package com.bawie.model;

import java.util.List;

public class UpcomingBean {

  /**
   * result : [{"imageUrl":"http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg","movieId":16,"name":"碟中谍6：全面瓦解","releaseTime":1600704000000,"wantSeeNum":1,"whetherReserve":2},{"imageUrl":"http://172.17.8.100/images/movie/stills/jmyx/jmyx1.jpg","movieId":14,"name":"解码游戏","releaseTime":1599062400000,"wantSeeNum":2,"whetherReserve":2},{"imageUrl":"http://172.17.8.100/images/movie/stills/xhssf/xhssf1.jpg","movieId":3,"name":"西虹市首富","releaseTime":1595779200000,"wantSeeNum":0,"whetherReserve":2}]
   * message : 查询成功
   * status : 0000
   */

  public String message;
  public String status;
  public List<ResultBean> result;

  public static class ResultBean {
      /**
       * imageUrl : http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg
       * movieId : 16
       * name : 碟中谍6：全面瓦解
       * releaseTime : 1600704000000
       * wantSeeNum : 1
       * whetherReserve : 2
       */

      public String imageUrl;
      public int movieId;
      public String name;
      public long releaseTime;
      public int wantSeeNum;
      public int whetherReserve;
  }
}
