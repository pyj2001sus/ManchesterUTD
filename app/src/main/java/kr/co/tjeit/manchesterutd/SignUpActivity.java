package kr.co.tjeit.manchesterutd;

import android.content.Context;
import android.content.Intent;
import android.icu.math.MathContext;
import android.icu.util.IslamicCalendar;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kr.co.tjeit.manchesterutd.data.user.User;
import kr.co.tjeit.manchesterutd.util.ServerUtil;

public class SignUpActivity extends BaseActivity {

    List<User> user = new ArrayList<>();
    boolean isIdDupl = true;

    private android.widget.EditText idEdt;
    private android.widget.EditText passEdt;
    private android.widget.EditText confirmPassEdt;
    private android.widget.EditText nameEdt;
    private android.widget.EditText nickNameEdt;
    private android.widget.EditText emailEdt;
    private android.widget.EditText phoneNumEdt;
    private android.widget.Button signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        idEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                        타이핑이 되는 매 순간마다, 중복 검사를 통과 못한것으로 변경
                isIdDupl = true;
                Log.d("아이디값변경", s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isIdOk = !idEdt.getText().toString().equals("");
                boolean isPassOk = !passEdt.getText().toString().equals("");
                boolean isConfirmPassOk = !confirmPassEdt.getText().toString().equals("");
                boolean isNameOk = !nameEdt.getText().toString().equals("");
                boolean isNickNameOk = !nickNameEdt.getText().toString().equals("");
                boolean isEmailOk = !emailEdt.getText().toString().equals("");
                boolean isPhoneNumOk = !phoneNumEdt.getText().toString().equals("");

                if (!isIdOk) {
                    Toast.makeText(mContext, "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!isPassOk) {
                    Toast.makeText(mContext, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!isConfirmPassOk || !confirmPassEdt.getText().toString().equals(passEdt.getText().toString())) {
                    Toast.makeText(mContext, "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!isNameOk) {
                    Toast.makeText(mContext, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!isNickNameOk) {
                    Toast.makeText(mContext, "닉네임을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!isEmailOk) {
                    Toast.makeText(mContext, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!isPhoneNumOk) {
                    Toast.makeText(mContext, "전화번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (isIdOk && isPassOk && isConfirmPassOk && isNameOk && isNickNameOk && isEmailOk && isPhoneNumOk){
                    Intent intent = new Intent(mContext, MainActivity.class);
                    startActivity(intent);
                }

                ServerUtil.sign_up(mContext,
                        idEdt.getText().toString(),
                        nameEdt.getText().toString(),
                        passEdt.getText().toString(),
                        nickNameEdt.getText().toString(),
                        emailEdt.getText().toString(),
                        phoneNumEdt.getText().toString(), new ServerUtil.JsonResponseHandler() {

                            @Override
                            public void onResponse(JSONObject json) {
                                try {
                                    if (json.getBoolean("result")) {
                                        Toast.makeText(mContext, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                                        Intent myIntent = new Intent(SignUpActivity.this, MainActivity.class);

                                        startActivity(myIntent);

                                        finish();
                                    } else {
                                        Toast.makeText(mContext, "회원가입에 실패했습니다. 아이디 변경후에 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
            }
        });
    }


    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.signUpBtn = (Button) findViewById(R.id.signUpBtn);
        this.phoneNumEdt = (EditText) findViewById(R.id.phoneNumEdt);
        this.emailEdt = (EditText) findViewById(R.id.emailEdt);
        this.nickNameEdt = (EditText) findViewById(R.id.nickNameEdt);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
        this.confirmPassEdt = (EditText) findViewById(R.id.confirmPassEdt);
        this.passEdt = (EditText) findViewById(R.id.passEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
    }
}
