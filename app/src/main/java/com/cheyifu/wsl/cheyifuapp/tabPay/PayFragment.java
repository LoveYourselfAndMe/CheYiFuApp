package com.cheyifu.wsl.cheyifuapp.tabPay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.cheyifu.wsl.cheyifuapp.R;
import com.cheyifu.wsl.cheyifuapp.base.BaseBean;
import com.cheyifu.wsl.cheyifuapp.base.BaseMVPFragment;
import com.cheyifu.wsl.cheyifuapp.base.IUI;
import com.cheyifu.wsl.cheyifuapp.tabHome.adapter.StopListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/14.
 */
public class PayFragment extends BaseMVPFragment<PayPresenter> implements IPayView {
    private List<BaseBean> list=new ArrayList<BaseBean>();
    @Override
    protected View onCreateViewExecute(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_pay, null);
        ListView listView= (ListView) inflate.findViewById(R.id.pay_list);
        StopListAdapter adapter= new StopListAdapter(list,getContext());
        listView.setAdapter(adapter);
        return inflate;
    }

    @Override
    protected IUI getUI() {
        return PayFragment.this;
    }

    @Override
    protected PayPresenter createPresenter() {
        return new PayPresenter();
    }

    @Override
    public String getPageName() {
        return PayFragment.class.getSimpleName();
    }
}
