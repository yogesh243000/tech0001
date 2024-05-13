package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyProductViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageViewProduct;
    public TextView textViewProductName;
    public TextView textViewProductDescription;
    public TextView textViewProductPrice;
    public TextView textViewProductCount;

    public MyProductViewHolder(View itemView) {
        super(itemView);
        imageViewProduct = itemView.findViewById(R.id.imageViewProduct);
        textViewProductName = itemView.findViewById(R.id.textViewProductName);
        textViewProductDescription = itemView.findViewById(R.id.textViewProductDescription);
        textViewProductPrice = itemView.findViewById(R.id.textViewProductPrice);
        textViewProductCount = itemView.findViewById(R.id.textViewProductCount);
    }
}
