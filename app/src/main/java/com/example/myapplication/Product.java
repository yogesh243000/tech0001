package com.example.myapplication;

public class Product {
    String ProductName;
    String ProductDescription;
    String ProductPrice;
    int ProductImage;
    private int selectedCount;
    public Product(String productName, String productDescription, String productPrice, int productImage) {
        ProductName = productName;
        ProductDescription = productDescription;
        ProductPrice = "$" + productPrice;
        ProductImage = productImage;
        this.selectedCount = selectedCount;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }

    public int getProductImage() {
        return ProductImage;
    }
    public int getSelectedCount() {
        return selectedCount;
    }


    public void setSelectedCount(int selectedCount) {
        this.selectedCount = selectedCount;
    }
}

