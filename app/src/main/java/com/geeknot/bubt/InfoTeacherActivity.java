package com.geeknot.bubt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoTeacherActivity extends AppCompatActivity {

    Button teaToStd;

    public  void teacherToStudent(){
        teaToStd= (Button)findViewById(R.id.btn_teaToStd);
        teaToStd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tea = new Intent(InfoTeacherActivity.this, InfoStudentActivity.class);
                startActivity(tea);

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_teacher);

        teacherToStudent();
    }
}
