package by.bsuir.oop.fourth.domain.furniture;

import by.bsuir.oop.fourth.domain.maker.Manufacturer;

public abstract class Cabinet extends Furniture {
    private int width;
    private int length;

    public Cabinet(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public Cabinet(Manufacturer maker, int width, int length) {
        super(maker);
        this.width = width;
        this.length = length;
    }

    public Cabinet() {
    }

    public Cabinet(Manufacturer maker) {
        super(maker);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
