package by.bsuir.oop.third.serialization;

import by.bsuir.oop.third.furniture.Table;

import java.io.File;
import java.util.List;

public final class YAMLSerialize implements SerializeStrategy {
    private static YAMLSerialize yamlVersion;

    public static YAMLSerialize getYamlVersion() {
        if (yamlVersion == null){
            yamlVersion = new YAMLSerialize();
        }
        return yamlVersion;
    }

    private YAMLSerialize() {
    }

    @Override
    public List<Table> read(File file) {
        // TODO: 30.03.2021 YAML serialize & deserialize
        return null;
    }

    @Override
    public String write(File file, List<Table> tables) {
        return null;
    }
}
