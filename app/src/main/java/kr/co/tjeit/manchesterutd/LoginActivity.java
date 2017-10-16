package kr.co.tjeit.manchesterutd;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

    private android.widget.EditText emailEdt;
    private android.widget.EditText passEdt;
    private android.widget.Button loginBtn;
    private android.widget.Button signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, SignUpActivity.class);
                startActivity(intent);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (emailEdt.getText().toString().equals("")){
                    Toast.makeText(mContext, "이메일 주소를 입력해 주세요.", Toast.LENGTH_SHORT).show();
                }
                else if (passEdt.getText().toString().equals("")){
                    Toast.makeText(mContext, "비밀번호를 입력해 주세요.", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.signUpBtn = (Button) findViewById(R.id.signUpBtn);
        this.loginBtn = (Button) findViewById(R.id.loginBtn);
        this.passEdt = (EditText) findViewById(R.id.passEdt);
        this.emailEdt = (EditText) findViewById(R.id.emailEdt);
    }
}
