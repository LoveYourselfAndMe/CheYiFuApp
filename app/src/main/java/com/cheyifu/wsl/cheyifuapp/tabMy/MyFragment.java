package com.cheyifu.wsl.cheyifuapp.tabMy;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cheyifu.wsl.cheyifuapp.R;
import com.cheyifu.wsl.cheyifuapp.base.BaseMVPFragment;
import com.cheyifu.wsl.cheyifuapp.base.IUI;
import com.cheyifu.wsl.cheyifuapp.tabMy.activity.AboutUsActivity;

/**
 * Created by Administrator on 2017/2/14.
 */
public class MyFragment extends BaseMVPFragment<MyPrensenter> implements IMyView, View.OnClickListener {

    private View inflate;
    private LinearLayout about;

    @Override
    protected View onCreateViewExecute(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_my, null);
        initView();
        initListener();
        return inflate;
    }

    private void initListener() {
        about.setOnClickListener(this);
    }

    private void initView() {
        about = (LinearLayout) inflate.findViewById(R.id.about_us);
    }

    @Override
    protected IUI getUI() {
        return MyFragment.this;
    }

    @Override
    protected MyPrensenter createPresenter() {
        return new MyPrensenter();
    }

    @Override
    public String getPageName() {
        return MyFragment.class.getSimpleName();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.about_us:
                Intent intent = new Intent(getContext(), AboutUsActivity.class);
                startActivity(intent);
                break;
        }
    }
}
