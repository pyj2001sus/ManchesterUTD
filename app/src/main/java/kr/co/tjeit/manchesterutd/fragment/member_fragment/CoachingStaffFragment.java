package kr.co.tjeit.manchesterutd.fragment.member_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.co.tjeit.manchesterutd.R;

/**
 * Created by the on 2017-10-18.
 */

public class CoachingStaffFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_coaching_staff, container, false);

        return v;
    }
}
