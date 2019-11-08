package com.bawie.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawie.Fragmenttwo.YinyuanOneFragment;
import com.bawie.Fragmenttwo.YinyuanThreeFragment;
import com.bawie.Fragmenttwo.YinyuanTwoFragment;
import com.bawie.R;
import com.bawie.presenter.FragmentyiPresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class FragmentTwo extends BaseFragment {


    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.tv_bei)
    TextView tvBei;
    @BindView(R.id.iv2)
    ImageView iv2;
    @BindView(R.id.rin1)
    RelativeLayout rin1;
    @BindView(R.id.Tb)
    TabLayout Tb;
    @BindView(R.id.viewp)
    ViewPager viewp;
    Unbinder unbinder;
    private List<Fragment> listone = new ArrayList<>();
    private List<String> strings;


    @Override
    protected void initData() {
        strings = new ArrayList<>();
        listone.add(new YinyuanOneFragment());
        listone.add(new YinyuanTwoFragment());
        listone.add(new YinyuanThreeFragment());
        strings.add("推荐影院");
        strings.add("附近影院");
        strings.add("海淀区");
        Tb.setupWithViewPager(viewp);

        viewp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return listone.get(i);
            }

            @Override
            public int getCount() {
                return listone.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return strings.get(position);
            }
        });


    }

    @Override
    protected FragmentyiPresenter setFrag() {
        return new FragmentyiPresenter();
    }

    @Override
    protected void initView() {


    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_two;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}


