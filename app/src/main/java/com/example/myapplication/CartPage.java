package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends AppCompatActivity {
    Button btnCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_activity);
        btnCart = findViewById(R.id.btn_place_order);
        RecyclerView recyclerView = findViewById(R.id.recycler_view_cart);

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Cart11", "cart@gmail.com", R.drawable.abc));
        items.add(new Item("Cart22", "cart@gmail.com", R.drawable.abc));
        items.add(new Item("Cart33", "cart@gmail.com", R.drawable.abc));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new myAdapter(getApplicationContext(),items));

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartPage.this, CheckoutPage.class);
                startActivity(intent);
            }
        });
    }
}
