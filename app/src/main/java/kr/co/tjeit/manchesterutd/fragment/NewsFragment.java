package kr.co.tjeit.manchesterutd.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import kr.co.tjeit.manchesterutd.R;
import kr.co.tjeit.manchesterutd.adapter.NewsAdapter;
import kr.co.tjeit.manchesterutd.util.GlobalData;

/**
 * Created by the on 2017-10-18.
 */

public class NewsFragment extends Fragment {

    NewsAdapter mAdapter;
    private android.widget.ListView newsListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_news, container, false);
        this.newsListView = (ListView) v.findViewById(R.id.newsListView);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValues();
    }

    private void setupEvents() {

    }

    private void setValues() {
        mAdapter = new NewsAdapter(getActivity(), GlobalData.news);
        newsListView.setAdapter(mAdapter);
    }
}
