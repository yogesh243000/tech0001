package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ProductDetailsDialogFragment extends DialogFragment {

    private String productName;
    private String productDescription;
    private int productPrice;
    private int productImage;
    private int selectedCount;

    public ProductDetailsDialogFragment(String productName, String productDescription, int productPrice, int productImage, int selectedCount) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.selectedCount = selectedCount;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Inflate the layout for the dialog
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_product_details, null);

        // Get references to TextViews and ImageView in the layout
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewDescription = view.findViewById(R.id.textViewDescription);
        TextView textViewPrice = view.findViewById(R.id.textViewPrice);
        ImageView imageViewProduct = view.findViewById(R.id.imageViewProduct);
        Button buttonAddToCart = view.findViewById(R.id.addToCartButton);
        ImageView closeButton = view.findViewById(R.id.closeButton);

        // Set text for TextViews using product details
        textViewName.setText(productName);
        textViewDescription.setText(productDescription);
        textViewPrice.setText(String.valueOf(productPrice)); // Convert int to String
        imageViewProduct.setImageResource(productImage);

        // Set click listener for the "Add to Cart" button
        buttonAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the action when the button is clicked
                // For example, you can add the product to the cart
                addToCart();
                dismiss();
            }
        });

        // Set click listener for the close button
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dismiss the dialog when the close button is clicked
                dismiss();
            }
        });

        // Set the custom layout to the dialog builder
        builder.setView(view);
        return builder.create();
    }

    private void addToCart() {
        // Create an intent to pass data to the CartPage activity
        Intent intent = new Intent(getContext(), CartPage.class);
        intent.putExtra("productName", productName);
        intent.putExtra("productPrice", productPrice);
        intent.putExtra("productImage", productImage);
        intent.putExtra("selectedCount", selectedCount);
        // Start the CartPage activity with a request code
        startActivityForResult(intent, 1);
    }

}