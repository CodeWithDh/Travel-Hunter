package com.women.womensaftey.Model;

public class Hotel_Street_Model {
    String address;
    String contact;
    int image;
    String name;
    String timing;

    public Hotel_Street_Model(int image2, String name2, String address2, String contact2, String timing2) {
        this.image = image2;
        this.name = name2;
        this.address = address2;
        this.contact = contact2;
        this.timing = timing2;
    }

    public int getImage() {
        return this.image;
    }

    public void setImage(int image2) {
        this.image = image2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address2) {
        this.address = address2;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact2) {
        this.contact = contact2;
    }

    public String getTiming() {
        return this.timing;
    }

    public void setTiming(String timing2) {
        this.timing = timing2;
    }
}