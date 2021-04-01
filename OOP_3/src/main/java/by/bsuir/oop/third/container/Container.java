package by.bsuir.oop.third.container;

import by.bsuir.oop.third.furniture.Table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Container<T> implements Serializable {
    private final List<T> list;

    public Container(List<T> list) {
        this.list = list;
    }

    public Container() {
        list = new ArrayList<>();
    }

    public List<T> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "Container { \n" +
                "list=" + list +
                " \n}";
    }
}
