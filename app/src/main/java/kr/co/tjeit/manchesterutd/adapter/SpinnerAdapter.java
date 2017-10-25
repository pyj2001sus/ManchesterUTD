package kr.co.tjeit.manchesterutd.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import kr.co.tjeit.manchesterutd.R;

/**
 * Created by the on 2017-10-24.
 */

public class SpinnerAdapter extends BaseAdapter {
    Context mContext;
    List<String> mList;
    LayoutInflater inf;


    public SpinnerAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inf.inflate(R.layout.spinner_item, parent, false);
        }

        if (mList != null) {
            //데이터세팅
            String text = mList.get(position);
            ((TextView) convertView.findViewById(R.id.nowPlayer)).setText(text);
        }

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inf.inflate(R.layout.spinner_dialog_item, parent, false);
        }

        //데이터세팅
        String text = mList.get(position);
        ((TextView) convertView.findViewById(R.id.allPlayer)).setText(text);

        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}

