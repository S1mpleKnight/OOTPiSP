package by.bsuir.oop.third.container;

import by.bsuir.oop.third.furniture.Table;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private static Container container;
    private List<Table> list;

    public static Container getContainer() {
        if (container == null){
            container = new Container();
        }
        return container;
    }

    private Container() {
        list = new ArrayList<>();
    }

    public List<Table> getList() {
        return list;
    }
}
