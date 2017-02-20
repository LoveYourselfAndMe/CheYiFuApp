package com.cheyifu.wsl.cheyifuapp.tabHome.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;

import com.cheyifu.wsl.cheyifuapp.R;
import com.cheyifu.wsl.cheyifuapp.base.BaseBean;
import com.cheyifu.wsl.cheyifuapp.tabHome.activity.CarSureActivity;

import java.util.List;

/**
 * Created by Administrator on 2017/2/15.
 */
public class StopListAdapter extends BaseAdapter {
    private List<BaseBean> mList;
    private Context mContext;
    public StopListAdapter(List<BaseBean> list, Context context){
        this.mList=list;
        this.mContext=context;

    }
    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder viewHoler = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_list_item, null);
            viewHoler = new ViewHolder();
            convertView.setTag(viewHoler);
        } else {
            viewHoler = (ViewHolder) convertView.getTag();
        }






        return convertView;
    }


public static class ViewHolder {
    private RelativeLayout rl_approve;

}
}
