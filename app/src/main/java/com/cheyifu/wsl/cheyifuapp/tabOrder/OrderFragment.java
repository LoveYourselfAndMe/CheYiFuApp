package com.cheyifu.wsl.cheyifuapp.tabOrder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cheyifu.wsl.cheyifuapp.R;
import com.cheyifu.wsl.cheyifuapp.base.BaseMVPFragment;
import com.cheyifu.wsl.cheyifuapp.base.IUI;

/**
 * Created by Administrator on 2017/2/14.
 */
public class OrderFragment extends BaseMVPFragment<OrderPresenter>implements IOrderView {
    @Override
    protected View onCreateViewExecute(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_order, null);

        return inflate;
    }

    @Override
    protected IUI getUI() {
        return OrderFragment.this;
    }

    @Override
    protected OrderPresenter createPresenter() {
        return new OrderPresenter();
    }

    @Override
    public String getPageName() {
        return null;
    }
}
