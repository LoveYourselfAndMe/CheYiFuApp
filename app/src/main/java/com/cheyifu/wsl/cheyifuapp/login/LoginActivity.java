package com.cheyifu.wsl.cheyifuapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.cheyifu.wsl.cheyifuapp.R;
import com.cheyifu.wsl.cheyifuapp.base.BaseMVPActivity;
import com.cheyifu.wsl.cheyifuapp.base.IUI;
import com.cheyifu.wsl.cheyifuapp.global.BaseApplication;
import com.cheyifu.wsl.cheyifuapp.login.Iview.ILoginView;
import com.cheyifu.wsl.cheyifuapp.login.presenter.LoginPresenter;
import com.cheyifu.wsl.cheyifuapp.main.MainActivity;
import com.cheyifu.wsl.cheyifuapp.utils.CharCheckUtil;
import com.cheyifu.wsl.cheyifuapp.utils.SPUtils;
import com.cheyifu.wsl.cheyifuapp.utils.ToastUtil;
import com.cheyifu.wsl.cheyifuapp.utils.isFascClick;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseMVPActivity<LoginPresenter> implements ILoginView {
    @Bind(R.id.rl_submit)
    RelativeLayout submit;

    @Bind(R.id.et_user)
    EditText et_user;

    @Bind(R.id.et_pass)
    EditText et_pass;

    @Bind(R.id.get_code)
    Button get_code;
    private CountDownTimer mTimer;

    @OnClick(R.id.rl_submit)
    public void setSubmit() {
        login();
    }

    @OnClick(R.id.get_code)
    public void setGet_code() {
        String phone = et_user.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            ToastUtil.showStringToast("请输入手机号");
            return;
        }
        boolean phoneNum = CharCheckUtil.isPhoneNum(phone);
        if (!phoneNum) {
            ToastUtil.showStringToast("手机号码不正确");
            return;
        }
        getCode(phone);

    }

    private String CODE = "code";
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    SPUtils.clearByKey(CODE, BaseApplication.getContext());
                    break;
            }
        }
    };

    public void getCode(String phone) {
        getPresenter().checkCode(phone);

    }


    private void login() {
        //拦截连续点击的事件
        if (isFascClick.isClick()) {
            ToastUtil.showStringToast("不能连续点击");
            return;
        }
        String username = et_user.getText().toString().trim();
        String userpass = et_pass.getText().toString().trim();

        if (TextUtils.isEmpty(username)) {
            ToastUtil.showStringToast("手机号不能为空！");
            return;
        }
        if (TextUtils.isEmpty(userpass)) {
            ToastUtil.showStringToast("验证码不能为空！");
            return;
        }

        //保存用户名和密码
        SPUtils.putString(this, "USERNAME", username);
        SPUtils.putString(this, "PASSWORD", userpass);
        getPresenter().login(username,userpass);


    }


    @Override
    protected void onCreateExecute(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);

    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected IUI getUI() {
        return LoginActivity.this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopTimer();
    }

    @Override
    public void closeAct() {
        this.finish();
    }

    @Override
    public void isGetCodeSuccess() {
        mTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                get_code.setText(millisUntilFinished / 1000 + "秒后获取");
                get_code.setClickable(false);
            }

            @Override
            public void onFinish() {
                get_code.setText("获取验证码");
                get_code.setClickable(true);
                stopTimer();
            }
        };
        mTimer.start();
    }

    public void stopTimer() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }
}
