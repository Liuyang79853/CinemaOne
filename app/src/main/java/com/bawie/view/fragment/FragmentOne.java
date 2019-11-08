package com.bawie.view.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bawie.R;
import com.bawie.model.BannerBean;
import com.bawie.model.HotmovieBean;
import com.bawie.model.OnnowBean;
import com.bawie.model.UpcomingBean;
import com.bawie.presenter.BannerPresenter;
import com.bawie.presenter.Hotmoviespresenter;
import com.bawie.presenter.Onnowpresenter;
import com.bawie.presenter.Upcomingpresenter;
import com.bawie.view.adapter.HotmoviesrecyAdpter;
import com.bawie.view.adapter.MoreupcomingAdpter;
import com.bawie.view.adapter.OnnowrecyAdpter;
import com.bawie.view.inter.IMainView;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentOne extends Fragment implements IMainView.banner, IMainView.recyview, IMainView.recyview2, IMainView.recyview3 {


    @BindView(R.id.dw)
    ImageView dw;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.ssan)
    ImageView ssan;
    @BindView(R.id.banner)
    com.stx.xhb.xbanner.XBanner banner;
    @BindView(R.id.zzgd)
    TextView zzgd;
    @BindView(R.id.from1_recy1)
    RecyclerView from1Recy1;
    @BindView(R.id.jjgd)
    TextView jjgd;
    @BindView(R.id.from1_recy2)
    RecyclerView from1Recy2;
    @BindView(R.id.rmgd)
    TextView rmgd;
    @BindView(R.id.bigimage)
    ImageView bigimage;
    @BindView(R.id.from1_recy3)
    RecyclerView from1Recy3;
    private BannerPresenter bannerPresenter;
    private Onnowpresenter onnowpresenter;
    private Upcomingpresenter upcomingpresenter;
    private Hotmoviespresenter hotmoviespresenter;
    private SharedPreferences aa;
    private int userId;
    private String sessionId;
    private List<String> list=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragmentone, container, false);
          ButterKnife.bind(this, inflate);
        //banner p层
        bannerPresenter = new BannerPresenter();
        bannerPresenter.attachView(this);
        bannerPresenter.getbanner();
        //3个recyview  正在热映
        onnowpresenter = new Onnowpresenter();
        onnowpresenter.getrecyview();
        onnowpresenter.attachView(this);
        //即将上映 p层
        upcomingpresenter = new Upcomingpresenter();
        upcomingpresenter.getrecyview2(userId, sessionId);
        upcomingpresenter.attachView(this);
        //热门电影 p层
        hotmoviespresenter = new Hotmoviespresenter();
        hotmoviespresenter.getrecyview3();
        hotmoviespresenter.attachView(this);

        ssan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getActivity(), SearchActivity.class));
            }
        });

        return inflate;
    }

    @Override
    public void banner(final BannerBean bannerBean) {
        List<BannerBean.ResultBean> result = bannerBean.result;
        for (int i = 0; i < result.size(); i++) {
            BannerBean.ResultBean resultBean = result.get(i);
            String imageUrl = resultBean.imageUrl;
            list.add(imageUrl);
        }
        Log.i("aaaaa", "banner: "+list);
        //轮播图
        banner.setData(list, null);
        banner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(getActivity()).load(bannerBean.result.get(position).imageUrl).into((ImageView) view);
            }
        });
        banner.setAutoPalyTime(2000);
        banner.startAutoPlay();
    }

    @Override
    public void recyview(OnnowBean onnowBean) {
        //正在热映
        Log.e("aaa", "" + onnowBean.result.get(0).name);
        List<OnnowBean.ResultBean> result = onnowBean.result;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        from1Recy1.setLayoutManager(linearLayoutManager);
        OnnowrecyAdpter onnowrecyAdpter = new OnnowrecyAdpter(result, getContext());
        from1Recy1.setAdapter(onnowrecyAdpter);
    }

    @Override
    public void recyview2(UpcomingBean upcomingBean) {
        //即将上映
        List<UpcomingBean.ResultBean> result2 = upcomingBean.result;
        Log.i("121212", "recyview2: " + result2.get(1).name);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        from1Recy2.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        MoreupcomingAdpter moreupcomingAdpter = new MoreupcomingAdpter(result2, getContext());
        from1Recy2.setAdapter(moreupcomingAdpter);
    }

    @Override
    public void recyview3(HotmovieBean hotmovieBean) {
        //热门电影
        String horizontalImage = hotmovieBean.result.get(0).horizontalImage;
        Glide.with(getContext()).load(horizontalImage).into(bigimage);
        List<HotmovieBean.ResultBean> result3 = hotmovieBean.result;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        from1Recy3.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        HotmoviesrecyAdpter hotmoviesrecyAdpter = new HotmoviesrecyAdpter(result3, getContext());
        from1Recy3.setAdapter(hotmoviesrecyAdpter);
    }


    @OnClick({R.id.zzgd, R.id.jjgd, R.id.rmgd})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zzgd:
                break;
            case R.id.jjgd:
                break;
            case R.id.rmgd:
                break;
        }
    }
}
