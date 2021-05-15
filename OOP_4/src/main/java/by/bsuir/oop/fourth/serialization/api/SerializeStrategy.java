package by.bsuir.oop.fourth.serialization.api;

import by.bsuir.oop.fourth.container.Container;
import by.bsuir.oop.fourth.domain.furniture.Table;

import java.io.File;
import java.io.IOException;

public interface SerializeStrategy {
    Container<Table> read(File file) throws IOException;

    boolean write(File file, Container<Table> container) throws IOException;
}
