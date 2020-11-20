package main.ru.mephi.java.part6.injection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GetAllClassesFromClassPaths {
    /**
     * @return list of all classes from ClassPath
     */
    public static List<Class<?>> getAllClasses() throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        List<File> classLocations = getClassLocationsForCurrentClasspath();
        for (File filesLocation : classLocations) {
            List<File> classFiles = listFiles(filesLocation);
            for (File file : classFiles) {
                classes.add(getClassFromFile(file, filesLocation));
            }
        }
        return classes;
    }

    private static List<File> getClassLocationsForCurrentClasspath() {
        List<File> urls = new ArrayList<>();
        String classPath = System.getProperty("java.class.path");
        if (classPath != null) {
            for (String path : classPath.split(File.pathSeparator)) {
                urls.add(new File(path));
            }
        }
        return urls;
    }

    private static List<File> listFiles(File directory) {
        List<File> files = new ArrayList<>();
        File[] entries = directory.listFiles();
        for (File entry : entries) {
            if (acceptFile(entry.getName())) {
                files.add(entry);
            }
            if (entry.isDirectory()) {
                files.addAll(listFiles(entry));
            }
        }
        return files;
    }

    private static Class<?> getClassFromFile(File classfile, File path) throws ClassNotFoundException {
        int substringBeginIndex = path.getAbsolutePath().length() + 1;
        String className = classfile.getAbsolutePath().substring(substringBeginIndex);
        className = className.substring(0, className.length() - 6).replaceAll("/|\\\\", ".");
        return Class.forName(className);
    }

    private static boolean acceptFile(String name) {
        return name.endsWith(".class");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(getAllClasses().size());
        for (Class<?> clazz : getAllClasses()) {
            if (clazz.isAnnotationPresent(TryInject.class)) {
                System.out.println(clazz);
            }
        }
    }
}
