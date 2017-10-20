package kr.co.tjeit.manchesterutd.fragment.member_fragment;

import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import kr.co.tjeit.manchesterutd.R;
import kr.co.tjeit.manchesterutd.util.GlobalData;

/**
 * Created by the on 2017-10-18.
 */

public class FirstTeamFragment extends Fragment {

    private android.widget.LinearLayout degea;
    private android.widget.LinearLayout lindelof;
    private android.widget.TextView number1;
    private de.hdodenhof.circleimageview.CircleImageView circleImageView;
    private FrameLayout allmemberLayout;
    private LinearLayout memberDetailLayout;
    private android.widget.Button backBtn;
    private android.widget.TextView backNumTxt;
    private android.widget.TextView playerNameTxt;
    private android.widget.TextView positionTxt;
    private android.widget.TextView playedGameTxt;
    private android.widget.TextView goalTxt;
    private android.widget.TextView joinUnitedTxt;
    private android.widget.TextView transferfeeTxt;
    private android.widget.TextView beforeUnitedTxt;
    private android.widget.TextView debutTxt;
    private android.widget.TextView countryTxt;
    private android.widget.TextView introductionTxt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first_team, container, false);
        this.introductionTxt = (TextView) v.findViewById(R.id.introductionTxt);
        this.countryTxt = (TextView) v.findViewById(R.id.countryTxt);
        this.debutTxt = (TextView) v.findViewById(R.id.debutTxt);
        this.beforeUnitedTxt = (TextView) v.findViewById(R.id.beforeUnitedTxt);
        this.transferfeeTxt = (TextView) v.findViewById(R.id.transferfeeTxt);
        this.joinUnitedTxt = (TextView) v.findViewById(R.id.joinUnitedTxt);
        this.goalTxt = (TextView) v.findViewById(R.id.goalTxt);
        this.playedGameTxt = (TextView) v.findViewById(R.id.playedGameTxt);
        this.positionTxt = (TextView) v.findViewById(R.id.positionTxt);
        this.playerNameTxt = (TextView) v.findViewById(R.id.playerNameTxt);
        this.backNumTxt = (TextView) v.findViewById(R.id.backNumTxt);
        this.backBtn = (Button) v.findViewById(R.id.backBtn);
        this.memberDetailLayout = (LinearLayout) v.findViewById(R.id.memberDetailLayout);
        this.allmemberLayout = (FrameLayout) v.findViewById(R.id.allmemberLayout);
        this.circleImageView = (CircleImageView) v.findViewById(R.id.circleImageView);
        this.lindelof = (LinearLayout) v.findViewById(R.id.lindelof);
        this.degea = (LinearLayout) v.findViewById(R.id.de_gea);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValues();
    }

    private void setupEvents() {

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allmemberLayout.setVisibility(View.VISIBLE);
                memberDetailLayout.setVisibility(View.GONE);
            }
        });

        degea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allmemberLayout.setVisibility(View.GONE);
                memberDetailLayout.setVisibility(View.VISIBLE);

            }
        });

    }

    private void setValues() {


    }


}
