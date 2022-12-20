package com.example.studentsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.studentsproject.models.Student;

public class StudentDetails extends AppCompatActivity {

    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            student = (Student) extras.get("student");
        }

        insertTexts();
        createEditStudentListener();
    }

    private void createEditStudentListener() {
        findViewById(R.id.details_student_edit_btn).setOnClickListener(view ->
        {
            Intent intent = new Intent(this, EditStudent.class);
            startActivityWithStudent(intent, student);
        });
    }

    private void startActivityWithStudent(Intent intent, Student student) {
        intent.putExtra("student", student);
        startActivity(intent);
    }

    private void insertTexts() {
        ((TextView) findViewById(R.id.details_details_id)).setText(student.getId());
        ((TextView) findViewById(R.id.details_details_name)).setText(student.getName());
        ((TextView) findViewById(R.id.details_details_phone)).setText(student.getPhoneNumber());
        ((TextView) findViewById(R.id.details_details_address)).setText(student.getAddress());
        ((CheckBox) findViewById(R.id.details_student_checkbox)).setChecked(student.isChecked());
    }
}