package com.cheyifu.wsl.cheyifuapp.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;

import com.cheyifu.wsl.cheyifuapp.R;
import com.cheyifu.wsl.cheyifuapp.base.BaseMVPActivity;
import com.cheyifu.wsl.cheyifuapp.base.IUI;
import com.cheyifu.wsl.cheyifuapp.global.Constants;
import com.cheyifu.wsl.cheyifuapp.tabHome.HomeFragment;
import com.cheyifu.wsl.cheyifuapp.tabMy.MyFragment;
import com.cheyifu.wsl.cheyifuapp.tabOrder.OrderFragment;
import com.cheyifu.wsl.cheyifuapp.tabPay.PayFragment;
import com.cheyifu.wsl.cheyifuapp.utils.ToastUtil;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseMVPActivity<MainPresenter> implements ImainView, View.OnClickListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private HomeFragment homeFragment;
    private OrderFragment orderFragment;
    private PayFragment payFragment;
    private MyFragment myFragment;
    private RadioButton homeButton;
    private RadioButton myButton;
    private RadioButton payButton;
    private RadioButton orderButton;

    public static void launch(Context mContext, String phone) {
        Intent intent = new Intent(mContext, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.PHONE_NUM, phone);//保存手机号
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    @Bind(R.id.bt_add)
    ImageButton button;

    @OnClick(R.id.bt_add)
    public void setButton() {
        ToastUtil.showStringToast("添加了");
    }


    @Override
    protected void onCreateExecute(Bundle savedInstanceState) {

        setContentView(R.layout.activity_main);
        fragmentManager = this.getSupportFragmentManager();
        initView();
        initListener();
        initData();

    }

    private void initView() {
        homeButton = (RadioButton) findViewById(R.id.first);
        orderButton = (RadioButton) findViewById(R.id.second);
        payButton = (RadioButton) findViewById(R.id.three);
        myButton = (RadioButton) findViewById(R.id.four);
    }

    private void initData() {
        homeFragment = new HomeFragment();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(R.id.main_fragment, homeFragment);
        beginTransaction.commit();
        homeButton.setChecked(true);
    }

    private void initListener() {
        homeButton.setOnClickListener(this);
        orderButton.setOnClickListener(this);
        payButton.setOnClickListener(this);
        myButton.setOnClickListener(this);
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected IUI getUI() {
        return MainActivity.this;
    }

    @Override
    public void onClick(View v) {
        fragmentTransaction = fragmentManager.beginTransaction();
        goneFragment(fragmentTransaction);
        switch (v.getId()) {
            case R.id.first:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.main_fragment, homeFragment);
                } else {
                    fragmentTransaction.show(homeFragment);
                }
                break;
            case R.id.second:
                if (orderFragment == null) {
                    orderFragment = new OrderFragment();
                    fragmentTransaction.add(R.id.main_fragment, orderFragment);
                } else {
                    fragmentTransaction.show(orderFragment);
                }
                break;
            case R.id.three:
                if (payFragment == null) {
                    payFragment = new PayFragment();
                    fragmentTransaction.add(R.id.main_fragment, payFragment);
                } else {
                    fragmentTransaction.show(payFragment);
                }
                break;
            case R.id.four:
                if (myFragment == null) {
                    myFragment = new MyFragment();
                    fragmentTransaction.add(R.id.main_fragment, myFragment);
                } else {
                    fragmentTransaction.show(myFragment);
                }
                break;

        }
        fragmentTransaction.commit();
    }

    private void goneFragment(FragmentTransaction beginTransaction) {
        if (homeFragment != null) {
            beginTransaction.hide(homeFragment);
        }
        if (orderFragment != null) {
            beginTransaction.hide(orderFragment);
        }
        if (payFragment != null) {
            beginTransaction.hide(payFragment);
        }
        if (myFragment != null) {
            beginTransaction.hide(myFragment);
        }
    }
}
