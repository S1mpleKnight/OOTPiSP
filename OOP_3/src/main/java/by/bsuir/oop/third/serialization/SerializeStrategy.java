package by.bsuir.oop.third.serialization;

import by.bsuir.oop.third.container.Container;
import by.bsuir.oop.third.furniture.Table;

import java.io.File;

public interface SerializeStrategy {
    Container<Table> read(File file);

    String write(File file, Container<Table> container);
}
