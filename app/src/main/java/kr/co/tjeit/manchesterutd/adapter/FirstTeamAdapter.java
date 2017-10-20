package kr.co.tjeit.manchesterutd.adapter;

import android.content.Context;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.manchesterutd.R;
import kr.co.tjeit.manchesterutd.data.member.FirstTeam;

/**
 * Created by the on 2017-10-20.
 */

public class FirstTeamAdapter extends ArrayAdapter<FirstTeam> {

    Context mContext;
    List<FirstTeam> mList;
    LayoutInflater inf;

    public FirstTeamAdapter(Context context, List<FirstTeam> list) {
        super(context, R.layout.fragment_first_team, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if ( row == null) {
            row = inf.inflate(R.layout.fragment_first_team, null);
        }

        FirstTeam data = mList.get(position);

        TextView backNum = (TextView) row.findViewById(R.id.backNumTxt);
        TextView name = (TextView) row.findViewById(R.id.nameTxt);
        TextView playerPosition = (TextView) row.findViewById(R.id.positionTxt);
        TextView playedGame = (TextView) row.findViewById(R.id.playedGameTxt);
        TextView goal = (TextView) row.findViewById(R.id.goalTxt);
        TextView joinUnited = (TextView) row.findViewById(R.id.joinUnitedTxt);
        TextView transferFee = (TextView) row.findViewById(R.id.transferfeeTxt);
        TextView beforeUnited = (TextView) row.findViewById(R.id.beforeUnitedTxt);
        TextView unitedDebut = (TextView) row.findViewById(R.id.debutTxt);
        TextView country = (TextView) row.findViewById(R.id.countryTxt);
        TextView introduction = (TextView) row.findViewById(R.id.introductionTxt);

        backNum.setText(data.getBackNum());
        name.setText(data.getName());
        playerPosition.setText(data.getPosition());
        playedGame.setText(data.getPlayedGame());
        goal.setText(data.getGoal());
        joinUnited.setText(data.getJoinUnited());
        transferFee.setText(data.getTransferFee());
        beforeUnited.setText(data.getBeforeUnited());
        unitedDebut.setText(data.getUnitedDebut());
        country.setText(data.getCountry());
        introduction.setText(data.getIntroduction());

        return row;
    }

}
