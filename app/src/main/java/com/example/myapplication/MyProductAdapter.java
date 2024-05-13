package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyProductAdapter extends RecyclerView.Adapter<MyProductViewHolder> {
    private Context context;
    private List<Product> productList;

    public MyProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public MyProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home2, parent, false);
        return new MyProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyProductViewHolder holder, int position) {
        Product product = productList.get(position);

        // Bind data to views in the ViewHolder
        holder.imageViewProduct.setImageResource(product.getProductImage());
        holder.textViewProductName.setText(product.getProductName());
        holder.textViewProductDescription.setText(product.getProductDescription());
        holder.textViewProductPrice.setText(String.valueOf(product.getProductPrice())); // Convert int to String
        holder.textViewProductCount.setText("Selected: " + product.getSelectedCount()); // Set the selected count

        // Set click listener for the item view
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the dialog when item is clicked
                showProductDetailsDialog(product);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    private void showProductDetailsDialog(Product product) {
        // Create and show the dialog fragment with product details
        ProductDetailsDialogFragment dialogFragment = new ProductDetailsDialogFragment(product.getProductName(), product.getProductDescription(), product.getProductPrice(), product.getProductImage(), product.getSelectedCount());
        dialogFragment.show(((AppCompatActivity) context).getSupportFragmentManager(), "ProductDetailsDialogFragment");
    }

}
