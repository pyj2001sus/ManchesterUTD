package kr.co.tjeit.manchesterutd.fragment.member_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import kr.co.tjeit.manchesterutd.R;
import kr.co.tjeit.manchesterutd.adapter.LegendAdapter;
import kr.co.tjeit.manchesterutd.adapter.FirstTeamSpinnerAdapter;
import kr.co.tjeit.manchesterutd.adapter.LegendSpinnerAdapter;
import kr.co.tjeit.manchesterutd.data.member.FirstTeam;
import kr.co.tjeit.manchesterutd.data.member.Legend;
import kr.co.tjeit.manchesterutd.util.GlobalData;

/**
 * Created by the on 2017-10-18.
 */

public class LegendFragment extends Fragment {

    LegendAdapter mAdapter;
    LegendSpinnerAdapter sAdapter;
    private android.widget.GridView memberGridView;
    private android.widget.FrameLayout allmemberLayout;
    private android.widget.Spinner spinner;
    private android.widget.Button backBtn;
    private android.widget.ImageView playerImg;
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
    private android.widget.LinearLayout memberDetailLayout;
    private TextView birthDayTxt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_legend, container, false);
        this.memberDetailLayout = (LinearLayout) v.findViewById(R.id.memberDetailLayout);
        this.introductionTxt = (TextView) v.findViewById(R.id.introductionTxt);
        this.positionTxt = (TextView) v.findViewById(R.id.positionTxt);
        this.playedGameTxt = (TextView) v.findViewById(R.id.playedGameTxt);
        this.goalTxt = (TextView) v.findViewById(R.id.goalTxt);
        this.debutTxt = (TextView) v.findViewById(R.id.debutTxt);
        this.joinUnitedTxt = (TextView) v.findViewById(R.id.joinUnitedTxt);
        this.birthDayTxt = (TextView) v.findViewById(R.id.birthDayTxt);
        this.playerNameTxt = (TextView) v.findViewById(R.id.playerNameTxt);
        this.playerImg = (ImageView) v.findViewById(R.id.playerImg);
        this.backBtn = (Button) v.findViewById(R.id.backBtn);
        this.spinner = (Spinner) v.findViewById(R.id.spinner);
        this.allmemberLayout = (FrameLayout) v.findViewById(R.id.allmemberLayout);
        this.memberGridView = (GridView) v.findViewById(R.id.memberGridView);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValues();
    }

    private void setupEvents() {

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Legend data = GlobalData.legends.get(i);
                Glide.with(getActivity()).load(data.getPlayerImgURL()).into(playerImg);
                playerNameTxt.setText(data.getName());
                birthDayTxt.setText(data.getBirthDay());
                joinUnitedTxt.setText(data.getJoinUnited());
                debutTxt.setText(data.getUnitedDebut());
                goalTxt.setText(data.getAllGoal() + " 골");
                playedGameTxt.setText(data.getPlayedGame() + " 경기");
                positionTxt.setText(data.getPosition());
                introductionTxt.setText(data.getIntroduction());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        memberGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Legend data = GlobalData.legends.get(i);
                Glide.with(getActivity()).load(data.getPlayerImgURL()).into(playerImg);
                playerNameTxt.setText(data.getName());
                birthDayTxt.setText(data.getBirthDay());
                joinUnitedTxt.setText(data.getJoinUnited());
                debutTxt.setText(data.getUnitedDebut());
                goalTxt.setText(data.getAllGoal() + "골");
                playedGameTxt.setText(data.getPlayedGame() + "경기");
                positionTxt.setText(data.getPosition());
                introductionTxt.setText(data.getIntroduction());

                allmemberLayout.setVisibility(View.GONE);
                memberDetailLayout.setVisibility(View.VISIBLE);
            }
        });


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allmemberLayout.setVisibility(View.VISIBLE);
                memberDetailLayout.setVisibility(View.GONE);
            }
        });
    }

    private void setValues() {

        mAdapter = new LegendAdapter(getActivity(), GlobalData.legends);
        memberGridView.setAdapter(mAdapter);

        sAdapter = new LegendSpinnerAdapter(getActivity(), GlobalData.legends);
        spinner.setAdapter(sAdapter);

    }


}
