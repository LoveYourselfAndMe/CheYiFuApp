package com.cheyifu.wsl.cheyifuapp.net;

public interface CheYiFuHttpCallback<T> {

    void onCompleted(T response, int httpCode, String httpMessage);

    void onFailure(Throwable throwable);
}
