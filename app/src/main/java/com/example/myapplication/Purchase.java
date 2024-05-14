package com.example.myapplication;

public class Purchase {
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private String productName;
    private double productPrice;

    // Constructor
    public Purchase(String fullName, String address, String phone, String email, String productName, double productPrice) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    // Getters and setters (if needed)
}
