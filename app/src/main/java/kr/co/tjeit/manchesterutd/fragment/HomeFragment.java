package kr.co.tjeit.manchesterutd.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kr.co.tjeit.manchesterutd.R;

/**
 * Created by the on 2017-10-18.
 */

public class HomeFragment extends Fragment{

    private android.widget.TextView premierLeagueLink;
    private TextView LinkTxt1;
    private TextView LinkTxt2;
    private TextView LinkTxt3;
    private TextView LinkTxt4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        this.LinkTxt4 = (TextView) v.findViewById(R.id.LinkTxt4);
        this.LinkTxt3 = (TextView) v.findViewById(R.id.LinkTxt3);
        this.LinkTxt2 = (TextView) v.findViewById(R.id.LinkTxt2);
        this.LinkTxt1 = (TextView) v.findViewById(R.id.LinkTxt1);

        Linkify.TransformFilter mTransform = new Linkify.TransformFilter() {
            @Override
            public String transformUrl(Matcher matcher, String s) {
                return "";
            }
        };

        Pattern pattern1 = Pattern.compile("잉글리시 프리미어 리그");
        Pattern pattern2 = Pattern.compile("그레이터맨체스터 주 트래포드");
        Pattern pattern3 = Pattern.compile("올드 트래포드");
        Pattern pattern4 = Pattern.compile("리버풀 FC");
        Pattern pattern5 = Pattern.compile("노스웨스트 더비");
        Pattern pattern6 = Pattern.compile("리즈 유나이티드 FC");
        Pattern pattern7 = Pattern.compile("로즈 더비");
        Pattern pattern8 = Pattern.compile("맨체스터 시티 FC");
        Pattern pattern9 = Pattern.compile("맨체스터 더비");
        Pattern pattern10 = Pattern.compile("아스날 FC");

        Linkify.addLinks(LinkTxt1, pattern1, "https://namu.wiki/w/%ED%94%84%EB%A6%AC%EB%AF%B8%EC%96%B4%20%EB%A6%AC%EA%B7%B8?from=%EC%9E%89%EA%B8%80%EB%A6%AC%EC%8B%9C%20%ED%94%84%EB%A6%AC%EB%AF%B8%EC%96%B4%20%EB%A6%AC%EA%B7%B8");
        Linkify.addLinks(LinkTxt2, pattern2, "https://namu.wiki/w/%EB%A7%A8%EC%B2%B4%EC%8A%A4%ED%84%B0?from=%EA%B7%B8%EB%A0%88%EC%9D%B4%ED%84%B0%EB%A7%A8%EC%B2%B4%EC%8A%A4%ED%84%B0%20%EC%A3%BC");
        Linkify.addLinks(LinkTxt3, pattern3, "https://namu.wiki/w/%EC%98%AC%EB%93%9C%20%ED%8A%B8%EB%9E%98%ED%8F%AC%EB%93%9C");
        Linkify.addLinks(LinkTxt4, pattern4, "https://namu.wiki/w/%EB%A6%AC%EB%B2%84%ED%92%80%20FC");
        Linkify.addLinks(LinkTxt4, pattern5, "https://namu.wiki/w/%EB%85%B8%EC%8A%A4%EC%9B%A8%EC%8A%A4%ED%8A%B8%20%EB%8D%94%EB%B9%84");
        Linkify.addLinks(LinkTxt4, pattern6, "https://namu.wiki/w/%EB%A6%AC%EC%A6%88%20%EC%9C%A0%EB%82%98%EC%9D%B4%ED%8B%B0%EB%93%9C%20FC");
        Linkify.addLinks(LinkTxt4, pattern7, "https://namu.wiki/w/%EB%A1%9C%EC%A6%88%20%EB%8D%94%EB%B9%84");
        Linkify.addLinks(LinkTxt4, pattern8, "https://namu.wiki/w/%EB%A7%A8%EC%B2%B4%EC%8A%A4%ED%84%B0%20%EC%8B%9C%ED%8B%B0%20FC");
        Linkify.addLinks(LinkTxt4, pattern9, "https://namu.wiki/w/%EB%A7%A8%EC%B2%B4%EC%8A%A4%ED%84%B0%20%EB%8D%94%EB%B9%84");
        Linkify.addLinks(LinkTxt4, pattern10, "https://namu.wiki/w/%EC%95%84%EC%8A%A4%EB%82%A0%20FC");

        return v;
    }
}
