package main.ru.mephi.java.part6.task14;

import java.util.ArrayList;

public class Close {
    public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems) throws Exception {
        Exception ex = null;
        for (T elem : elems) {
            try {
                elem.close();
            } catch (Exception e) {
                if (ex == null) {
                    ex = e;
                } else {
                    ex = new Exception(e.getMessage(), ex);
                }
            }
        }
        if (ex != null) {
            throw ex;
        }
    }
}
