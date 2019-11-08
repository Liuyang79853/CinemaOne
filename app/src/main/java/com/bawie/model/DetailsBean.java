package com.bawie.model;

import java.util.List;

public class DetailsBean {

    /**
     * result : {"commentNum":8,"duration":"100分钟","imageUrl":"http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)1.jpg","movieActor":[{"name":"古天乐","photo":"http://172.17.8.100/images/movie/actor/ftfb3/gutianle.jpg","role":"陆志廉"},{"name":"张智霖","photo":"http://172.17.8.100/images/movie/actor/ftfb3/zhangzhilin.jpg","role":"刘保强"},{"name":"郑嘉颖","photo":"http://172.17.8.100/images/movie/actor/ftfb3/zhengjiaying.jpg","role":"程德明"},{"name":"邓丽欣","photo":"http://172.17.8.100/images/movie/actor/ftfb3/denglixin.jpg","role":"吴颂华"},{"name":"\r\n谢天华","photo":"http://172.17.8.100/images/movie/actor/ftfb3/xietianhua.jpg","role":"狄伟杰"}],"movieDirector":[{"name":"林德禄","photo":"http://172.17.8.100/images/movie/director/ftfb3/1.jpg"}],"movieId":17,"movieType":"动作 / 剧情 / 犯罪","name":"反贪风暴3","placeOrigin":"中国大陆,中国香港","posterList":["http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)1.jpg","http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)2.jpg","http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)3.jpg","http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)4.jpg","http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)5.jpg","http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)6.jpg"],"releaseTime":1537545600000,"score":9.1,"shortFilmList":[{"imageUrl":"http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)2.jpg","videoUrl":"http://172.17.8.100/video/movie/ftfb3/ftfb(3)1.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)3.jpg","videoUrl":"http://172.17.8.100/video/movie/ftfb3/ftfb(3)2.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)4.jpg","videoUrl":"http://172.17.8.100/video/movie/ftfb3/ftfb(3)3.mp4"}],"summary":"ICAC (廉政公署) 陆志廉（古天乐 饰），JFIU (联合财富情报组) 刘保强（张智霖 饰）分别侦查贪污及洗黑钱案，但苦无线索，这时廉政公署L组 (内部纪律调查组) 程德明（郑嘉颖 饰）收到举报，指陆志廉收贿1200万，陆无法辩解实时停职。刘发现陆被诬陷，并跟一直调查的洗黑钱案有着千丝万缕关系，同时怀疑银行主任游子新（栢天男 饰）协助罪恶集团洗黑钱；陆冒险搜集罪证却遭禁锢，命悬一线.......","whetherFollow":2}
     * message : 查询成功
     * status : 0000
     */

    public ResultBean result;
    public String message;
    public String status;

    public static class ResultBean {
        /**
         * commentNum : 8
         * duration : 100分钟
         * imageUrl : http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)1.jpg
         * movieActor : [{"name":"古天乐","photo":"http://172.17.8.100/images/movie/actor/ftfb3/gutianle.jpg","role":"陆志廉"},{"name":"张智霖","photo":"http://172.17.8.100/images/movie/actor/ftfb3/zhangzhilin.jpg","role":"刘保强"},{"name":"郑嘉颖","photo":"http://172.17.8.100/images/movie/actor/ftfb3/zhengjiaying.jpg","role":"程德明"},{"name":"邓丽欣","photo":"http://172.17.8.100/images/movie/actor/ftfb3/denglixin.jpg","role":"吴颂华"},{"name":"\r\n谢天华","photo":"http://172.17.8.100/images/movie/actor/ftfb3/xietianhua.jpg","role":"狄伟杰"}]
         * movieDirector : [{"name":"林德禄","photo":"http://172.17.8.100/images/movie/director/ftfb3/1.jpg"}]
         * movieId : 17
         * movieType : 动作 / 剧情 / 犯罪
         * name : 反贪风暴3
         * placeOrigin : 中国大陆,中国香港
         * posterList : ["http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)1.jpg","http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)2.jpg","http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)3.jpg","http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)4.jpg","http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)5.jpg","http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)6.jpg"]
         * releaseTime : 1537545600000
         * score : 9.1
         * shortFilmList : [{"imageUrl":"http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)2.jpg","videoUrl":"http://172.17.8.100/video/movie/ftfb3/ftfb(3)1.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)3.jpg","videoUrl":"http://172.17.8.100/video/movie/ftfb3/ftfb(3)2.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)4.jpg","videoUrl":"http://172.17.8.100/video/movie/ftfb3/ftfb(3)3.mp4"}]
         * summary : ICAC (廉政公署) 陆志廉（古天乐 饰），JFIU (联合财富情报组) 刘保强（张智霖 饰）分别侦查贪污及洗黑钱案，但苦无线索，这时廉政公署L组 (内部纪律调查组) 程德明（郑嘉颖 饰）收到举报，指陆志廉收贿1200万，陆无法辩解实时停职。刘发现陆被诬陷，并跟一直调查的洗黑钱案有着千丝万缕关系，同时怀疑银行主任游子新（栢天男 饰）协助罪恶集团洗黑钱；陆冒险搜集罪证却遭禁锢，命悬一线.......
         * whetherFollow : 2
         */

        public int commentNum;
        public String duration;
        public String imageUrl;
        public int movieId;
        public String movieType;
        public String name;
        public String placeOrigin;
        public long releaseTime;
        public double score;
        public String summary;
        public int whetherFollow;
        public List<MovieActorBean> movieActor;
        public List<MovieDirectorBean> movieDirector;
        public List<String> posterList;
        public List<ShortFilmListBean> shortFilmList;

        public static class MovieActorBean {
            /**
             * name : 古天乐
             * photo : http://172.17.8.100/images/movie/actor/ftfb3/gutianle.jpg
             * role : 陆志廉
             */

            public String name;
            public String photo;
            public String role;
        }

        public static class MovieDirectorBean {
            /**
             * name : 林德禄
             * photo : http://172.17.8.100/images/movie/director/ftfb3/1.jpg
             */

            public String name;
            public String photo;
        }

        public static class ShortFilmListBean {
            /**
             * imageUrl : http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)2.jpg
             * videoUrl : http://172.17.8.100/video/movie/ftfb3/ftfb(3)1.mp4
             */

            public String imageUrl;
            public String videoUrl;
        }
    }
}
