package com.bawie.view.activity;


import com.bawie.model.DetailsBean;

public class EvenBus_XuanZuo {
    private DetailsBean xuanzuo;

    public EvenBus_XuanZuo(DetailsBean xuanzuo) {
        this.xuanzuo = xuanzuo;
    }

    @Override
    public String toString() {
        return "EvenBus_XuanZuo{" +
                "xuanzuo=" + xuanzuo +
                '}';
    }

    public DetailsBean getXuanzuo() {
        return xuanzuo;
    }

    public void setXuanzuo(DetailsBean xuanzuo) {
        this.xuanzuo = xuanzuo;
    }
}
