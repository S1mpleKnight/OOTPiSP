package by.bsuir.oop.fourth.util.impl;

import by.bsuir.oop.fourth.container.Container;
import by.bsuir.oop.fourth.domain.furniture.Table;
import by.bsuir.oop.fourth.util.api.FileWorker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Info {
    public static final String CIPHERS_PATH = "..\\OOP_4\\encryption";
    public static final String COMPRESSION_PATH = "..\\OOP_4\\compression";
    private static final String SERIALIZE_FILE_TXT = "serialize/file.txt";
    private static final List<Class> CIPHERS = new ArrayList<>();
    private static final List<Class> COMPRESSION_METHODS = new ArrayList<>();
    private static FileWorker worker = SimpleFileWorker.getWorker();
    private static Info info;
    private Container<Table> tables;

    private Info() {
        tables = new Container<>();
    }

    public static FileWorker getWorker() {
        return worker;
    }

    public static void setWorker(FileWorker worker) {
        Info.worker = worker;
    }

    public static Info getInfo() {
        if (info == null) {
            info = new Info();
        }
        return info;
    }

    public static List<Class> getCIPHERS() {
        return CIPHERS;
    }

    public static List<Class> getCompressionMethods() {
        return COMPRESSION_METHODS;
    }

    public String getSERIALIZE_FILE() {
        return SERIALIZE_FILE_TXT;
    }

    public Container<Table> getTables() {
        return tables;
    }

    public void setTables(Container<Table> tables) {
        this.tables = tables;
    }

    public void loadPlugins() throws IOException, ClassNotFoundException {
        CIPHERS.addAll(PluginLoader.loadCipherPlugins(CIPHERS_PATH));
        COMPRESSION_METHODS.addAll(PluginLoader.loadCipherPlugins(COMPRESSION_PATH));
    }
}
