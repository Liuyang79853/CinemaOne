package com.bawie.view.activity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bawie.R;
import com.bawie.model.DetailsBean;
import com.bawie.presenter.DetailsPresenter;
import com.bawie.view.adapter.FragmentAdapter;
import com.bawie.view.adapter.Introduceframent;
import com.bawie.view.fragment.Stillsframent;
import com.bawie.view.inter.IMainView;
import com.bawie.xiangqingfragment.Commentframent;
import com.bawie.xiangqingfragment.Noticeframent;
import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity implements IMainView.detail {


    @BindView(R.id.x_tp)
    ImageView xTp;
    @BindView(R.id.x_name)
    TextView xName;
    @BindView(R.id.guanzhu)
    ImageView guanzhu;
    @BindView(R.id.x_leixing)
    TextView xLeixing;
    @BindView(R.id.x_time)
    TextView xTime;
    @BindView(R.id.x_data)
    TextView xData;
    @BindView(R.id.x_guo)
    TextView xGuo;
    @BindView(R.id.details_tab)
    TabLayout detailsTab;
    @BindView(R.id.x_viewpager)
    ViewPager xViewpager;
    @BindView(R.id.x_pingjia)
    Button xPingjia;
    @BindView(R.id.x_xuan)
    Button xXuan;
    ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    private DetailsBean detailsBean1;
    private int movieId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        DetailsPresenter detailsPresenter = new DetailsPresenter();
        detailsPresenter.attachView(this);

        SharedPreferences aa = getSharedPreferences("aa", Context.MODE_PRIVATE);
        int userId = aa.getInt("userId", 1);
        String sessionId = aa.getString("sessionId", "");
        Intent intent = getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        Log.i("aa", "onCreate: " + movieId);
        detailsPresenter.getdetail(userId, sessionId, movieId);
        intiView();

    }

    private void intiView() {
        Introduceframent introduceframent = new Introduceframent();
        Commentframent commentframent = new Commentframent();
        Noticeframent noticeframent = new Noticeframent();
        Stillsframent stillsframent = new Stillsframent();
        fragments.add(introduceframent);
        fragments.add(noticeframent);
        fragments.add(stillsframent);
        fragments.add(commentframent);
        list.add("介绍");
        list.add("预告");
        list.add("剧照");
        list.add("影评");
        FragmentAdapter framAdpter = new FragmentAdapter(getSupportFragmentManager());
        xViewpager.setAdapter(framAdpter);
        detailsTab.setupWithViewPager(xViewpager);
        xXuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DetailsActivity.this, SeatbuyingActivity.class);
                EventBus.getDefault().postSticky(new EvenBus_XuanZuo(detailsBean1));
                intent1.putExtra("movieId",movieId);
                startActivity(intent1);
                Toast.makeText(DetailsActivity.this, "购票页面", Toast.LENGTH_SHORT).show();


            }
        });
        xPingjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DetailsActivity.this, WriteActivcity.class);
                intent1.putExtra("movieId", movieId);
                startActivity(intent1);
            }
        });
    }

    public void fh(View view) {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void ok(DetailsBean detailsBean) {
        detailsBean1 = detailsBean;
        movieId = detailsBean.result.movieId;
        Log.e("qqwwee", detailsBean.toString());
        String imageUrl = detailsBean.result.imageUrl;
        Glide.with(this).load(imageUrl).into(xTp);
        DetailsBean.ResultBean result = detailsBean.result;
        String name = result.name;
        xName.setText(name);
        String movieType = result.movieType;
        xLeixing.setText(movieType);
        String duration = result.duration;
        xTime.setText(duration);
        SimpleDateFormat format = new SimpleDateFormat("yyyy" + "年" + "MM" + "月" + "dd" + "日");
        String format1 = format.format(result.releaseTime);
        xData.setText(format1);
        String placeOrigin = result.placeOrigin;
        xGuo.setText(placeOrigin);
    }

    @Override
    public void no(String msg) {

    }
}

