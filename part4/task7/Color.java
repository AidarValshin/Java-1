package ru.mephi.java.part4.task7;

//Define an enumeration type for the eight combinations of primary colors BLACK,
//RED, BLUE, GREEN, CYAN, MAGENTA, YELLOW, WHITE with methods getRed,
//getGreen, and getBlue.

public enum Color {
    BLACK(0, 0, 0), RED(255, 0, 0), BLUE(0, 0, 255),
    GREEN(0, 255, 0), CYAN(0, 255, 255), MAGENTA(255, 0, 255),
    YELLOW(255, 255, 0), WHITE(255, 255, 255);
    private int red;
    private int green;
    private int blue;

    Color(int r, int g, int b) {
        this.red = r;
        this.green = g;
        this.blue = b;
    }

    public int getRed() {
        return this.red;
    }

    public int getGreen() {
        return this.green;
    }

    public int getBlue() {
        return this.blue;
    }

}
