package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class PurchaseHistory {
    private static PurchaseHistory instance;
    private List<Purchase> purchases;

    // Private constructor to prevent instantiation
    private PurchaseHistory() {
        purchases = new ArrayList<>();
    }

    // Static method to get the singleton instance
    public static PurchaseHistory getInstance() {
        if (instance == null) {
            instance = new PurchaseHistory();
        }
        return instance;
    }

    // Method to add a purchase to the purchase history
    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

    // Method to get the list of purchases
    public List<Purchase> getPurchases() {
        return purchases;
    }
}
