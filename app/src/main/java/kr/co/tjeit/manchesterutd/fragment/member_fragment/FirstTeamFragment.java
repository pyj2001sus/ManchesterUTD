package kr.co.tjeit.manchesterutd.fragment.member_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import kr.co.tjeit.manchesterutd.R;
import kr.co.tjeit.manchesterutd.adapter.FirstTeamAdapter;
import kr.co.tjeit.manchesterutd.data.member.FirstTeam;
import kr.co.tjeit.manchesterutd.util.GlobalData;

/**
 * Created by the on 2017-10-18.
 */

public class FirstTeamFragment extends Fragment {

    FirstTeamAdapter mAdapter;

    ArrayList<String> playerList = new ArrayList<>();
    ArrayAdapter<String> playerAdapter;

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
    private android.widget.GridView memberGridView;
    private CircleImageView circleImageView2;
    private android.widget.ImageView playerImg;
    private android.widget.Spinner spinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first_team, container, false);
        this.spinner = (Spinner) v.findViewById(R.id.spinner);
        this.playerImg = (ImageView) v.findViewById(R.id.playerImg);
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
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(mContext, position + "번 줄 선택", Toast.LENGTH_SHORT).show();

                addHairStyle(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        memberGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FirstTeam data = GlobalData.firstTeams.get(i);
                Glide.with(getActivity()).load(data.getPlayerImgURL()).into(playerImg);
                backNumTxt.setText(data.getBackNum() + ". ");
                playerNameTxt.setText(data.getName());
                positionTxt.setText(data.getPosition());
                playedGameTxt.setText(data.getPlayedGame() + "경기");
                goalTxt.setText(data.getGoal() + "골");
                joinUnitedTxt.setText(data.getJoinUnited());
                transferfeeTxt.setText(data.getTransferFee());
                beforeUnitedTxt.setText(data.getBeforeUnited());
                debutTxt.setText(data.getUnitedDebut());
                countryTxt.setText(data.getCountry());
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

        mAdapter = new FirstTeamAdapter(getActivity(), GlobalData.firstTeams);
        memberGridView.setAdapter(mAdapter);

    }

    private void addHairStyle(int categoryIndex) {
        playerList.clear();
        if (categoryIndex==0) {

            playerList.add("반삭");
            playerList.add("댄디컷");
            playerList.add("샤기컷");
            playerList.add("투블럭");
        }
        else if (categoryIndex == 1) {

            playerList.add("다운펌");
            playerList.add("가르마");
            playerList.add("매직");
        }
        else if (categoryIndex == 2) {
            playerList.add("빨강");
            playerList.add("파랑");
            playerList.add("노랑");
            playerList.add("갈색");
            playerList.add("탈색");
        }

        playerAdapter.notifyDataSetChanged();
    }


}
