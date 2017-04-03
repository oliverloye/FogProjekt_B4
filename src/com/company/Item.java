package com.company;

public class Item {
    String itemCode;
    String name;
    double rate;
    int quantity;

    public Item(String itemCode, String name, double rate, int quantity) {
        this.name = name;
        this.rate = rate;
        this.quantity = quantity;
        this.itemCode = itemCode;
    }
}
