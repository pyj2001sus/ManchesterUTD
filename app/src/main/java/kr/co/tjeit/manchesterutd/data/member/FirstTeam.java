package kr.co.tjeit.manchesterutd.data.member;

import android.widget.ImageView;

import java.io.Serializable;
import java.net.URL;

/**
 * Created by the on 2017-10-20.
 */

public class FirstTeam implements Serializable {

    private int backNum;
    private String name;
    private String position;
    private int playedGame;
    private int goal;
    private String joinUnited;
    private String transferFee;
    private String beforeUnited;
    private String unitedDebut;
    private String country;
    private String playerImgURL;
    private String introduction;

    public FirstTeam() {
    }

    public FirstTeam(int backNum, String name, String position, int playedGame, int goal, String joinUnited, String transferFee, String beforeUnited, String unitedDebut, String country, String playerImgURL, String introduction) {
        this.backNum = backNum;
        this.name = name;
        this.position = position;
        this.playedGame = playedGame;
        this.goal = goal;
        this.joinUnited = joinUnited;
        this.transferFee = transferFee;
        this.beforeUnited = beforeUnited;
        this.unitedDebut = unitedDebut;
        this.country = country;
        this.playerImgURL = playerImgURL;
        this.introduction = introduction;
    }

    public int getBackNum() {
        return backNum;
    }

    public void setBackNum(int backNum) {
        this.backNum = backNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getPlayedGame() {
        return playedGame;
    }

    public void setPlayedGame(int playedGame) {
        this.playedGame = playedGame;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public String getJoinUnited() {
        return joinUnited;
    }

    public void setJoinUnited(String joinUnited) {
        this.joinUnited = joinUnited;
    }

    public String getTransferFee() {
        return transferFee;
    }

    public void setTransferFee(String transferFee) {
        this.transferFee = transferFee;
    }

    public String getBeforeUnited() {
        return beforeUnited;
    }

    public void setBeforeUnited(String beforeUnited) {
        this.beforeUnited = beforeUnited;
    }

    public String getUnitedDebut() {
        return unitedDebut;
    }

    public void setUnitedDebut(String unitedDebut) {
        this.unitedDebut = unitedDebut;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
