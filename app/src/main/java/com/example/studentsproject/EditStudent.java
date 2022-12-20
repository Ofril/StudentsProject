package com.example.studentsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.studentsproject.models.Model;
import com.example.studentsproject.models.Student;

public class EditStudent extends AppCompatActivity {

    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            student = (Student) extras.get("student");
        }

        createButtonsListeners();
        insertTexts();
    }

    private void insertTexts() {
        ((EditText) findViewById(R.id.edit_edit_id)).setText(student.getId());
        ((EditText) findViewById(R.id.edit_edit_name)).setText(student.getName());
        ((EditText) findViewById(R.id.edit_edit_phone)).setText(student.getPhoneNumber());
        ((EditText) findViewById(R.id.edit_edit_address)).setText(student.getAddress());
        ((CheckBox) findViewById(R.id.edit_student_checkbox)).setChecked(student.isChecked());
    }

    private void createButtonsListeners() {
        View cancelButton = findViewById(R.id.edit_student_cancel_btn);
        View deleteButton = findViewById(R.id.edit_student_delete_btn);
        View saveButton = findViewById(R.id.edit_student_save_btn);
        cancelButton.setOnClickListener(view -> finish());
        deleteButton.setOnClickListener(view -> deleteStudent());
        saveButton.setOnClickListener(view -> updateStudent());
    }

    private void deleteStudent() {
        Model.instance().deleteStudent(student);
        Intent intent = new Intent(this, StudentsList.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void updateStudent() {
        int pos = Model.instance().getAllStudents().indexOf(student);
        student.setId(((EditText) findViewById(R.id.edit_edit_id)).getText().toString());
        student.setName(((EditText) findViewById(R.id.edit_edit_name)).getText().toString());
        student.setPhoneNumber(((EditText) findViewById(R.id.edit_edit_phone)).getText().toString());
        student.setAddress(((EditText) findViewById(R.id.edit_edit_address)).getText().toString());
        student.setChecked(((CheckBox) findViewById(R.id.edit_student_checkbox)).isChecked());
//        Model.instance().getAllStudents().set(pos, student);
        finish();
        Intent intent = new Intent(this, StudentsList.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}