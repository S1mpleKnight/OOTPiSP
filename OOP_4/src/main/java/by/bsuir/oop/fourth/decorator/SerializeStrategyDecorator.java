package by.bsuir.oop.fourth.decorator;

import by.bsuir.oop.fourth.container.Container;
import by.bsuir.oop.fourth.domain.furniture.Table;
import by.bsuir.oop.fourth.serialization.api.SerializeStrategy;

import java.io.File;

public class SerializeStrategyDecorator implements SerializeStrategy {
    protected SerializeStrategy strategy;

    public SerializeStrategyDecorator(SerializeStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Container<Table> read(File file) {
        return strategy.read(file);
    }

    @Override
    public String write(File file, Container<Table> container) {
        return strategy.write(file, container);
    }
}
