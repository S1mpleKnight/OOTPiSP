package by.bsuir.oop.fourth.util.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PluginLoader {

    public static List<Class> loadCipherPlugins(String parentPackage) throws IOException, ClassNotFoundException {
        List<Class> classes = new ArrayList<>();
        File pluginDir = new File(parentPackage);
        File[] jars = pluginDir.listFiles(file -> file.isFile() && file.getName().endsWith(".jar"));
        if (jars == null) {
            throw new IllegalArgumentException("No jars in file");
        }
        return takeJarsEntities(classes, jars);
    }

    private static List<Class> takeJarsEntities(List<Class> classes, File[] jars) throws IOException, ClassNotFoundException {
        for (File jar : jars) {
            JarFile jarFile = new JarFile(jar);
            Enumeration<JarEntry> entries = jarFile.entries();
            URL path = jar.toURI().toURL();
            URLClassLoader classLoader = new URLClassLoader(new URL[]{path});
            loadClasses(classes, entries, classLoader);
        }
        return classes;
    }

    private static void loadClasses(List<Class> classes, Enumeration<JarEntry> entries, URLClassLoader classLoader) throws ClassNotFoundException {
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            String name = entry.getName();
            if (entry.isDirectory() || (!name.endsWith(".class"))) {
                continue;
            }
            String className = name.substring(0, name.length() - 6).replace('/', '.');
            Class<?> anotherClass = classLoader.loadClass(className);
            classes.add(anotherClass);
        }
    }
}
