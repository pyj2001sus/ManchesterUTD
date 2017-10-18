package kr.co.tjeit.manchesterutd;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
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
    private android.widget.FrameLayout homeFragment;
    private android.widget.FrameLayout newsFragment;
    private android.widget.FrameLayout scaduleFragment;
    private android.widget.FrameLayout memberFragment;

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

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeFragment.setVisibility(View.VISIBLE);
                newsFragment.setVisibility(View.GONE);
                scaduleFragment.setVisibility(View.GONE);
                memberFragment.setVisibility(View.GONE);
                homeBtn.setScaleX(1.2f);
                homeBtn.setScaleY(1.2f);
                newsBtn.setScaleX(1);
                newsBtn.setScaleY(1);
                scaduleBtn.setScaleX(1);
                scaduleBtn.setScaleY(1);
                memberBtn.setScaleX(1);
                memberBtn.setScaleY(1);
            }
        });

        newsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeFragment.setVisibility(View.GONE);
                newsFragment.setVisibility(View.VISIBLE);
                scaduleFragment.setVisibility(View.GONE);
                memberFragment.setVisibility(View.GONE);
                homeBtn.setScaleX(1);
                homeBtn.setScaleY(1);
                newsBtn.setScaleX(1.2f);
                newsBtn.setScaleY(1.2f);
                scaduleBtn.setScaleX(1);
                scaduleBtn.setScaleY(1);
                memberBtn.setScaleX(1);
                memberBtn.setScaleY(1);
            }
        });

        scaduleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeFragment.setVisibility(View.GONE);
                newsFragment.setVisibility(View.GONE);
                scaduleFragment.setVisibility(View.VISIBLE);
                memberFragment.setVisibility(View.GONE);
                homeBtn.setScaleX(1);
                homeBtn.setScaleY(1);
                newsBtn.setScaleX(1);
                newsBtn.setScaleY(1);
                scaduleBtn.setScaleX(1.2f);
                scaduleBtn.setScaleY(1.2f);
                memberBtn.setScaleX(1);
                memberBtn.setScaleY(1);
            }
        });

        memberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeFragment.setVisibility(View.GONE);
                newsFragment.setVisibility(View.GONE);
                scaduleFragment.setVisibility(View.GONE);
                memberFragment.setVisibility(View.VISIBLE);
                homeBtn.setScaleX(1);
                homeBtn.setScaleY(1);
                newsBtn.setScaleX(1);
                newsBtn.setScaleY(1);
                scaduleBtn.setScaleX(1);
                scaduleBtn.setScaleY(1);
                memberBtn.setScaleX(1.2f);
                memberBtn.setScaleY(1.2f);
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
        this.memberFragment = (FrameLayout) findViewById(R.id.memberFragment);
        this.scaduleFragment = (FrameLayout) findViewById(R.id.scaduleFragment);
        this.newsFragment = (FrameLayout) findViewById(R.id.newsFragment);
        this.homeFragment = (FrameLayout) findViewById(R.id.homeFragment);
    }
}
