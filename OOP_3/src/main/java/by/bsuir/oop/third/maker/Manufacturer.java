package by.bsuir.oop.third.maker;

import java.io.Serializable;

public class Manufacturer implements Serializable{
    private final String name;

    public Manufacturer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Manufacturer:" +
                " name = " + name;
    }
}
