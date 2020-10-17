package main.ru.mephi.java.part5.task8;

public interface AutoCloseableWrapper extends AutoCloseable {

    @Override
    void close();
}