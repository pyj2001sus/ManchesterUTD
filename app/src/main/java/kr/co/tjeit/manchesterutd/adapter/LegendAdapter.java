package kr.co.tjeit.manchesterutd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import kr.co.tjeit.manchesterutd.R;
import kr.co.tjeit.manchesterutd.data.member.FirstTeam;
import kr.co.tjeit.manchesterutd.data.member.Legend;

/**
 * Created by the on 2017-10-25.
 */

public class LegendAdapter extends ArrayAdapter<Legend> {

    Context mContext;
    List<Legend> mList;
    LayoutInflater inf;

    public LegendAdapter(Context context, List<Legend> list) {
        super(context, R.layout.member_grid_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if ( row == null) {
            row = inf.inflate(R.layout.member_grid_list_item, null);
        }

        Legend data = mList.get(position);

        CircleImageView circleImageView = row.findViewById(R.id.circleImageView);
        Glide.with(mContext).load(data.getPlayerImgURL()).into(circleImageView);
        TextView nameTxt = row.findViewById(R.id.nameTxt);

        nameTxt.setText(data.getName());

//        TextView backNum = (TextView) row.findViewById(R.id.backNumTxt);
//        TextView name = (TextView) row.findViewById(R.id.nameTxt);
//        TextView playerPosition = (TextView) row.findViewById(R.id.positionTxt);
//        TextView playedGame = (TextView) row.findViewById(R.id.playedGameTxt);
//        TextView goal = (TextView) row.findViewById(R.id.goalTxt);
//        TextView joinUnited = (TextView) row.findViewById(R.id.joinUnitedTxt);
//        TextView transferFee = (TextView) row.findViewById(R.id.transferfeeTxt);
//        TextView beforeUnited = (TextView) row.findViewById(R.id.beforeUnitedTxt);
//        TextView unitedDebut = (TextView) row.findViewById(R.id.debutTxt);
//        TextView country = (TextView) row.findViewById(R.id.countryTxt);
//        TextView introduction = (TextView) row.findViewById(R.id.introductionTxt);
//
//        backNum.setText(data.getBackNum()+"");
//        name.setText(data.getName());
//        playerPosition.setText(data.getPosition());
//        playedGame.setText(data.getPlayedGame()+"");
//        goal.setText(data.getGoal()+"");
//        joinUnited.setText(data.getJoinUnited());
//        transferFee.setText(data.getTransferFee());
//        beforeUnited.setText(data.getBeforeUnited());
//        unitedDebut.setText(data.getUnitedDebut());
//        country.setText(data.getCountry());
//        introduction.setText(data.getIntroduction());

        return row;
    }

}

