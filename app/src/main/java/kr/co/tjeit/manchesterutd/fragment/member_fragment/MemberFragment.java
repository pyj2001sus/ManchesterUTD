package kr.co.tjeit.manchesterutd.fragment.member_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;

import kr.co.tjeit.manchesterutd.R;

/**
 * Created by the on 2017-10-18.
 */

public class MemberFragment extends Fragment{

    TabHost myTabHost;
    private android.widget.TabWidget tabs;
    private android.widget.LinearLayout tab1;
    private android.widget.LinearLayout tab2;
    private android.widget.LinearLayout tab3;
    private android.widget.LinearLayout tab4;
    private android.widget.FrameLayout tabcontent;
    private LinearLayout tab5;
    private LinearLayout tab6;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_member, container, false);
        this.tab6 = (LinearLayout) v.findViewById(R.id.tab6);
        this.tab5 = (LinearLayout) v.findViewById(R.id.tab5);
        this.myTabHost = (TabHost) v.findViewById(R.id.myTabHost);
        this.tabcontent = (FrameLayout) v.findViewById(android.R.id.tabcontent);
        this.tab4 = (LinearLayout) v.findViewById(R.id.tab4);
        this.tab3 = (LinearLayout) v.findViewById(R.id.tab3);
        this.tab2 = (LinearLayout) v.findViewById(R.id.tab2);
        this.tab1 = (LinearLayout) v.findViewById(R.id.tab1);
        this.tabs = (TabWidget) v.findViewById(android.R.id.tabs);

        makeTabHost();

        return v;
    }

    private void makeTabHost() {

        myTabHost.setup();

        TabHost.TabSpec spec1 = myTabHost.newTabSpec("tab1").setIndicator("퍼스트 팀");
        spec1.setContent(R.id.tab1);
        myTabHost.addTab(spec1);

        TabHost.TabSpec spec2 = myTabHost.newTabSpec("tab2").setIndicator("리저브 팀");
        spec2.setContent(R.id.tab2);
        myTabHost.addTab(spec2);

        TabHost.TabSpec spec3 = myTabHost.newTabSpec("tab3").setIndicator("아카데미");
        spec3.setContent(R.id.tab3);
        myTabHost.addTab(spec3);

        TabHost.TabSpec spec4 = myTabHost.newTabSpec("tab4").setIndicator("감독");
        spec4.setContent(R.id.tab4);
        myTabHost.addTab(spec4);

        TabHost.TabSpec spec5 = myTabHost.newTabSpec("tab5").setIndicator("코칭스탭");
        spec5.setContent(R.id.tab5);
        myTabHost.addTab(spec5);

        TabHost.TabSpec spec6 = myTabHost.newTabSpec("tab6").setIndicator("전설적 인물");
        spec6.setContent(R.id.tab6);
        myTabHost.addTab(spec6);
    }

}
