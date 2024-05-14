package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MyProductAdapter extends RecyclerView.Adapter<MyProductViewHolder> {
    private Context context;
    private List<Product> productList;
    private List<Product> filteredList; // New list to hold filtered products

    public MyProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
        this.filteredList = new ArrayList<>(productList); // Initialize filteredList with all products
    }

    @NonNull
    @Override
    public MyProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home2, parent, false);
        return new MyProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyProductViewHolder holder, int position) {
        Product product = filteredList.get(position); // Use filteredList instead of productList

        // Bind data to views in the ViewHolder
        holder.imageViewProduct.setImageResource(product.getProductImage());
        holder.textViewProductName.setText(product.getProductName());
        holder.textViewProductDescription.setText(product.getProductDescription());
        holder.textViewProductPrice.setText(product.getProductPrice());
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
        return filteredList.size(); // Use filteredList size instead of productList size
    }

    // Method to filter the list of products
    public void filterList(List<Product> filteredList) {
        this.filteredList = filteredList;
        notifyDataSetChanged(); // Notify RecyclerView of data change
    }

    private void showProductDetailsDialog(Product product) {
        // Assuming getProductPrice() returns a String representing the price with a dollar sign
        String priceString = product.getProductPrice().substring(1); // Remove the dollar sign
        try {
            int priceInt = Integer.parseInt(priceString); // Parse the price string to an int

            // Create and show the dialog fragment with product details
            ProductDetailsDialogFragment dialogFragment = new ProductDetailsDialogFragment(product.getProductName(), product.getProductDescription(), priceInt, product.getProductImage(), product.getSelectedCount());
            dialogFragment.show(((AppCompatActivity) context).getSupportFragmentManager(), "ProductDetailsDialogFragment");
        } catch (NumberFormatException e) {
            // Handle the case where the price string cannot be parsed to an int
            e.printStackTrace();
        }
    }
}
