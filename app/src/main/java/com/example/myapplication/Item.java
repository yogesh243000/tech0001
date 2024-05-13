package com.example.myapplication;

public class Item {
    String name;
    String email;
    int image;
    boolean isSelected;

    public Item(String name, String email, int image) {
        this.name = name;
        this.email = email;
        this.image = image;
        this.isSelected = false;
    }
    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
