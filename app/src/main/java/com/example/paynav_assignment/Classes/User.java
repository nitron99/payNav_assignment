package com.example.paynav_assignment.Classes;

public class User {
    private String name;
    private String upiID;

    public User(String name, String upiID, String image) {
        this.name = name;
        this.upiID = upiID;
        this.image = image;
    }

    public User(String name) {
        this.name = name;
    }

    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpiID() {
        return upiID;
    }

    public void setUpiID(String upiID) {
        this.upiID = upiID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
