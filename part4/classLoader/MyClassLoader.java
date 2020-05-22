package ru.mephi.java.part4.classLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {

    @Override
    public Class findClass(String name) {
        byte[] bytes = new byte[0];
        try {
            bytes = loadClassFromFile(name);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return defineClass(bytes, 0, bytes.length);
    }

    private byte[] loadClassFromFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        byte[] res = Files.readAllBytes(path);
        return res;
    }
}
