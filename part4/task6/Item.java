package ru.mephi.java.part4.task6;

import java.util.Objects;

public class Item {
    private String description;
    private double price;

    public Item(String description,double price){
        this.description = description;
        this.price = price;
    }
    public boolean equals(Object otherObject) {
// A quick test to see if the objects are identical
        if (this == otherObject) return true;
// Must return false if the parameter is null
        if (otherObject == null) return false;
// Check that otherObject is an Item
        if (!(otherObject instanceof Item)) return false;
// Test whether the instance variables have identical values
        Item other = (Item) otherObject;
        return Objects.equals(description, other.description)
                && price == other.price;
    }

}

class DiscountedItem extends Item {
    private double discount;

    public DiscountedItem(String description, double price, double discount) {
        super(description, price);
        this.discount = discount;
    }

    public boolean equals(Object otherObject) {
        if (otherObject instanceof DiscountedItem) {
            if (!super.equals(otherObject)) return false;
            DiscountedItem other = (DiscountedItem) otherObject;
            return discount == other.discount;
        } else {
            return super.equals(otherObject);
        }
    }

}