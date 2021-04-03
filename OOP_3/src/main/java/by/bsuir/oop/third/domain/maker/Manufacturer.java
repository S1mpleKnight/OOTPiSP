package by.bsuir.oop.third.domain.maker;

import java.io.Serializable;

public enum Manufacturer implements Serializable{
    PINSKDREV("PINSKDREV"), KMKMEBEL("KMKMEBEL"),
    PROSON("PROSON"), DAMAVER("DAMAVER");

    public String getName() {
        return name;
    }

    private final String name;

    Manufacturer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name ;
    }
}
