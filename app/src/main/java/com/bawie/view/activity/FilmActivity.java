package com.bawie.view.activity;

import android.os.Bundle;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.bawie.R;
import com.bawie.view.fragment.FragmentOne;
import com.bawie.view.fragment.FragmentThree;
import com.bawie.view.fragment.FragmentTwo;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FilmActivity extends AppCompatActivity {

    // RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener
    ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    @BindView(R.id.frame)
    FrameLayout frame;
    @BindView(R.id.tv_movies)
    TextView tvMovies;
    @BindView(R.id.rb_movies)
    RadioButton rbMovies;
    @BindView(R.id.tv_cinema)
    TextView tvCinema;
    @BindView(R.id.rb_cinema)
    RadioButton rbCinema;
    @BindView(R.id.tv_mine)
    TextView tvMine;
    @BindView(R.id.rb_mine)
    RadioButton rbMine;
    @BindView(R.id.rg_group)
    RadioGroup rgGroup;
    private FragmentOne one;
    private FragmentTwo two;
    private FragmentThree three;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);
        ButterKnife.bind(this);


        one = new FragmentOne();
        two = new FragmentTwo();
        three = new FragmentThree();

        fragments.add(one);
        fragments.add(two);
        fragments.add(three);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame, one)
                .add(R.id.frame, two)
                .add(R.id.frame, three)
                .show(one)
                .hide(two)
                .hide(three)
                .commit();
        tvMovies.setVisibility(View.VISIBLE);
    }


    @OnClick({R.id.rb_movies, R.id.rb_cinema, R.id.rb_mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_movies:
                getSupportFragmentManager()
                        .beginTransaction()
                        .show(one)
                        .hide(two)
                        .hide(three)
                        .commit();
                rbMovies.setChecked(true);
                rbCinema.setChecked(false);
                rbMine.setChecked(false);
                tvMovies.setVisibility(View.VISIBLE);
                tvCinema.setVisibility(View.GONE);
                tvMine.setVisibility(View.GONE);
                break;
            case R.id.rb_cinema:
                getSupportFragmentManager()
                        .beginTransaction()
                        .hide(one)
                        .show(two)
                        .hide(three)
                        .commit();
                rbMovies.setChecked(false);
                rbCinema.setChecked(true);
                rbMine.setChecked(false);
                tvMovies.setVisibility(View.GONE);
                tvCinema.setVisibility(View.VISIBLE);
                tvMine.setVisibility(View.GONE);

                break;
            case R.id.rb_mine:
                getSupportFragmentManager()
                        .beginTransaction()
                        .hide(one)
                        .hide(two)
                        .show(three)
                        .commit();
                rbMovies.setChecked(false);
                rbCinema.setChecked(false);
                rbMine.setChecked(true);
                tvMovies.setVisibility(View.GONE);
                tvCinema.setVisibility(View.GONE);
                tvMine.setVisibility(View.VISIBLE);

                break;
        }
    }
}

