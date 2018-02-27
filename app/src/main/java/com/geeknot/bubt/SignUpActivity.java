package com.geeknot.bubt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.geeknot.bubt.IntroSliderActivity.IntroSliderActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {

    Button loginAc;

    public  void loginActivity(){
        loginAc= (Button) findViewById(R.id.btn_login2);
        loginAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signr = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(signr);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final EditText name       = (EditText) findViewById(R.id.et_sign_up_username);
        final EditText email    = (EditText) findViewById(R.id.et_sign_up_email);
        final EditText pass      = (EditText) findViewById(R.id.et_sign_up_password);
        final EditText con_pass     = (EditText) findViewById(R.id.et_sign_up_password2);

        Button login= (Button) findViewById(R.id.btn_sign_up);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name1     = name.getText().toString();
                String email1     = email.getText().toString();
                String pass1   = pass.getText().toString();
                String pass2     = con_pass.getText().toString();

                if (TextUtils.isEmpty(name1)){
                    name.setError("Enter Your Name");
                    name.requestFocus();
                    return;
                }

                Boolean onError = false;
                if (!isValidEmail(email1)) {
                    onError = true;
                    email.setError("Invalid Email");
                    return;
                }

                if (TextUtils.isEmpty(pass1)){
                    pass.setError("Enter a Password");
                    pass.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(pass2)){
                    con_pass.setError("Confirm Your Password");
                    con_pass.requestFocus();
                    return;
                }

                Intent r = new Intent(SignUpActivity.this, IntroSliderActivity.class);
                startActivity(r);
            }
        });

        loginActivity();
    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
