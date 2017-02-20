package com.cheyifu.wsl.cheyifuapp.tabHome.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cheyifu.wsl.cheyifuapp.R;
import com.cheyifu.wsl.cheyifuapp.base.BaseBean;
import com.cheyifu.wsl.cheyifuapp.base.BaseMVPActivity;
import com.cheyifu.wsl.cheyifuapp.base.IUI;
import com.cheyifu.wsl.cheyifuapp.tabHome.adapter.MyCarMessageAdapter;
import com.cheyifu.wsl.cheyifuapp.tabHome.iView.IMessageView;
import com.cheyifu.wsl.cheyifuapp.tabHome.persenter.MessagePresenter;
import com.cheyifu.wsl.cheyifuapp.utils.AndroidUtils;

import java.util.ArrayList;
import java.util.List;

public class CarMessageActivity extends BaseMVPActivity<MessagePresenter>implements IMessageView,View.OnClickListener {


    private RelativeLayout back;
    private ListView listView;
    private List<BaseBean> beanList=new ArrayList<BaseBean>();

    @Override
    protected void onCreateExecute(Bundle savedInstanceState) {
        setContentView(R.layout.activity_car_message);
        initView();
        initListener();
        initData();
    }

    private void initData() {

    }

    private void initListener() {
        back.setOnClickListener(this);
    }

    private void initView() {
        TextView textView = (TextView) findViewById(R.id.tv_titlebar);
        textView.setText("车辆信息");
        back = (RelativeLayout) findViewById(R.id.iv_back);
        listView = (ListView) findViewById(R.id.lv_list);
        MyCarMessageAdapter adapter=  new MyCarMessageAdapter(beanList,CarMessageActivity.this);
        listView.setAdapter(adapter);


    }

    @Override
    protected MessagePresenter createPresenter() {
        return new MessagePresenter();
    }

    @Override
    protected IUI getUI() {
        return CarMessageActivity.this;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                AndroidUtils.hideSoftInput(this, null);
                dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK));
                dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BACK));
                break;
        }
    }
}
