package by.bsuir.oop.fourth.util.api;

import java.io.File;
import java.io.IOException;

public interface FileWorker {
    String readFile(File file) throws IOException;

    boolean writeFile(File file, String text) throws IOException;

    void createFile(File file) throws IOException;
}
