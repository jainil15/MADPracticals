package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.Student;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    Context context;
    ArrayList<Student> students;

    public StudentAdapter(Context context, ArrayList<Student> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_practical5, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.studentName.setText(students.get(position).getName());
        holder.studentAddress.setText(students.get(position).getAddress());

        Picasso
                .get()
                .load(students.get(position).getImageUrl())
                .resize(300,300)
                .into(holder.studentImage);

        holder.deleteButton.setOnClickListener(view -> {
            students.remove(students.get(position));
            notifyDataSetChanged();
        });
    }
    @Override
    public int getItemCount() {
        return students.size();
    }
}
