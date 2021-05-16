package by.bsuir.oop.fourth.serialization.impl;

import by.bsuir.oop.fourth.container.Container;
import by.bsuir.oop.fourth.domain.furniture.Table;
import by.bsuir.oop.fourth.domain.maker.Manufacturer;
import by.bsuir.oop.fourth.serialization.api.SerializeStrategy;
import by.bsuir.oop.fourth.util.api.FileWorker;
import by.bsuir.oop.fourth.util.impl.Info;
import by.bsuir.oop.fourth.util.impl.SimpleFileWorker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class CustomTablesSerializeStrategy implements SerializeStrategy {
    private static CustomTablesSerializeStrategy customVersion;

    private CustomTablesSerializeStrategy() {
    }

    public static CustomTablesSerializeStrategy getCustomVersion() {
        if (customVersion == null) {
            customVersion = new CustomTablesSerializeStrategy();
        }
        return customVersion;
    }

    @Override
    public Container<Table> read(File file) throws Exception {
        String text = Info.getWorker().readFile(file);
        String[] lexemes = text.split("[\\[\\]]")[1].split(",");
        return getTableContainer(lexemes);
    }

    private Container<Table> getTableContainer(String[] lexemes) {
        List<Table> tables = new ArrayList<>();
        for (String lexeme : lexemes) {
            String[] fields = lexeme.split(":");
            Manufacturer maker = Manufacturer.valueOf(fields[1].split("=")[1]);
            int area = Integer.parseInt(fields[2].split("=")[1]);
            int legs = Integer.parseInt(fields[3].split("=")[1]);
            tables.add(new Table(maker, area, legs));
        }
        return new Container<>(tables);
    }

    @Override
    public boolean write(File file, Container<Table> container) throws Exception {
        Info.getWorker().createFile(file);
        String text = container.toString();
        Info.getWorker().writeFile(file, text);
        return true;
    }
}
