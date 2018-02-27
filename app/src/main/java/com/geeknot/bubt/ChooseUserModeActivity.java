package com.geeknot.bubt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseUserModeActivity extends Activity {

    Button std, tea;

    public  void studentActivity(){
        std= (Button)findViewById(R.id.btn_roadToStudent);
        std.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent std = new Intent(ChooseUserModeActivity.this, InfoStudentActivity.class);
                startActivity(std);

            }
        });
    }

    public void teacherActivity(){
        tea=(Button)findViewById(R.id.btn_roadToTeacher);
        tea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tea= new Intent(ChooseUserModeActivity.this, InfoTeacherActivity.class);
                startActivity(tea);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_user_mode);

        studentActivity();
        teacherActivity();
    }
}
