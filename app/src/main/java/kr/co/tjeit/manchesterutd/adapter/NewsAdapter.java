package kr.co.tjeit.manchesterutd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import kr.co.tjeit.manchesterutd.R;
import kr.co.tjeit.manchesterutd.data.NewsData;
import kr.co.tjeit.manchesterutd.data.member.Legend;
import kr.co.tjeit.manchesterutd.util.GlobalData;

/**
 * Created by the on 2017-10-25.
 */

public class NewsAdapter extends ArrayAdapter<NewsData> {

    Context mContext;
    List<NewsData> mList;
    LayoutInflater inf;

    public NewsAdapter(Context context, List<NewsData> list) {
        super(context, R.layout.news_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row==null) {
            row = inf.inflate(R.layout.news_list_item, null);
        }

        NewsData data = mList.get(position);

        ImageView newsImgURL = row.findViewById(R.id.newsImgURL);
        TextView newsHeadLineTxt = row.findViewById(R.id.newsHeadLineTxt);
        TextView newsContentTxt = row.findViewById(R.id.newsContentTxt);

        Glide.with(mContext).load(data.getImgURL()).into(newsImgURL);
        newsHeadLineTxt.setText(data.getNewsHeadLine());
        newsContentTxt.setText(data.getContent());

        return row;
    }

}
