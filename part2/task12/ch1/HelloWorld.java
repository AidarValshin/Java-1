package ru.mephi.java.part2.task12.ch01.sec01;

public class HelloWorld {
    public  static void main(String[] args) {
        System.out.println(" Hello ");
    }
}
/*
делать в командной строке виндовс
cd IdeaProjects\Lec1a\src\main\java\ru\mephi\java\part2\task12\ch1
javac  HelloWorld.java  //находит в той же директории
java  HelloWorld       //находит в той же директории, обращается к пакету, а он указан другой
javap  HelloWorld      //показывает ошибки прошлой команды
javac -d . HelloWorld.java  // делает то же самое ,что и 1ая команда

 */