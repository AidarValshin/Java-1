package ru.mephi.java.part3.task8;

//Implement a class Greeter that implements Runnable and whose run method
//prints n copies of "Hello, " + target, where n and target are set in the
//constructor. Construct two instances with different messages and execute them
//concurrently in two threads.
public class Great implements Runnable {
    private final String target;
    private final int n;

    public Great(String target, int n) {
        this.target = target;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.println("Hello, " + target);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}