package ru.mephi.java.part4.enums;

public enum Size1 {
    SMALL("S"), MEDIUM("M"), LARGE("L"),
    EXTRA_LARGE("XL");
    private final String abbreviation;

    Size1(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
