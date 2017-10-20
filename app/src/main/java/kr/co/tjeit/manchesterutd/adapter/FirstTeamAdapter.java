package kr.co.tjeit.manchesterutd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

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


}
