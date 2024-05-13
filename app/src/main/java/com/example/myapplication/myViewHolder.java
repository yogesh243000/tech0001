package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myViewHolder extends RecyclerView.ViewHolder{
    ImageView imageView;
    TextView nameView, emailView;
    public myViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.img1);
        nameView = itemView.findViewById(R.id.name1);
        emailView = itemView.findViewById(R.id.email);
    }
}
