package com.example.sqlitetask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private final ArrayList<Student> studentList; // Marked as final

    // Constructor
    public StudentAdapter(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.tvName.setText(holder.itemView.getContext().getString(R.string.student_name, student.getFirstName(), student.getLastName())); // Use resource string
        holder.tvEmail.setText(student.getEmail());
        holder.tvPhone.setText(student.getPhone());
        holder.tvGender.setText(student.getGender());
        holder.tvBatch.setText(student.getBatch());
        holder.tvEnrollmentYear.setText(String.valueOf(student.getEnrollmentYear()));

        // Set department details if available
        Department dept = student.getDepartment();
        if (dept != null) {
            holder.tvDeptName.setText(dept.getDeptName());
            holder.tvFacultyHead.setText(dept.getFacultyHead());
        } else {
            holder.tvDeptName.setText("N/A");
            holder.tvFacultyHead.setText("N/A");
        }
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvEmail, tvPhone, tvGender, tvBatch, tvEnrollmentYear, tvDeptName, tvFacultyHead;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvBatch = itemView.findViewById(R.id.tvBatch);
            tvEnrollmentYear = itemView.findViewById(R.id.tvEnrollmentYear);
            tvDeptName = itemView.findViewById(R.id.tvDeptName);
            tvFacultyHead = itemView.findViewById(R.id.tvFacultyHead);
        }
    }
}
