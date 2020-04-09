package ru.mephi.java.part2.task9;


public class Program {
    public static void main(String[] args) {
        Car car1 = new Car(0.5f);
        System.out.println("Gallons: " + car1.getGallons());
        car1.addFuel(100);
        System.out.println("Gallons: " + car1.getGallons());
        car1.move(20);
        System.out.println("Gallons: " + car1.getGallons());
        System.out.println("x: " + car1.getX());
        System.out.println("Efficiency: " + car1.getEfficiency());
        car1.move(-200);
    }
}
