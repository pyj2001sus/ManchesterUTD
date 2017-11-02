package kr.co.tjeit.manchesterutd.data.user;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by the on 2017-09-05.
 */

public class User implements Serializable {

    private int id;
    private String userId;
    private String nickName;
    private String name;
    private String password;
    private String profileImgURL;
    private String emailAddress;
    private String phoneNum;

    public User() {
    }

    public User(int id, String userId, String nickName, String name, String password, String profileImgURL, String emailAddress, String phoneNum) {
        this.id = id;
        this.userId = userId;
        this.nickName = nickName;
        this.name = name;
        this.password = password;
        this.profileImgURL = profileImgURL;
        this.emailAddress = emailAddress;
        this.phoneNum = phoneNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileImgURL() {
        return profileImgURL;
    }

    public void setProfileImgURL(String profileImgURL) {
        this.profileImgURL = profileImgURL;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
