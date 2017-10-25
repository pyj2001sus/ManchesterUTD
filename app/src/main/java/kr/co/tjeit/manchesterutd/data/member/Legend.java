package kr.co.tjeit.manchesterutd.data.member;

import java.io.Serializable;

/**
 * Created by the on 2017-10-25.
 */

public class Legend implements Serializable {

    private String name;
    private String birthDay;
    private String joinUnited;
    private String unitedDebut;
    private int allGoal;
    private int playedGame;
    private String position;
    private String playerImgURL;
    private String introduction;

    public Legend() {
    }

    public Legend(String name, String birthDay, String joinUnited, String unitedDebut, int allGoal, int playedGame, String position, String playerImgURL, String introduction) {
        this.name = name;
        this.birthDay = birthDay;
        this.joinUnited = joinUnited;
        this.unitedDebut = unitedDebut;
        this.allGoal = allGoal;
        this.playedGame = playedGame;
        this.position = position;
        this.playerImgURL = playerImgURL;
        this.introduction = introduction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getJoinUnited() {
        return joinUnited;
    }

    public void setJoinUnited(String joinUnited) {
        this.joinUnited = joinUnited;
    }

    public String getUnitedDebut() {
        return unitedDebut;
    }

    public void setUnitedDebut(String unitedDebut) {
        this.unitedDebut = unitedDebut;
    }

    public int getAllGoal() {
        return allGoal;
    }

    public void setAllGoal(int allGoal) {
        this.allGoal = allGoal;
    }

    public int getPlayedGame() {
        return playedGame;
    }

    public void setPlayedGame(int playedGame) {
        this.playedGame = playedGame;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPlayerImgURL() {
        return playerImgURL;
    }

    public void setPlayerImgURL(String playerImgURL) {
        this.playerImgURL = playerImgURL;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
