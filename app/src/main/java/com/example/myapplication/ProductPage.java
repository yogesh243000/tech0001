package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_recycler_view); // Set content view to the layout containing RecyclerView

        // Get RecyclerView reference from layout
        RecyclerView recyclerView = findViewById(R.id.product_list);

        // Create a list of products (replace this with your actual list of products)
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Iphone", "Lovely", 10, R.drawable.avatar));
        productList.add(new Product("Product 2", "Description 2", 20, R.drawable.avatar));
        productList.add(new Product("Product 3", "Description 3", 30, R.drawable.avatar));
        // Add more products as needed

        // Create and set adapter for RecyclerView
        MyProductAdapter adapter = new MyProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);

        // Set layout manager for RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
