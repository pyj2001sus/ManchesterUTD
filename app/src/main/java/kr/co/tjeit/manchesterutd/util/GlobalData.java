package kr.co.tjeit.manchesterutd.util;


import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.manchesterutd.data.member.FirstTeam;

/**
 * Created by the on 2017-09-05.
 */

public class GlobalData {

    public static List<FirstTeam> firstTeams = new ArrayList<>();

    public static void initGlobalData() {
        firstTeams.clear();

        firstTeams.add(new FirstTeam(1, "데 헤아", "골키퍼", 269, 0, "2011년 7월 1일", null, "아틀레티코 마드리드",
                "2011년 8월 7일 v 맨시티(N)", "스페인", null));

    }
}
