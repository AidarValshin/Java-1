package main.ru.mephi.java.part7.task14;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListView {
    public static List<Integer> immutableListView(List<Integer> list ) {
        return Collections.unmodifiableList(list);
    }

    public static void main(String[] args) {
        List<Integer> list= IntStream.rangeClosed(0, 10)
                .boxed().collect(Collectors.toList());
       // list.forEach(System.out::println);

        List<Integer> immutableView=immutableListView(list);
        immutableView.forEach(System.out::println);
      //  immutableView.add(123);
       Iterator<Integer> iterator= immutableView.iterator();
       iterator.next();
       //Z iterator.remove();
       // immutableView.remove(3);
    }
}
