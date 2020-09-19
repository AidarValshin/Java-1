package main.ru.mephi.java.part5.task8;

public class Program {
    public static void main(String[] args) {
        LockWrapper lock = new LockWrapper();

        try (AutoCloseable ignored = lock.lockResource();
             AutoCloseable ignored2 = lock.lockResource()) {
                System.out.println(lock.getHoldCount());  // 2  Queries the number of holds on this lock by the current thread.
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(lock.getHoldCount());  // 0
    }
}
