package ru.mephi.java.part3.task1;

//Provide an interface Measurable with a method double getMeasure() that
//measures an object in some way. Make Employee implement Measurable.
//Provide a method double average(Measurable[] objects) that
//computes the average measure. Use it to compute the average salary of an array of
//employees.
public interface Measurable {
    double getMeasure();
}