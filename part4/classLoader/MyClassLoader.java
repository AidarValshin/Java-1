package ru.mephi.java.part4.classLoader;
// my own simple class loader

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {
    private String pathtobin;

    public MyClassLoader(String pathtobin, ClassLoader parent) {
        super(parent);
        this.pathtobin = pathtobin;
    }

    @Override
    public Class findClass(String name) throws ClassNotFoundException {
        Class result;
        byte[] bytes = new byte[0];
        try {
            bytes = loadClassFromFile(name);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        result = defineClass(bytes, 0, bytes.length);
        if (result == null) {
            throw new ClassNotFoundException();
        }
        return result;
    }


    private byte[] loadClassFromFile(String fileName) throws IOException {
        String newName = fileName.replace(".", "/");
        newName = newName + ".class";
        Path path = Paths.get(pathtobin + newName);
        byte[] res = Files.readAllBytes(path);
        return res;
    }
}
