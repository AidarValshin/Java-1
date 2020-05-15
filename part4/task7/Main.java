package ru.mephi.java.part4.task7;


public class Main {
    public static void main(String[] args) {
        for (Color c : Color.values()) {
            System.out.println(c.name() + ", red " + c.getRed() + ", green " + c.getGreen() + ", blue " + c.getBlue());
        }
    }
}

