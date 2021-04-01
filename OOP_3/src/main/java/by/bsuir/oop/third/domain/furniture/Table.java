package by.bsuir.oop.third.domain.furniture;

import java.io.Serializable;

public class Table extends Put implements Serializable {
    private static final Long serialVersionUID = 1L;

    public Table(int weight, int area) {
        super(weight, area);
    }

    public Table() {
    }

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Table" +
                ":weight=" + getWeight() +
                ":area=" + getArea();
    }
}
