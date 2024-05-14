package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CheckoutActivity extends AppCompatActivity {

    private EditText fullNameEditText;
    private EditText addressEditText;
    private EditText phoneEditText;
    private EditText emailEditText;
    private Button proceedToPaymentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_activity);

        // Initialize views
        fullNameEditText = findViewById(R.id.edit_text_full_name);
        addressEditText = findViewById(R.id.edit_text_address);
        phoneEditText = findViewById(R.id.edit_text_phone);
        emailEditText = findViewById(R.id.edit_text_email);
        proceedToPaymentButton = findViewById(R.id.btn_proceed_to_payment);

        // Set click listener for the proceed button
        proceedToPaymentButton.setOnClickListener(v -> proceedToPayment());

        // Retrieve and set product details if available
        retrieveAndSetProductDetails();
    }

    private void proceedToPayment() {
        // Get user input from EditText fields
        String fullName = fullNameEditText.getText().toString().trim();
        String address = addressEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();

        // Retrieve product details from intent extras
        Intent intent = getIntent();
        if (intent != null) {
            String productName = intent.getStringExtra("productName");
            double productPrice = intent.getDoubleExtra("productPrice", 0.0);

            // Validate user input
            if (fullName.isEmpty() || address.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                // Show error message if any field is empty
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                // Proceed to summary page
                Intent summaryIntent = new Intent(CheckoutActivity.this, SummaryActivity.class);
                summaryIntent.putExtra("fullName", fullName);
                summaryIntent.putExtra("address", address);
                summaryIntent.putExtra("phone", phone);
                summaryIntent.putExtra("email", email);
                summaryIntent.putExtra("productName", productName); // Pass product name
                summaryIntent.putExtra("productPrice", productPrice); // Pass product price
                startActivity(summaryIntent);
            }
        }
    }


    private void retrieveAndSetProductDetails() {
        // Retrieve product details from intent extras
        Intent intent = getIntent();
        if (intent != null) {
            String productName = intent.getStringExtra("productName");
            double productPrice = intent.getDoubleExtra("productPrice", 0.0);
            // Set the product name as the activity title if available
            if (productName != null) {
                setTitle(productName);
            }
        }
    }
}
