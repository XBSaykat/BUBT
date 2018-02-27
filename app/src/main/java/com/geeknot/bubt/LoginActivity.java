package com.geeknot.bubt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.geeknot.bubt.IntroSliderActivity.IntroSliderActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    Button signUpAc;

    public  void signUpActivity(){
        signUpAc= (Button) findViewById(R.id.btn_sign_up2);
        signUpAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signr = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(signr);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText email       = (EditText) findViewById(R.id.et_login_username);
        final EditText pass     = (EditText) findViewById(R.id.et_login_password);

        Button login= (Button) findViewById(R.id.btn_login_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email1     = email.getText().toString();
                String pass1   = pass.getText().toString();

                Boolean onError = false;
                if (!isValidEmail(email1)) {
                    onError = true;
                    email.setError("Invalid Email");
                    return;
                }

                if (TextUtils.isEmpty(pass1)){
                    pass.setError("Enter Your Password");
                    pass.requestFocus();
                    return;
                }

                Intent r = new Intent(LoginActivity.this, IntroSliderActivity.class);
                startActivity(r);
            }
        });

        signUpActivity();
    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
