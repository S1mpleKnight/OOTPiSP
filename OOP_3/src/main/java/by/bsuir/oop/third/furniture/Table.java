package by.bsuir.oop.third.furniture;

import by.bsuir.oop.third.maker.Manufacturer;

import java.io.Serializable;

public class Table extends Put implements Serializable {
    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Table(int weight, int square) {
        super(weight, square);
    }

    public Table() {
    }


    @Override
    public String toString() {
        return "Table:" +
                " weight = " + getWeight() +
                " area = " + getArea();
    }
}
