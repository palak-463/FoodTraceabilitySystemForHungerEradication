package com.example.foodmanagement.restaurant;

public class RestaurantInfo {
    String name,qty,timep,timef,datep,datef;

    public RestaurantInfo() {
    }

    public RestaurantInfo(String name, String qty, String timep, String timef, String datep, String datef) {
        this.name = name;
        this.qty = qty;
        this.timep = timep;
        this.timef = timef;
        this.datep = datep;
        this.datef = datef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getTimep() {
        return timep;
    }

    public void setTimep(String timep) {
        this.timep = timep;
    }

    public String getTimef() {
        return timef;
    }

    public void setTimef(String timef) {
        this.timef = timef;
    }

    public String getDatep() {
        return datep;
    }

    public void setDatep(String datep) {
        this.datep = datep;
    }

    public String getDatef() {
        return datef;
    }

    public void setDatef(String datef) {
        this.datef = datef;
    }
}
