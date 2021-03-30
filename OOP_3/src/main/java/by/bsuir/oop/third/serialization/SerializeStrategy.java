package by.bsuir.oop.third.serialization;

import by.bsuir.oop.third.container.Container;

import java.io.File;

public interface SerializeStrategy {
    Container read(File file);

    String write(File file, Container container);
}
