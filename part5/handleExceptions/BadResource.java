package main.ru.mephi.java.part5.handleExceptions;

public class BadResource implements AutoCloseable
{

    public void accessResource()
    {
        throw new RuntimeException("I wanted to access the resource ");
    }

    @Override
    public void close() throws NullPointerException
    {
        throw new NullPointerException("I wanted to close resource ");
    }
}