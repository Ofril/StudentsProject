package com.example.studentsproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.studentsproject.models.Model;
import com.example.studentsproject.models.Student;

public class AddStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        createButtonsListeners();
    }

    private void createButtonsListeners() {
        View saveButton = findViewById(R.id.add_student_save_btn);
        View cancelButton = findViewById(R.id.add_student_cancel_btn);
        saveButton.setOnClickListener(view -> saveStudent());
        cancelButton.setOnClickListener(view -> finish());
    }

    private void saveStudent() {
        Student student = createStudent();
        Model.instance().addStudent(student);
        finish();
    }

    @NonNull
    private Student createStudent() {
        String id = ((EditText) findViewById(R.id.add_edit_id)).getText().toString();
        String name = ((EditText) findViewById(R.id.add_edit_name)).getText().toString();
        String phone = ((EditText) findViewById(R.id.add_edit_phone)).getText().toString();
        String address = ((EditText) findViewById(R.id.add_edit_address)).getText().toString();
        boolean isChecked = ((CheckBox)findViewById(R.id.add_student_checkbox)).isChecked();

        return new Student(id, name, phone, address, isChecked);
    }
}