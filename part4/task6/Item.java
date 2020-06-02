package ru.mephi.java.part4.task6;

//Suppose that in Section 4.2.2, “The equals Method,” on p. 140, the
//Item.equals method uses an instanceof test. Implement
//DiscountedItem.equals so that it compares only the superclass if
//otherObject is an Item, but also includes the discount if it is a
//DiscountedItem. Show that this method preserves symmetry but fails to be
//transitive—that is, find a combination of items and discounted items so that
//x.equals(y) and y.equals(z), but not x.equals(z).

import java.util.Objects;

public class Item {
    private String description;
    private double price;

    public Item(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public boolean equals(Object otherObject) {

        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (!(otherObject instanceof Item)) return false;

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