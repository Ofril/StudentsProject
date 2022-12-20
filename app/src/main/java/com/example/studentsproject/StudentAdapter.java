package com.example.studentsproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentsproject.models.Model;
import com.example.studentsproject.models.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentsAdapterVh> {
    private List<Student> studentsList;
    private Context context;
    private SelectedStudent selectedStudent;

    public StudentAdapter(SelectedStudent selectedStudent) {
        updateStudentsFromModel();
        this.selectedStudent = selectedStudent;
    }

    public void updateStudentsFromModel() {
        this.studentsList = Model.instance().getAllStudents();
    }

    @NonNull
    @Override
    public StudentAdapter.StudentsAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        return new StudentsAdapterVh(LayoutInflater.from(context).inflate(R.layout.student_row, null));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsAdapterVh holder, int position) {
        Student student = studentsList.get(position);
        holder.id.setText(student.getId());
        holder.name.setText(student.getName());
        holder.checkBox.setChecked(student.isChecked());
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public interface SelectedStudent {
        void selectedStudent(Student student);
    }

    public class StudentsAdapterVh extends RecyclerView.ViewHolder {
        TextView id;
        TextView name;
        CheckBox checkBox;

        public StudentsAdapterVh(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            checkBox = itemView.findViewById(R.id.student_check_box);

            itemView.setOnClickListener(view -> selectedStudent.selectedStudent(studentsList.get(getAdapterPosition())));}
    }
}
