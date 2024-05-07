package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    ImageView homeIcon, searchIcon, cartIcon, settingsIcon, logoutIcon, productsIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        // Initialize ImageView references
        homeIcon = findViewById(R.id.home_img);
        searchIcon = findViewById(R.id.search);
        cartIcon = findViewById(R.id.cart);
        settingsIcon = findViewById(R.id.settings);
        logoutIcon = findViewById(R.id.logout);
        productsIcon = findViewById(R.id.product);

        // Set OnClickListener for each icon
       /* homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click event for the home icon
                // For example, navigate to the Home activity
                Intent intent = new Intent(HomePage.this, Product.class);
                startActivity(intent);
            }
        });
*/
        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click event for the search icon
                // For example, navigate to the Search activity
                Intent intent = new Intent(HomePage.this, SearchPage.class);
                startActivity(intent);
            }
        });

        cartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click event for the cart icon
                // For example, navigate to the Cart activity
                Intent intent = new Intent(HomePage.this, CartPage.class);
                startActivity(intent);
            }
        });

        settingsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click event for the settings icon
                // For example, navigate to the Settings activity
               Toast.makeText(HomePage.this, "Settings", Toast.LENGTH_SHORT).show();
            }
        });

        logoutIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click event for the logout icon
                // For example, log out the user and navigate to the Login activity
                Intent intent = new Intent(HomePage.this, LoginPage.class);
                startActivity(intent);
                finish(); // Close the current activity to prevent going back to it after logout
            }
        });

       /* productsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click event for the products icon
                // For example, navigate to the Products activity
                Intent intent = new Intent(HomePage.this, Product.class);
                startActivity(intent);
            }
        });*/
    }
}
