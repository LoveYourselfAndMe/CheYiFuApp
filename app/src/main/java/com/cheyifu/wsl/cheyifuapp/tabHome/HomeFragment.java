package com.cheyifu.wsl.cheyifuapp.tabHome;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cheyifu.wsl.cheyifuapp.R;
import com.cheyifu.wsl.cheyifuapp.base.BaseMVPFragment;
import com.cheyifu.wsl.cheyifuapp.base.IUI;
import com.cheyifu.wsl.cheyifuapp.global.BaseApplication;
import com.cheyifu.wsl.cheyifuapp.tabHome.activity.AddCarActivity;
import com.cheyifu.wsl.cheyifuapp.tabHome.activity.HistoryActivity;
import com.cheyifu.wsl.cheyifuapp.utils.LocalFileUtils;
import com.kevin.loopview.AdLoopView;
import com.kevin.loopview.internal.LoopData;
import com.kevin.loopview.utils.JsonTool;

/**
 * Created by Administrator on 2017/2/14.
 */
public class HomeFragment extends BaseMVPFragment<HomePresenter> implements IHomeView, View.OnClickListener {

    private AdLoopView mLoopView;
    private LinearLayout addCar;
    private LinearLayout history;
    private LinearLayout defy;
    private LinearLayout qr;

    @Override
    protected View onCreateViewExecute(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_home, null);
        mLoopView = (AdLoopView) inflate.findViewById(R.id.main_act_adloopview);
        addCar = (LinearLayout) inflate.findViewById(R.id.add_car);
        history = (LinearLayout) inflate.findViewById(R.id.stop_history);
        defy = (LinearLayout) inflate.findViewById(R.id.defy_query);
        qr = (LinearLayout) inflate.findViewById(R.id.qr);
        initListener();
//        initRotateView();
        return inflate;
    }

    private void initListener() {
        addCar.setOnClickListener(this);
        history.setOnClickListener(this);
        defy.setOnClickListener(this);
        qr.setOnClickListener(this);
    }

    /**
     * 初始化LoopView
     *
     * @return void
     * @date 2015-10-9 21:32:12
     */
    private void initRotateView() {
        String json = LocalFileUtils.getStringFormAsset(BaseApplication.getContext(), "loopview_date.json");
        LoopData loopData = JsonTool.toBean(json, LoopData.class);
        if (null != loopData) {
            mLoopView.refreshData(loopData);
            mLoopView.startAutoLoop();
        }

    }

    @Override
    protected IUI getUI() {
        return HomeFragment.this;
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public String getPageName() {
        return HomeFragment.class.getSimpleName();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_car:
                Intent intent=new Intent(getContext(),AddCarActivity.class);
                startActivity(intent);
                break;
            case R.id.stop_history:
                Intent history=new Intent(getContext(),HistoryActivity.class);
                startActivity(history);

                break;
            case R.id.qr:

                break;
            case R.id.defy_query:

                break;
        }

    }
}
