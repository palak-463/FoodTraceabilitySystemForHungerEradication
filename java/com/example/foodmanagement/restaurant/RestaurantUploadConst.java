package com.example.foodmanagement.restaurant;

public class RestaurantUploadConst {
    String name,qty,datep,timep,datef,timef;

    public RestaurantUploadConst() {
    }

    public RestaurantUploadConst(String name, String qty, String datep, String timep, String datef, String timef) {
        this.name = name;
        this.qty = qty;
        this.datep = datep;
        this.timep = timep;
        this.datef = datef;
        this.timef = timef;
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

    public String getDatep() {
        return datep;
    }

    public void setDatep(String datep) {
        this.datep = datep;
    }

    public String getTimep() {
        return timep;
    }

    public void setTimep(String timep) {
        this.timep = timep;
    }

    public String getDatef() {
        return datef;
    }

    public void setDatef(String datef) {
        this.datef = datef;
    }

    public String getTimef() {
        return timef;
    }

    public void setTimef(String timef) {
        this.timef = timef;
    }
}
