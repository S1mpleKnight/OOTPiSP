package by.bsuir.oop.fourth.decorator;

import by.bsuir.oop.fourth.serialization.api.SerializeStrategy;

public class EncryptionDecorator extends SerializeStrategyDecorator{
    public EncryptionDecorator(SerializeStrategy strategy) {
        super(strategy);
    }
}
