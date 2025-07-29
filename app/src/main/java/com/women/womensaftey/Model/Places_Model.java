package com.women.womensaftey.Model;

public class Places_Model {
    String Address;
    String Budget;
    String Crowd;
    String Discriptions;
    int image;
    String name;

    public Places_Model(int image2, String name2, String address, String crowd, String discriptions, String budget) {
        this.image = image2;
        this.name = name2;
        this.Address = address;
        this.Crowd = crowd;
        this.Discriptions = discriptions;
        this.Budget = budget;
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
        return this.Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getCrowd() {
        return this.Crowd;
    }

    public void setCrowd(String crowd) {
        this.Crowd = crowd;
    }

    public String getDiscriptions() {
        return this.Discriptions;
    }

    public void setDiscriptions(String discriptions) {
        this.Discriptions = discriptions;
    }

    public String getBudget() {
        return this.Budget;
    }

    public void setBudget(String budget) {
        this.Budget = budget;
    }
}