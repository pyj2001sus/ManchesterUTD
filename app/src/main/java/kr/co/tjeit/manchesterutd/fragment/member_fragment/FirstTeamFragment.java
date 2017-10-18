package kr.co.tjeit.manchesterutd.fragment.member_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import kr.co.tjeit.manchesterutd.R;
import kr.co.tjeit.manchesterutd.all_members.first_team.DeGea;
import kr.co.tjeit.manchesterutd.all_members.first_team.Lindelof;

/**
 * Created by the on 2017-10-18.
 */

public class FirstTeamFragment extends Fragment {

    private android.widget.LinearLayout degea;
    private android.widget.LinearLayout lindelof;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first_team, container, false);
        this.lindelof = (LinearLayout) v.findViewById(R.id.lindelof);
        this.degea = (LinearLayout) v.findViewById(R.id.de_gea);
        setupEvents();

        return v;
    }

    private void setupEvents() {
        degea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DeGea.class);
                startActivity(intent);
            }
        });

        lindelof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Lindelof.class);
                startActivity(intent);
            }
        });
    }


}
