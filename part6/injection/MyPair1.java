package main.ru.mephi.java.part6.injection;

import main.ru.mephi.java.part6.Additionally.Pair;

@TryInject
public class MyPair1 extends Pair<String,Number> {
    public MyPair1(String v1, Number v2) {
        super( v1, v2);
    }
}
