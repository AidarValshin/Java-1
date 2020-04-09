package ru.mephi.java.part2.task9;

/**
 * An <code>Car </code> object represents an car with
 * coordinate x , efficiency and number of gallons .
 * this class mutable because we need to change x and gallons values.
 *
 * @ author Valshin Aidar
 * @ version 1.1
 */
public class Car {
    private float efficiency;
    private float x;
    private float gallons;

    public Car(float efficiency) {
        this.efficiency = efficiency;
    }

    public void move(float x) {
        this.x += x;
        float takeGallons = Math.abs(x * efficiency);
        if (takeGallons < this.gallons) {
            this.gallons -= takeGallons;
        } else {
            System.out.println("You dont have enough gallons ");
        }
    }

    public void addFuel(float gallons) {
        this.gallons += gallons;
    }

    public float getEfficiency() {
        return efficiency;
    }

    public float getX() {
        return x;
    }

    public float getGallons() {
        return gallons;
    }
    // this class mutable because we need to change x and gallons values.
}
