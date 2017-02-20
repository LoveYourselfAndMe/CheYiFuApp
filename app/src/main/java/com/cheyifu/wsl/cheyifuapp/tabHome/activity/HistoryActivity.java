package com.cheyifu.wsl.cheyifuapp.tabHome.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cheyifu.wsl.cheyifuapp.R;
import com.cheyifu.wsl.cheyifuapp.base.BaseBean;
import com.cheyifu.wsl.cheyifuapp.base.BaseMVPActivity;
import com.cheyifu.wsl.cheyifuapp.base.IUI;
import com.cheyifu.wsl.cheyifuapp.tabHome.adapter.StopListAdapter;
import com.cheyifu.wsl.cheyifuapp.tabHome.iView.IHistoryView;
import com.cheyifu.wsl.cheyifuapp.tabHome.persenter.HisPresenter;
import com.cheyifu.wsl.cheyifuapp.utils.AndroidUtils;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends BaseMVPActivity<HisPresenter> implements IHistoryView ,View.OnClickListener{


    private RelativeLayout back;
    private ListView stop_list;
    private List<BaseBean> list=new ArrayList<BaseBean>();
    private LinearLayout record;
    private View loading1;
    private View loading2;
    private LinearLayout loading;

    @Override
    protected void onCreateExecute(Bundle savedInstanceState) {
        setContentView(R.layout.activity_history);
        initView();
        initListener();
        initData();
    }

    private void initData() {

    }

    private void initListener() {
        back.setOnClickListener(this);
        record.setOnClickListener(this);
        loading.setOnClickListener(this);


    }

    private void initView() {
        TextView textView = (TextView) findViewById(R.id.tv_titlebar);
        textView.setText("停车记录");
        back = (RelativeLayout) findViewById(R.id.iv_back);
        record = (LinearLayout) findViewById(R.id.history_record);
        stop_list = (ListView) findViewById(R.id.stop_list);
        loading1 = findViewById(R.id.loading1);
        loading2 = findViewById(R.id.loading2);
        loading = (LinearLayout) findViewById(R.id.loading);
        StopListAdapter adapter= new StopListAdapter(list,HistoryActivity.this);
        stop_list.setAdapter(adapter);
    }

    @Override
    protected HisPresenter createPresenter() {
        return new HisPresenter();
    }

    @Override
    protected IUI getUI() {
        return HistoryActivity.this;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                AndroidUtils.hideSoftInput(this, null);
                dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK));
                dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BACK));
                break;
            case R.id.history_record:
                loading2.setVisibility(View.VISIBLE);
                loading1.setVisibility(View.INVISIBLE);
                //刷新list
//                list.notify();
                break;
            case R.id.loading:
                loading2.setVisibility(View.INVISIBLE);
                loading1.setVisibility(View.VISIBLE);
                //刷新list
//                list.notify();
                break;
        }

    }
}
