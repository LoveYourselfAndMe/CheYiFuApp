package com.cheyifu.wsl.cheyifuapp.login;

import com.cheyifu.wsl.cheyifuapp.base.BaseBean;
import com.cheyifu.wsl.cheyifuapp.net.BuildCheYiFuApi;
import com.cheyifu.wsl.cheyifuapp.net.CheYiFuHttpCallbackAdapter;
import com.cheyifu.wsl.cheyifuapp.net.RequestExecutor;

import java.util.Map;

import retrofit2.Call;

/**
 * Created by Administrator on 2017/2/20.
 */
public class LoginApi {
    private  static  LoginApi mDefault;
    public static LoginApi getDefault(){
        if (null == mDefault) {
            mDefault=new LoginApi();
        }
        return mDefault;

    }
    /**
     * 获取验证码
     * @param map
     * @param callback
     * @return
     */
    public RequestExecutor<BaseBean> getAuthCode(Map<String,Object> map , final CheYiFuHttpCallbackAdapter<BaseBean> callback){
        Call<BaseBean> authCode = BuildCheYiFuApi.getAPIService().getAuthCode(map);
        return new RequestExecutor<BaseBean>(authCode,callback).call();
    }

    /**
     * 登录
     * @param map
     * @param callback
     * @return
    */
    public RequestExecutor<BaseBean> login(Map<String,String> map ,final CheYiFuHttpCallbackAdapter<BaseBean> callback){
        Call<BaseBean> loginCall = BuildCheYiFuApi.getAPIService().login(map);
        return new RequestExecutor<BaseBean>(loginCall,callback).call();
    }
}
