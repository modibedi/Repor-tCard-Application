package com.example.ekasi.reportcardapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Student extends AppCompatActivity {
Button btnstudent_login;
    Button btnstudent_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        btnstudent_login = (Button)findViewById(R.id.student_login);
        btnstudent_register = (Button) findViewById(R.id.student_register );


    }


    public void StartActivityStudentLogin(View view) {
        Intent objIntent1 = new Intent(Student.this, Student_LogIn.class);
        startActivity(objIntent1);
    }
}
