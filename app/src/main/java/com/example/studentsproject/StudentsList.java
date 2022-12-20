package com.example.studentsproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.studentsproject.models.Student;

public class StudentsList extends AppCompatActivity implements StudentAdapter.SelectedStudent {
    RecyclerView recyclerView;
    StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);

        handleRecyclerView();
        createAddStudentListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    private void createAddStudentListener() {
        findViewById(R.id.list_add_student_btn).setOnClickListener(view ->
                    startActivity((new Intent(StudentsList.this, AddStudent.class))));
    }

    private void handleRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        studentAdapter = new StudentAdapter(this);
        recyclerView.setAdapter(studentAdapter);
    }

    @Override
    public void selectedStudent(Student student, int pos) {
        Intent intent = new Intent(StudentsList.this, StudentDetails.class);
        startActivityWithStudent(intent, student, pos);
    }

    private void startActivityWithStudent(Intent intent, Student student, int pos) {
        intent.putExtra("student", student);
        intent.putExtra("pos", pos);
        startActivity(intent);
    }
}