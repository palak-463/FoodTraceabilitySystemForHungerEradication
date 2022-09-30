package com.example.foodmanagement;

public class DisplayInfo {
    private String gname,qty,price;


    public DisplayInfo() {
    }

    public DisplayInfo(String gname, String qty, String price) {
        this.gname = gname;
        this.qty = qty;
        this.price = price;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
