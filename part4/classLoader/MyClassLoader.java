package ru.mephi.java.part4.classLoader;
// my own simple class loader

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class MyClassLoader extends ClassLoader {
    private String pathtobin;
    private Map<String, Class> classesHash = new HashMap<>();

    public MyClassLoader(String pathtobin, ClassLoader parent) {
        super(parent);
        this.pathtobin = pathtobin;
    }

    @Override
    public Class findClass(String name) {
        Class result = classesHash.get(name);
        if (result != null) {
            return result;
        } else {
            byte[] bytes = new byte[0];
            try {
                String newName = name.replace(".", "/");
                newName = newName + ".class";
                bytes = loadClassFromFile(newName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            result = defineClass(bytes, 0, bytes.length);
            classesHash.put(name, result);
            return result;
        }
    }


    private byte[] loadClassFromFile(String fileName) throws IOException {
        Path path = Paths.get(pathtobin + fileName);
        byte[] res = Files.readAllBytes(path);
        return res;
    }
}
