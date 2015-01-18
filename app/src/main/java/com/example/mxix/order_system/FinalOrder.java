package com.example.mxix.order_system;

/**
 * Created by MXIX on 17-Jan-15.
 */
public class FinalOrder {
    public String item="", quantity="",cost="";
    long customer_id;


    public String getitem() {
        return item;
    }

    public void setitem(String item) {
        this.item = item;
    }
    public String getquantity() {
        return quantity;
    }

    public void setquantityt(String quantity) {
        this.quantity = quantity;
    }
    public String getcost() {
        return cost;
    }

    public void setcost(String cost) {
        this.cost = cost;
    }
    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

}
