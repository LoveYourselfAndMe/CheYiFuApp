package com.cheyifu.wsl.cheyifuapp.net;

import com.cheyifu.wsl.cheyifuapp.base.BaseBean;
import com.cheyifu.wsl.cheyifuapp.global.Constants;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/2/20.
 */
public interface APIService {
    /**
     * 获取验证码
     * @param map
     * @return
     */
    @Headers("Cache-Control: public, max-age=3600")
    @FormUrlEncoded
    @POST(Constants.GET_CODE)
    Call<BaseBean> getAuthCode(@FieldMap Map<String, Object> map);
    /**
     * 登录
     * @param map
     * @return
     */
    @Headers("Cache-Control: public, max-age=3600")
    @FormUrlEncoded
    @POST(Constants.USER_LOGIN)
    Call<BaseBean> login(@FieldMap Map<String, String> map);
}
