package com.example.myapplication.Models;

import androidx.annotation.NonNull;

public class Student {
    private String imageUrl, name, address;

    public String getAddress() {
        return address;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String imageUrl, String name, String address) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.address = address;
    }

    public Student() {
    }

    @NonNull
    @Override
    public String toString() {
        return "Students{" +
                "imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
