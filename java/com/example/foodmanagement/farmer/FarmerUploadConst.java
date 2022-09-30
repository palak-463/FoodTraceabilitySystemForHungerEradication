package com.example.foodmanagement.farmer;

public class FarmerUploadConst {
    String gname,qty,price;

    public FarmerUploadConst() {

    }

    public FarmerUploadConst(String gname, String qty, String price) {
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
