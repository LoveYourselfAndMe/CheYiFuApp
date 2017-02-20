package com.cheyifu.wsl.cheyifuapp.tabHome.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.cheyifu.wsl.cheyifuapp.R;
import com.cheyifu.wsl.cheyifuapp.base.BaseMVPActivity;
import com.cheyifu.wsl.cheyifuapp.base.IUI;
import com.cheyifu.wsl.cheyifuapp.tabHome.iView.IAddCarView;
import com.cheyifu.wsl.cheyifuapp.tabHome.persenter.AddCarPresenter;
import com.cheyifu.wsl.cheyifuapp.utils.AndroidUtils;
import com.cheyifu.wsl.cheyifuapp.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class AddCarActivity extends BaseMVPActivity<AddCarPresenter> implements IAddCarView, View.OnClickListener {


    private RelativeLayout back;
    private Spinner spinner;
    private EditText editText;
    private List<String> data_list;
    private RelativeLayout car_submit;

    @Override
    protected void onCreateExecute(Bundle savedInstanceState) {
        setContentView(R.layout.activity_add_car);
        initView();
        initListener();
        initData();
    }

    private void initData() {
        //数据
        data_list = new ArrayList<String>();
        data_list.add("京");
        data_list.add("津");
        data_list.add("冀");
        data_list.add("晋");
        data_list.add("蒙");
        data_list.add("辽");
        data_list.add("吉");
        data_list.add("黑");
        data_list.add("沪");
        data_list.add("苏");
        data_list.add("浙");
        data_list.add("皖");
        data_list.add("闽");
        data_list.add("赣");
        //适配器
        ArrayAdapter<String> arr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data_list);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner.setAdapter(arr_adapter);
//        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String str = adapterView.getItemAtPosition(i).toString();
//                ToastUtil.showStringToast(str);
//            }
//        });


    }

    private void initListener() {
        back.setOnClickListener(this);
        car_submit.setOnClickListener(this);
    }

    private void initView() {
        TextView textView = (TextView) findViewById(R.id.tv_titlebar);
        textView.setText("添加车辆");
        back = (RelativeLayout) findViewById(R.id.iv_back);
        spinner = (Spinner) findViewById(R.id.sp_car);
        editText = (EditText) findViewById(R.id.car_code);
        car_submit = (RelativeLayout) findViewById(R.id.car_submit);
    }

    @Override
    protected AddCarPresenter createPresenter() {
        return new AddCarPresenter();
    }

    @Override
    protected IUI getUI() {
        return AddCarActivity.this;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                AndroidUtils.hideSoftInput(this, null);
                dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK));
                dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BACK));
                break;
            case R.id.car_submit:
                Intent intent = new Intent(AddCarActivity.this, CarMessageActivity.class);
                startActivity(intent);
                this.finish();
                break;
        }
    }
}
