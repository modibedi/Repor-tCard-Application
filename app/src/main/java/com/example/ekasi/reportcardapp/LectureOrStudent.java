package com.example.ekasi.reportcardapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class LectureOrStudent extends AppCompatActivity {
    Button btnLecture;
    Button btnStudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_or_student);
        btnLecture = (Button)findViewById(R.id.lecture);
        btnStudent = (Button)findViewById(R.id.student);
    }
    public void StartActivityLecture(View view) {
        Intent objIntent1 = new Intent(LectureOrStudent.this,Login_menu.class);
        startActivity(objIntent1);
    }


    public void StartActivityStudent_login_menu(View view) {
        Intent objIntent1 = new Intent(LectureOrStudent.this, Student_login_menu.class);
        startActivity(objIntent1);
    }




}
