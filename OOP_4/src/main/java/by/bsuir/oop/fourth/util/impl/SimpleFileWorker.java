package by.bsuir.oop.fourth.util.impl;

import by.bsuir.oop.fourth.util.api.FileWorker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class SimpleFileWorker implements FileWorker {
    private static SimpleFileWorker worker;

    private SimpleFileWorker() {
    }

    public static SimpleFileWorker getWorker() {
        if (worker == null) {
            worker = new SimpleFileWorker();
        }
        return worker;
    }

    public String readFile(File file) throws IOException {
        List<String> strings;
        try (Stream<String> stream = Files.lines(file.toPath())) {
            strings = stream.collect(Collectors.toList());
        } catch (IOException exception) {
            System.out.println("FileWorker read exception");
            throw new IOException("Read: reading file exception");
        }
        return String.join("", strings);
    }

    public boolean writeFile(File file, String text) throws IOException {
        try (Writer writer = new FileWriter(file, StandardCharsets.UTF_8)) {
            writer.write(text);
            writer.flush();
        } catch (IOException exception) {
            System.out.println("FileWorker write exception");
            throw new IOException("Can not write info");
        }
        return true;
    }

    public void createFile(File file) throws IOException {
        try {
            if (file.createNewFile()) {
                System.out.println("Write: file created");
            }
        } catch (IOException exception) {
            throw new IOException("Can not create new file");
        }
    }
}
