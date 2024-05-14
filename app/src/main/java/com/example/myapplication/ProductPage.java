package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MyProductAdapter;
import com.example.myapplication.Product;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyProductAdapter adapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_recycler_view);

        // Get RecyclerView reference from layout
        recyclerView = findViewById(R.id.search_results);

        // Create a list of products
        productList = new ArrayList<>();
        productList.add(new Product("Iphone 15 Pro Max", "Your new iPhone 15 Pro Max.\n" +
                "Just the way you want it.\n iPhone 15 Pro Max 256GB Blue Titanium", "2199", R.drawable.iphone));
        productList.add(new Product("Samsung S24 ultra", "Titanium\n" +
                "Violet \n" +
                "256GB \n" +
                "Android 14 operating system. With an enhanced cooling system on the Galaxy S24 Ultra, experience bigger and better performance with a processor that works hard so you can game harder", "1999", R.drawable.samsung));
        productList.add(new Product("Macbook Pro", "Apple M3 chip with 8-core CPU, 10-core GPU and 16-core Neural Engine\n" +
                "8GB unified memory\n" +
                "512GB SSD storage\n","2499" , R.drawable.mac));
        productList.add(new Product("Samsung S24", "Lovely ko bau", "2187", R.drawable.avatar));
        productList.add(new Product("Samsung S24", "Lovely ko bau", "2187", R.drawable.avatar));

        productList.add(new Product("Samsung S24", "Lovely ko bau", "2187", R.drawable.avatar));

        // Create and set adapter for RecyclerView
        adapter = new MyProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);

        // Set layout manager for RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get reference to the search bar
        EditText searchBar = findViewById(R.id.search_bar);

        // Implement text change listener for search bar
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    // Method to filter products based on search query
    // Method to filter products based on search query
    private void filter(String text) {
        List<Product> filteredList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getProductName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(product);
            }
        }
        adapter.filterList(filteredList); // Update RecyclerView with filtered list
    }

}
