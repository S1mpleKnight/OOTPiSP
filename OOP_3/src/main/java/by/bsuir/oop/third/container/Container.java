package by.bsuir.oop.third.container;

import by.bsuir.oop.third.furniture.Table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Container implements Serializable {
    private final List<Table> list;

    public Container(List<Table> list) {
        this.list = list;
    }

    public Container() {
        list = new ArrayList<>();
    }

    public List<Table> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "Container { \n" +
                "list=" + list +
                " \n}";
    }
}
