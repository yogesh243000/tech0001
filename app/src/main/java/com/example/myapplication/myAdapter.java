package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myViewHolder> {
    private Context context;
    private List<Item> items;
    private int selectedItemPosition = RecyclerView.NO_POSITION; // Initially, no item is selected

    public myAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        Item currentItem = items.get(position);

        holder.nameView.setText(currentItem.getName());
        holder.emailView.setText(currentItem.getEmail());
        holder.imageView.setImageResource(currentItem.getImage());

        // Set item click listener to handle selection
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Deselect previously selected item (if any)
                int previousSelectedPosition = selectedItemPosition;
                selectedItemPosition = holder.getAdapterPosition();
                if (previousSelectedPosition != RecyclerView.NO_POSITION) {
                    notifyItemChanged(previousSelectedPosition);
                }

                // Update the selected item position
                selectedItemPosition = holder.getAdapterPosition();

                // Notify adapter to redraw items
                notifyDataSetChanged();
            }
        });

        // Update the UI based on the selection state
        if (position == selectedItemPosition) {
            // Item is selected, update UI accordingly (e.g., change background color)
            holder.itemView.setBackgroundColor(Color.GRAY);
        } else {
            // Item is not selected, reset UI to default (e.g., reset background color)
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
