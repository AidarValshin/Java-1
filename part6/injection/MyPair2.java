package main.ru.mephi.java.part6.injection;

import main.ru.mephi.java.part6.Additionally.Pair;

@TryInject
public class MyPair2 extends Pair<Object,Number> {
    public MyPair2(Object v1, Number v2) {
        super(v1, v2);
    }
}
