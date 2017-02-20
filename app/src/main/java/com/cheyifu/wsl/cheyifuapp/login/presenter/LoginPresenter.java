package com.cheyifu.wsl.cheyifuapp.login.presenter;

import com.cheyifu.wsl.cheyifuapp.R;
import com.cheyifu.wsl.cheyifuapp.base.BaseBean;
import com.cheyifu.wsl.cheyifuapp.base.BasePresenter;
import com.cheyifu.wsl.cheyifuapp.login.Iview.ILoginView;
import com.cheyifu.wsl.cheyifuapp.login.LoginApi;
import com.cheyifu.wsl.cheyifuapp.main.MainActivity;
import com.cheyifu.wsl.cheyifuapp.net.CheYiFuHttpCallbackAdapter;
import com.cheyifu.wsl.cheyifuapp.utils.ToastUtil;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/14.
 */
public class LoginPresenter extends BasePresenter<ILoginView> {
    public void login(final String phone, String code) {
        MainActivity.launch(getContext(), phone);
        getUI().closeAct();
        Map<String, String> map = new HashMap<>();
        map.put("mobile",phone);
        map.put("smsCode",code);
        LoginApi.getDefault().login(map, new CheYiFuHttpCallbackAdapter<BaseBean>() {
            @Override
            public void completed(BaseBean response) {
                if (response != null) {
                    if (response.getResult() == 0) {
                        MainActivity.launch(getContext(), phone);
                        getUI().closeAct();
                    } else {
                        ToastUtil.showStringToast(response.getStrError());
                    }

                }

            }

            @Override
            public void failure(Throwable throwable) {
                ToastUtil.showToast(R.string.net_error);
            }
        });


    }

    public void checkCode(String phone) {
        Map<String, Object> map = new Hashtable<>();
        map.put("mobile", phone);
        LoginApi.getDefault().getAuthCode(map, new CheYiFuHttpCallbackAdapter<BaseBean>() {
            @Override
            public void completed(BaseBean response) {
                if (response != null) {
                    if (response.getResult() == 0) {
                        //开始倒计时
                        getUI().isGetCodeSuccess();
                        ToastUtil.showStringToast("验证码发送成功");
                    } else {
                        ToastUtil.showStringToast(response.getStrError());
                    }
                }
            }

            @Override
            public void failure(Throwable throwable) {

            }
        });

    }

}
