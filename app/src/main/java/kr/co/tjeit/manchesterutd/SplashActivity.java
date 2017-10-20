package kr.co.tjeit.manchesterutd;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kr.co.tjeit.manchesterutd.util.GlobalData;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);
                finish();

            }
        }, 2000);

    }

    @Override
    public void setValues() {
        GlobalData.initGlobalData();
    }

    @Override
    public void bindViews() {

    }
}
