package by.bsuir.oop.third.info;

import by.bsuir.oop.third.container.Container;
import by.bsuir.oop.third.furniture.Sofa;
import by.bsuir.oop.third.furniture.Table;
import by.bsuir.oop.third.maker.Manufacturer;

import java.util.List;

public class Info {
    private static Info info;
    private final String FILE_PATH = "file.txt";
    private Container<Table> tables;
    private Container<Sofa> sofas;
    private Container<Manufacturer> manufactures;
    private Info() {
        manufactures = new Container<>();
        tables = new Container<>();
        sofas = new Container<>();
    }

    public String getFILE_PATH() {
        return FILE_PATH;
    }

    public static Info getInfo() {
        if (info == null) {
            info = new Info();
        }
        return info;
    }

    public Container<Table> getTables() {
        return tables;
    }

    public void setTables(Container<Table> tables) {
        this.tables = tables;
    }

    public void setSofas(Container<Sofa> sofas) {
        this.sofas = sofas;
    }

    public Container<Manufacturer> getManufactures() {
        return manufactures;
    }

    public void setManufactures(Container<Manufacturer> manufactures) {
        this.manufactures = manufactures;
    }
}
