package by.bsuir.oop.third.serialization;

import by.bsuir.oop.third.container.Container;
import by.bsuir.oop.third.furniture.Table;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomSerialize implements SerializeStrategy{
    private static CustomSerialize customVersion;

    private CustomSerialize() {
    }

    public static CustomSerialize getCustomVersion() {
        if (customVersion == null){
            customVersion = new CustomSerialize();
        }
        return customVersion;
    }

    @Override
    public Container read(File file) {
        String[] lexemes = readFile(file).split("[\\[\\]]")[1].split(",");
        List<Table> tables = new ArrayList<>();
        for (String lexeme : lexemes){
            String[] fields = lexeme.split(":");
            int weight = Integer.parseInt(fields[1].split("=")[1]);
            int area = Integer.parseInt(fields[2].split("=")[1]);
            tables.add(new Table(area, weight));
        }
        return new Container(tables);
    }

    private String readFile(File file) {
        List<String> strings = new ArrayList<>();
        try (Stream<String> stream = Files.lines(file.toPath())){
            strings.addAll(stream.collect(Collectors.toList()));
        } catch (IOException exception) {
            System.out.println("Read: reading file exception");
        }
        return String.join("", strings);
    }

    @Override
    public String write(File file, Container container) {
        String result = "";
        try (Writer writer = new FileWriter(file, StandardCharsets.UTF_8)){
            writer.write(container.toString());
            writer.flush();
        } catch (IOException exception) {
            result = "I/O exception";
            exception.printStackTrace();
        }
        return result;
    }
}
