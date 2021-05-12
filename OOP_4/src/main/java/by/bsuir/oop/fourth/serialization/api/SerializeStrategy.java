package by.bsuir.oop.fourth.serialization.api;

import by.bsuir.oop.fourth.container.Container;
import by.bsuir.oop.fourth.domain.furniture.Table;

import java.io.File;

public interface SerializeStrategy {
    Container<Table> read(File file);

    String write(File file, Container<Table> container);
}
