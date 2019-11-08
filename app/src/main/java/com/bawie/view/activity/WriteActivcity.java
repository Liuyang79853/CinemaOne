package com.bawie.view.activity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bawie.R;
import com.bawie.model.WriterreviewsBean;
import com.bawie.presenter.WriterPresenter;
import com.bawie.view.inter.IMainView;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class WriteActivcity extends AppCompatActivity implements IMainView.writerReviews {

    @BindView(R.id.ping_name)
    TextView pingName;
    @BindView(R.id.ping_count)
    RatingBar pingCount;
    @BindView(R.id.ping_neirong)
    EditText pingNeirong;
    @BindView(R.id.pingjia_tijiao)
    Button pingjiaTijiao;
    private String sessionId;
    private SharedPreferences aa;
    private int userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_activcity);
        ButterKnife.bind(this);
        //得到movieid
        Intent intent = getIntent();
        final int movieId = intent.getIntExtra("movieId", 0);
        Log.i("aaaaaaa", "onCreate: "+movieId);
        //取出存入sp的userId和sessionId
        aa = getSharedPreferences("aa", Context.MODE_PRIVATE);
        userId = aa.getInt("userId", 1);
        sessionId = aa.getString("sessionId", "");


        final WriterPresenter writerPresenter = new WriterPresenter();
        writerPresenter.attachView(this);

        pingjiaTijiao.setOnClickListener(new View.OnClickListener() {
            private double v1;
            @Override
            public void onClick(View view) {
                String trim = pingNeirong.getText().toString().trim();
                //监听RatingBar  对RatingBar 进行赋值 或获得其值
                pingCount.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                        v1 = v;
                    }
                });
                if(trim.equals("")){
                    Toast.makeText(WriteActivcity.this, "不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                writerPresenter.getwriterReview(userId, sessionId, movieId,trim,v1);
                finish();
            }
        });
    }

    public void writerReviews(WriterreviewsBean bean) {
        Log.e("d",bean.message);
        if(bean.message.equals("评论失败")){
            Toast.makeText(this, "评论失败", Toast.LENGTH_SHORT).show();
            return;
        }else{
            Toast.makeText(this, "评论成功", Toast.LENGTH_SHORT).show();
        }
    }
}
