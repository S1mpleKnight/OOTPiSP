package by.bsuir.oop.third.furniture;

import java.io.Serializable;

public abstract class Put extends Furniture implements Serializable {
    private int square;

    public Put(int weight, int square) {
        super(weight);
        this.square = square;
    }

    public Put() {
    }

    public Put(int weight) {
        super(weight);
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }
}
