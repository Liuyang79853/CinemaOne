package com.bawie.Fragmenttwo;


import com.bawie.R;
import com.bawie.model.TuijianBean;
import com.bawie.presenter.TuijianPresenter;
import com.bawie.view.fragment.BaseFragment;
import com.bawie.view.inter.IMainView;

public class YinyuanThreeFragment  extends BaseFragment<TuijianPresenter> implements IMainView.ITui {

    @Override
    protected void initData() {

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
        return R.layout.fragment_yinyuan_three;
    }

    @Override
    public void ok(TuijianBean tuijianBean) {

    }

    @Override
    public void no(String msg) {

    }
}
