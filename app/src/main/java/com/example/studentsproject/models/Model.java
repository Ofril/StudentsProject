package com.example.studentsproject.models;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();

    public static Model instance(){
        return _instance;
    }

    private Model(){
        for(int i = 0; i < 10; i++){
            addStudent(new Student("" + i,"name " + i,"052538164" + i,"Tel Aviv " + i, true));
        }
    }

    List<Student> data = new LinkedList<>();

    public List<Student> getAllStudents(){
        return data;
    }

    public void addStudent(Student student) {
        data.add(student);
    }

    public void deleteStudent(int pos) {
        data.remove(pos);
    }
}
