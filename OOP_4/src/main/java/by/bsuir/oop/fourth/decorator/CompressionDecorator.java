package by.bsuir.oop.fourth.decorator;

import by.bsuir.oop.fourth.serialization.api.SerializeStrategy;

public class CompressionDecorator extends SerializeStrategyDecorator{


    public CompressionDecorator(SerializeStrategy strategy) {
        super(strategy);
    }
}
