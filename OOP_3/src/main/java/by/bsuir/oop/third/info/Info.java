package by.bsuir.oop.third.info;

import by.bsuir.oop.third.container.Container;
import by.bsuir.oop.third.domain.furniture.Table;

public class Info {
    private static Info info;
    private final String FILE_PATH = "file.txt";
    private Container<Table> tables;

    private Info() {
        tables = new Container<>();
    }

    public static Info getInfo() {
        if (info == null) {
            info = new Info();
        }
        return info;
    }

    public String getFILE_PATH() {
        return FILE_PATH;
    }

    public Container<Table> getTables() {
        return tables;
    }

    public void setTables(Container<Table> tables) {
        this.tables = tables;
    }

}
