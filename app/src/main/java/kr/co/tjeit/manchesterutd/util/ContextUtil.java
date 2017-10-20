package kr.co.tjeit.manchesterutd.util;

import android.content.Context;
import android.content.SharedPreferences;

import kr.co.tjeit.manchesterutd.data.user.User;

/**
 * Created by the on 2017-09-06.
 */

public class ContextUtil {

    private static User loginUser = null;

    private final static String prefName = "manchester";
    private final static String USER_ID = "UESR_ID";
    private final static String USER_NICK_NAME = "USER_NICK_NAME";
    private final static String USER_NAME = "USER_NAME";
    private final static String USER_PASSWORD = "USER_PASSWORD";
    private final static String USER_PROFILE_URL = "USER_PROFILE_URL";
    private final static String USER_MAIL_ADDRESS = "USER_MAIL_ADDRESS";
    private final static String USER_PHONE_NUM = "USER_PHONE_NUM";



    public static void logout(Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        pref.edit().putString(USER_ID, "").commit();
        pref.edit().putString(USER_NICK_NAME, "").commit();
        pref.edit().putString(USER_NAME, "").commit();
        pref.edit().putString(USER_PROFILE_URL, "").commit();
        pref.edit().putString(USER_PASSWORD,"").commit();
        pref.edit().putString(USER_MAIL_ADDRESS,"").commit();
        pref.edit().putString(USER_PHONE_NUM,"").commit();

        loginUser = null;


    }

    public static void login(Context context, User loginUser) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        pref.edit().putString(USER_ID, loginUser.getUserId()).commit();
        pref.edit().putString(USER_NICK_NAME, loginUser.getNickName()).commit();
        pref.edit().putString(USER_NAME, loginUser.getName()).commit();
        pref.edit().putString(USER_PROFILE_URL, loginUser.getProfileImgURL()).commit();
        pref.edit().putString(USER_PASSWORD, loginUser.getPassword()).commit();
        pref.edit().putString(USER_MAIL_ADDRESS, loginUser.getEmailAddress()).commit();
        pref.edit().putString(USER_PHONE_NUM, loginUser.getPhoneNum()).commit();
    }

    public static User getLoginUser(Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        if (pref.getString(USER_ID, "").equals("")) {
//            로그인이 안된 상태
            loginUser = null;
        }

        else {
            loginUser = new User();
            loginUser.setUserId(pref.getString(USER_ID, ""));
            loginUser.setUserId(pref.getString(USER_NICK_NAME, ""));
            loginUser.setName(pref.getString(USER_NAME, ""));
            loginUser.setPassword(pref.getString(USER_PASSWORD,""));
            loginUser.setProfileImgURL(pref.getString(USER_PROFILE_URL, ""));
            loginUser.setEmailAddress(pref.getString(USER_MAIL_ADDRESS, ""));
            loginUser.setPhoneNum(pref.getString(USER_PHONE_NUM, ""));
        }
        return loginUser;
    }
}
