package kr.co.tjeit.manchesterutd.fragment.member_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import de.hdodenhof.circleimageview.CircleImageView;
import kr.co.tjeit.manchesterutd.R;
import kr.co.tjeit.manchesterutd.all_members.team_first.DeGea;
import kr.co.tjeit.manchesterutd.all_members.team_first.Lindelof;

/**
 * Created by the on 2017-10-18.
 */

public class FirstTeamFragment extends Fragment {

    private android.widget.LinearLayout degea;
    private android.widget.LinearLayout lindelof;
    private android.widget.TextView number1;
    private de.hdodenhof.circleimageview.CircleImageView circleImageView;
    private android.widget.FrameLayout degeafrag;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first_team, container, false);
        this.circleImageView = (CircleImageView) v.findViewById(R.id.circleImageView);
        this.lindelof = (LinearLayout) v.findViewById(R.id.lindelof);
        this.degea = (LinearLayout) v.findViewById(R.id.de_gea);
        setupEvents();
        setValues();
        return v;
    }


    private void setupEvents() {

    }

    private void setValues() {
    }


}
