package kr.co.tjeit.manchesterutd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import kr.co.tjeit.manchesterutd.util.ContextUtil;

public class MainActivity extends BaseActivity {

    private android.widget.ImageView homeBtn;
    private android.widget.ImageView searchBtn;
    private android.widget.ImageView contentBtn;
    private android.widget.ImageView likeBtn;
    private android.widget.ImageView myProfileBtn;
    private ImageView newsBtn;
    private ImageView scaduleBtn;
    private ImageView memberBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        myProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ContextUtil.getLoginUser(mContext) == null){
                    Intent intent = new Intent(mContext, LoginActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(mContext, MyProfileActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.myProfileBtn = (ImageView) findViewById(R.id.myProfileBtn);
        this.memberBtn = (ImageView) findViewById(R.id.memberBtn);
        this.scaduleBtn = (ImageView) findViewById(R.id.scaduleBtn);
        this.newsBtn = (ImageView) findViewById(R.id.newsBtn);
        this.homeBtn = (ImageView) findViewById(R.id.homeBtn);
    }
}
