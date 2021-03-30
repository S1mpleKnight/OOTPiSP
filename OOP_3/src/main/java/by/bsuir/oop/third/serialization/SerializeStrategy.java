package by.bsuir.oop.third.serialization;

import by.bsuir.oop.third.furniture.Table;

import java.io.File;
import java.util.List;

public interface SerializeStrategy {
    List<Table> read(File file);

    String write(File file, List<Table> tables);
}
