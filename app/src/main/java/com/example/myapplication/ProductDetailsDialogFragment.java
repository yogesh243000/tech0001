package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.myapplication.R;

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

        // Set text for TextViews using product details
        textViewName.setText(productName);
        textViewDescription.setText(productDescription);
        textViewPrice.setText(String.valueOf(productPrice)); // Convert int to String
        imageViewProduct.setImageResource(productImage);

        // Set the custom layout to the dialog builder
        builder.setView(view);
        return builder.create();
    }
}
