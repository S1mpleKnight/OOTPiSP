package by.bsuir.oop.fourth.decorator;

import by.bsuir.oop.fourth.util.api.FileWorker;

import java.io.File;
import java.io.IOException;

public class FileWorkerDecorator implements FileWorker {
    private FileWorker worker;

    public FileWorkerDecorator(FileWorker worker) {
        this.worker = worker;
    }

    @Override
    public String readFile(File file) throws Exception {
        return worker.readFile(file);
    }

    @Override
    public boolean writeFile(File file, String text) throws Exception {
        return worker.writeFile(file, text);
    }

    @Override
    public void createFile(File file) throws IOException {
        worker.createFile(file);
    }
}
