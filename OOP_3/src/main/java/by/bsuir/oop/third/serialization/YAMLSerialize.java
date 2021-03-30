package by.bsuir.oop.third.serialization;

import by.bsuir.oop.third.container.Container;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public final class YAMLSerialize implements SerializeStrategy {
    private static YAMLSerialize yamlVersion;
    private final ObjectMapper mapper;

    private YAMLSerialize() {
        mapper = new ObjectMapper(new YAMLFactory());
    }

    public static YAMLSerialize getYamlVersion() {
        if (yamlVersion == null) {
            yamlVersion = new YAMLSerialize();
        }
        return yamlVersion;
    }

    @Override
    public Container read(File file) {
        Container container = null;
        try {
            container = mapper.readValue(file, Container.class);
        } catch (IOException exception) {
            System.out.println("I/O exception");
        }
        return container;
    }

    @Override
    public String write(File file, Container container) {
        String result;
        try (Writer writer = new FileWriter(file.getAbsolutePath(), StandardCharsets.UTF_8)) {
            mapper.writeValue(writer, container);
            result = "Success";
        } catch (IOException exception) {
            result = "Write: I/O exception";
        }
        return result;
    }
}
