package main.ru.mephi.java.part8.task4;

import java.util.stream.Stream;

public class InfiniteStream {

    public  static Stream<Long>  infinitiveRandomStream(long a, long c, long m, long seed){
        return Stream.iterate(seed,x->((a+(Long)x+c)%m));
    }

    public static void main(String[] args) {
        Stream<Long> stream = infinitiveRandomStream(25214903917L, 11,  248,0);
            stream.limit(5).forEach(System.out::println);
    }
}
