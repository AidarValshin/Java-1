package main.ru.mephi.java.part5.task8;

import java.util.concurrent.locks.ReentrantLock;


public class LockWrapper extends ReentrantLock {

    public AutoCloseable lockResource() {
        lock();
        return this::unlock;
    }
}


