package com.cheyifu.wsl.cheyifuapp.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Administrator on 2016/10/8 0008.
 */
public class AndroidUtils {
    /**
     * 隐藏输入法（根据activity当前焦点所在控件的WindowToken）
     */
    public static void hideSoftInput(Activity activity, View editText) {
        View view;
        if (editText == null) {
            view = activity.getCurrentFocus();
        } else {
            view = editText;
        }

        if (view != null) {
            InputMethodManager inputMethod = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethod.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    /**
     * 显示键盘
     *
     * @param view
     */
    public static void showKeyboard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        imm.showSoftInput(view, 0);
    }
}
