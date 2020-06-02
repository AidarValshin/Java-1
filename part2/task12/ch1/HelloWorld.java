package ru.mephi.java.part2.task12.ch01.sec01;

//Make a file HelloWorld.java that declares a class HelloWorld in a package
//ch01.sec01. Put it into some directory, but not in a ch01/sec01 subdirectory.
//From that directory, run javac HelloWorld.java. Do you get a class file?
//Where? Then run java HelloWorld. What happens? Why? (Hint: Run javap
//HelloWorld and study the warning message.) Finally, try javac -d .
//HelloWorld.java. Why is that better?
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println(" Hello ");
    }
}
/*
in cmd
cd IdeaProjects\Lec1a\src\main\java\ru\mephi\java\part2\task12\ch1
javac  HelloWorld.java  //find on the same directory
java  HelloWorld       //ind on the same directory, check package, package is different
javap  HelloWorld      //show errors of the previous command
javac -d . HelloWorld.java  // it is the same as the first

 */