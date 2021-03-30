package by.bsuir.oop.third.starter;

import by.bsuir.oop.third.container.Container;
import by.bsuir.oop.third.furniture.Table;
import by.bsuir.oop.third.maker.Manufacturer;
import by.bsuir.oop.third.serialization.BinarySerialize;
import by.bsuir.oop.third.serialization.SerializeStrategy;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class Main extends Application {
    private static final Container CONTAINER = Container.getContainer();
    private static final File BINARY = new File("./file.txt");

    private static final Label LABEL = new Label();

    public static void main(String[] args) {
        CONTAINER.getList().add(new Table(15, 100, new Manufacturer("Adibas")));
        CONTAINER.getList().add(new Table(14, 101));
        CONTAINER.getList().add(new Table(13, 102));
        CONTAINER.getList().add(new Table(12, 103));
        CONTAINER.getList().add(new Table(11, 104, new Manufacturer("Adibas")));
        CONTAINER.getList().add(new Table(10, 105));
        SerializeStrategy strategy = BinarySerialize.getBinaryVersion();
        strategy.write(BINARY, CONTAINER.getList());
        List<Table> list = strategy.read(BINARY);
        StringBuilder text = new StringBuilder();
        for (Table table: list) {
            text.append(table.toString()).append("\n");
        }
        LABEL.setText(text.toString());

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("HELLO");
        Group group = new Group();
        group.getChildren().addAll(label, LABEL);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
