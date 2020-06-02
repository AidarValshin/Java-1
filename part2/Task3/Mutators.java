package ru.mephi.java.part2.task3;

//Can you ever have a mutator method return something other than void? Can you
//ever have an accessor method return void? Give examples when possible.
public class Mutators {
    /*
    Can you ever have a mutator method return something other than void? - yes, for example previous or current state.
     Can you ever have an accessor method return void? - yes
     */
    private int i;

    public Mutators(int i) {
        this.i = i;
    }

    public void accessorMethod(int[] notArr) {
        notArr[0] = i;
    }

    public int mutatorMethod(int i) {
        this.i = i;
        return this.i;
    }
}

