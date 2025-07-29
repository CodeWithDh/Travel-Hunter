package com.women.womensaftey.Model;

public class Blog_Model {
    String blog_city_name;
    String blog_date;
    String blog_details;
    String blog_title;
    int image;

    public Blog_Model(int image2, String blog_city_name2, String blog_title2, String blog_details2, String blog_date2) {
        this.image = image2;
        this.blog_city_name = blog_city_name2;
        this.blog_title = blog_title2;
        this.blog_details = blog_details2;
        this.blog_date = blog_date2;
    }

    public String getBlog_details() {
        return this.blog_details;
    }

    public void setBlog_details(String blog_details2) {
        this.blog_details = blog_details2;
    }

    public int getImage() {
        return this.image;
    }

    public void setImage(int image2) {
        this.image = image2;
    }

    public String getBlog_city_name() {
        return this.blog_city_name;
    }

    public void setBlog_city_name(String blog_city_name2) {
        this.blog_city_name = blog_city_name2;
    }

    public String getBlog_title() {
        return this.blog_title;
    }

    public void setBlog_title(String blog_title2) {
        this.blog_title = blog_title2;
    }

    public String getBlog_date() {
        return this.blog_date;
    }

    public void setBlog_date(String blog_date2) {
        this.blog_date = blog_date2;
    }
}