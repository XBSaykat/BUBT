package com.geeknot.bubt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class InfoStudentActivity extends AppCompatActivity {

    Button stdToTea;

    public  void studentToTeacher(){
        stdToTea= (Button)findViewById(R.id.btn_stdToTea);
        stdToTea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent std = new Intent(InfoStudentActivity.this, InfoTeacherActivity.class);
                startActivity(std);

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_student);

        studentToTeacher();

        final Spinner dept = findViewById(R.id.spinner_dept);
        String[] items_dept = new String[]{"Choose Dept.", "CSE", "BBA", "EEE", "LLB", "TEXTILE", "ARCHITECTURE"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items_dept);
        dept.setAdapter(adapter);

    }
}
