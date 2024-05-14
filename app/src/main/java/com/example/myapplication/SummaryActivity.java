package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary_activity);

        // Retrieve data from intent extras
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String fullName = extras.getString("fullName");
            String address = extras.getString("address");
            String phone = extras.getString("phone");
            String email = extras.getString("email");
            String productName = extras.getString("productName");
            double productPrice = extras.getDouble("productPrice");

            // Display data in TextViews
            TextView textName = findViewById(R.id.textName1);
            TextView textEmail = findViewById(R.id.textEmail1);
            TextView textPhone = findViewById(R.id.text_phone2);
            TextView textAddress = findViewById(R.id.text_address1);
            TextView textProduct = findViewById(R.id.text_product1);
            TextView textPrice = findViewById(R.id.text_price1);

            textName.setText("Name: " + fullName);
            textEmail.setText("Email: " + email);
            textPhone.setText("Phone: " + phone);
            textAddress.setText("Address: " + address);
            textProduct.setText("Product Name: " + productName);
            textPrice.setText("Price: $" + productPrice);

            // Save the purchase in the purchase history
            Purchase purchase = new Purchase(fullName, address, phone, email, productName, productPrice);
            PurchaseHistory.getInstance().addPurchase(purchase);
        }

    }

    public void backToHome(View view) {
        Intent intent = new Intent(this, ProductPage.class);
        startActivity(intent);
        // Finish the SummaryActivity to remove it from the back stack
        finish();
    }
}
