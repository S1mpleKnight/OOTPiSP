package by.bsuir.oop.third.furniture;

import by.bsuir.oop.third.maker.Manufacturer;

import java.io.Serializable;

public class Table extends Put implements Serializable {
    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private Manufacturer manufacturer;

    public Table(int weight, int square, Manufacturer manufacturer) {
        super(weight, square);
        this.manufacturer = manufacturer;
    }

    public Table() {
    }

    public Table(int weight, int square) {
        super(weight, square);
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Table:" +
                " manufacturer = " + manufacturer +
                " weight = " + getWeight() +
                " square = " + getSquare();
    }
}
