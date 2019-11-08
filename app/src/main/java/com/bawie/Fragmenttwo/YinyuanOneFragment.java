package com.bawie.Fragmenttwo;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawie.R;
import com.bawie.model.TuijianBean;
import com.bawie.presenter.TuijianPresenter;
import com.bawie.view.adapter.ReTuijianAdapter;
import com.bawie.view.fragment.BaseFragment;
import com.bawie.view.inter.IMainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class YinyuanOneFragment extends BaseFragment<TuijianPresenter> implements IMainView.ITui {

    @BindView(R.id.re_tuijian)
    RecyclerView reTuijian;
    Unbinder unbinder;
    private LinearLayoutManager linearLayoutManager;
    private ReTuijianAdapter reTuijianAdapter;

    @Override
    protected void initData() {
        f.setTuijian();
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        reTuijian.setLayoutManager(linearLayoutManager);
        reTuijianAdapter = new ReTuijianAdapter(getContext());
        reTuijian.setAdapter(reTuijianAdapter);
    }

    @Override
    protected TuijianPresenter setFrag() {
        return new TuijianPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_yinyuan_one;
    }

    @Override
    public void ok(TuijianBean tuijianBean) {
        List<TuijianBean.ResultBean> result = tuijianBean.getResult();
        reTuijianAdapter.getTui(result);
        Toast.makeText(getActivity(), ""+tuijianBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void no(String msg) {

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
