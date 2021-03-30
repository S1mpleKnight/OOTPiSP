package by.bsuir.oop.third.info;

import by.bsuir.oop.third.container.Container;
import by.bsuir.oop.third.serialization.YAMLSerialize;

import java.io.File;

public class Info {
    private static Info info;
    private final String YAML_FILE_PATH = "./files/file.yaml";
    private final String BINARY_FILE_PATH = "./files/binary.txt";
    private final String CUSTOM_FILE_PATH = "./files/custom.txt";
    private Container tables;
    private Container sofas;

    private Info() {
        tables = YAMLSerialize.getYamlVersion().read(new File(YAML_FILE_PATH));
        sofas = new Container();
    }

    public String getYAML_FILE_PATH() {
        return YAML_FILE_PATH;
    }

    public String getBINARY_FILE_PATH() {
        return BINARY_FILE_PATH;
    }

    public String getCUSTOM_FILE_PATH() {
        return CUSTOM_FILE_PATH;
    }

    public static Info getInfo() {
        if (info == null) {
            info = new Info();
        }
        return info;
    }

    public Container getTables() {
        return tables;
    }

    public void setTables(Container tables) {
        this.tables = tables;
    }

    public Container getSofas() {
        return sofas;
    }

    public void setSofas(Container sofas) {
        this.sofas = sofas;
    }
}
