package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CartPage extends AppCompatActivity {

    private TextView productNameTextView;
    private TextView productPriceTextView;
    private ImageView productImageView;
    private NumberPicker quantityPicker;

    Button CheckoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_activity);

        // Initialize views
        productNameTextView = findViewById(R.id.productName);
        productPriceTextView = findViewById(R.id.text_product_price);
        productImageView = findViewById(R.id.image_product);
        quantityPicker = findViewById(R.id.quantity_picker);
        CheckoutButton = findViewById(R.id.button_add_to_cart);




        // Retrieve product details from intent extras
        Intent intent = getIntent();
        if (intent != null) {
            String productName = intent.getStringExtra("productName");
            int productPrice = intent.getIntExtra("productPrice", 0);
            int productImage = intent.getIntExtra("productImage", 0);

            // Check if extras are not null before using them
            if (productName != null && productImage != 0) {
                // Display product details in the UI
                Log.d("CartPage", "Received product: " + productName); // Debug log
                productNameTextView.setText(productName);
                // Format the price as currency
                String formattedPrice = "Price: $" + productPrice;
                productPriceTextView.setText(formattedPrice);
                productImageView.setImageResource(productImage);

                // Set initial quantity value
                int initialQuantity = 1; // Default value
                quantityPicker.setValue(initialQuantity);

            } else {
                Log.e("CartPage", "Received invalid product data");
                // Show an error message to the user
                Toast.makeText(this, "Failed to load product details", Toast.LENGTH_SHORT).show();
                // Optionally, finish this activity or redirect the user
            }
        } else {
            Log.e("CartPage", "Intent is null");
            // Show an error message to the user
            Toast.makeText(this, "Failed to load product details", Toast.LENGTH_SHORT).show();
            // Optionally, finish this activity or redirect the user
        }
        CheckoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve product details
                String productName = productNameTextView.getText().toString();
                String productPriceStr = productPriceTextView.getText().toString();
                // Extract the price from the text (assuming the format is "Price: $X.XX")
                double productPrice = Double.parseDouble(productPriceStr.substring(productPriceStr.indexOf('$') + 1));

                // Create intent to start CheckoutActivity
                Intent intent = new Intent(CartPage.this, CheckoutActivity.class);
                intent.putExtra("productName", productName);
                intent.putExtra("productPrice", productPrice);
                startActivity(intent);
            }
        });

    }

    private void addToCart() {
        // Get the selected quantity from the NumberPicker
        int selectedQuantity = quantityPicker.getValue();

        // Retrieve product details from intent extras
        Intent intent = getIntent();
        if (intent != null) {
            String productName = intent.getStringExtra("productName");
            int productPrice = intent.getIntExtra("productPrice", 0);
            int productImage = intent.getIntExtra("productImage", 0);

            // Pass the product details along with the selected quantity to the next activity
            Intent cartIntent = new Intent();
            cartIntent.putExtra("productName", productName);
            cartIntent.putExtra("productPrice", productPrice);
            cartIntent.putExtra("productImage", productImage);
            cartIntent.putExtra("selectedQuantity", selectedQuantity);
            setResult(RESULT_OK, cartIntent);
            finish(); // Finish the current activity and return to the previous activity
        } else {
            Log.e("CartPage", "Intent is null");
            // Show an error message to the user
            Toast.makeText(this, "Failed to add item to cart", Toast.LENGTH_SHORT).show();
        }
    }


}
