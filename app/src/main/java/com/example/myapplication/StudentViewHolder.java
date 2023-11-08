package com.example.myapplication;

import android.media.TimedText;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    TextView studentName, studentAddress;
    MaterialButton deleteButton;
    ImageView studentImage;
    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        studentName = itemView.findViewById(R.id.student_name);
        studentAddress = itemView.findViewById(R.id.student_address);
        studentImage = itemView.findViewById(R.id.student_image);
        deleteButton = itemView.findViewById(R.id.delete_button);
    }
}
