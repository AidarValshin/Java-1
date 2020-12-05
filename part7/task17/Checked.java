package main.ru.mephi.java.part7.task17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Checked {
    public static void main(String[] args) {
        List integerChecked= Collections.checkedList(new ArrayList<>(),Integer.class);
        List ints=new ArrayList();
        ints.add("sdf");
        integerChecked.add("sdf");
    }
}
