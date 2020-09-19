package main.ru.mephi.java.part5.task8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

public class Wrapper<C> implements AutoCloseable {

    private final C inner;
    private final AutoCloseable function;

    private Wrapper(C inner, AutoCloseable function) {
        this.inner = inner;
        this.function = function;
    }

    public C getInner() {
        return inner;
    }

    @Override
    public void close() throws Exception {
        function.close();
    }

    public static <K> Wrapper wrap(K inner, AutoCloseable function) {
        return new Wrapper(inner, function);
    }

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/main/ru/mephi/resources/part5.ex1_1");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try (Wrapper ignored = Wrapper.wrap(reentrantLock, reentrantLock::unlock);
             Wrapper ignored2 = Wrapper.wrap(reentrantLock, reentrantLock::unlock);
             Wrapper fileInput = Wrapper.wrap(fileInputStream, fileInputStream::close)) {
            ((ReentrantLock) ignored.getInner()).lock();
            ((ReentrantLock) ignored2.getInner()).lock();
            System.out.println(reentrantLock.getHoldCount());  // 2  Queries the number of holds on this lock by the current thread.
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(reentrantLock.getHoldCount());  // 0
        try {
            fileInputStream.read();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


}
