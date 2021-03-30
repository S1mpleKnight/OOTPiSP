package by.bsuir.oop.third.furniture;

import java.io.Serializable;

public class Table extends Put implements Serializable {
    private static final long serialVersionUID = 1L;

    public Table(int weight, int area) {
        super(weight, area);
    }

    public Table() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Table" +
                ":weight=" + getWeight() +
                ":area=" + getArea();
    }
}
