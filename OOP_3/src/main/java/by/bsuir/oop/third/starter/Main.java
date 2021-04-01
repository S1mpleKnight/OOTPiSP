package by.bsuir.oop.third.starter;

import by.bsuir.oop.third.container.Container;
import by.bsuir.oop.third.furniture.Table;
import by.bsuir.oop.third.info.Info;
import by.bsuir.oop.third.serialization.SerializeStrategy;
import by.bsuir.oop.third.serialization.YAMLSerializeStrategy;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main extends Application {
    private static final File YAML = new File(Info.getInfo().getFILE_PATH());
    private static Stage stage;

    private static final Label LABEL = new Label();

    public static void main(String[] args) {
        yaml();
        launch(args);
    }

    private static void yaml() {
        SerializeStrategy strategy = YAMLSerializeStrategy.getYamlVersion();
        List<Table> list = strategy.read(YAML).getList();
        Info.getInfo().setTables(new Container<>(list));
    }


    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        try {
            setScene("primary.fxml");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        primaryStage.setTitle("Сериализация");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void setScene(String path) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(path))));
    }

    public static Stage getStage() {
        return stage;
    }
}
