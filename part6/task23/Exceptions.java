package main.ru.mephi.java.part6.task23;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

public class Exceptions {
    public static <V> V doWorkCast(Callable<V> c) {
        try {
            return c.call();
        } catch (Throwable ex) {
            throw (RuntimeException) ex;
        }
    }

    public static String readAllCast(Path path) {
        return doWorkCast(() -> new String(Files.readAllBytes(path)));
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable>
    void throwAs(Throwable e) throws T {
        throw (T) e; // The cast is erased to (Throwable) e
    }

    public static <V> V doWork(Callable<V> c) {
        try {
            return c.call();
        } catch (Throwable ex) {
            Exceptions.throwAs(ex);
            return null;
        }
    }

    public static String readAll(Path path) {
        return doWork(() -> new String(Files.readAllBytes(path)));
    }

    public static void main(String[] args) {
        //String bytes =readAllCast(Paths.get("Users\\ÂÀÐ\\IdeaProjects\\Term7\\src\\main\\ru\\mephi\\java\\part6\\task19\\Repeat.java"));
        String bytes = readAll(Paths.get("Users\\ÂÀÐ\\IdeaProjects\\Term7\\src\\main\\ru\\mephi\\java\\part6\\task19\\Repeat.java"));
        System.out.println(bytes);
    }
}
