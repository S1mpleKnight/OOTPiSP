package by.bsuir.oop.fourth.serialization.impl;

import by.bsuir.oop.fourth.container.Container;
import by.bsuir.oop.fourth.domain.furniture.Table;
import by.bsuir.oop.fourth.serialization.api.SerializeStrategy;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public final class YAMLSerializeStrategy implements SerializeStrategy {
    private static YAMLSerializeStrategy yamlVersion;
    private final ObjectMapper mapper;

    private YAMLSerializeStrategy() {
        mapper = new ObjectMapper(new YAMLFactory());
    }

    public static YAMLSerializeStrategy getYamlVersion() {
        if (yamlVersion == null) {
            yamlVersion = new YAMLSerializeStrategy();
        }
        return yamlVersion;
    }

    @Override
    public Container<Table> read(File file) {
        Container<Table> container = null;
        try {
            container = mapper.readValue(file, new TypeReference<Container<Table>>(){});
        } catch (IOException exception) {
            System.out.println("I/O exception");
        }
        return container;
    }

    @Override
    public String write(File file, Container<Table> container) {
        String result;
        try {
            if (file.createNewFile()) {
                System.out.println("Write: file created");
            }
        } catch (IOException exception) {
            result = "Write: I/O exception";
            return result;
        }
        try (Writer writer = new FileWriter(file.getAbsolutePath(), StandardCharsets.UTF_8)) {
            mapper.writeValue(writer, container);
            result = "Success";
        } catch (IOException exception) {
            result = "Write: I/O exception";
        }
        return result;
    }
}
