package by.bsuir.oop.third.starter;

import by.bsuir.oop.third.container.Container;
import by.bsuir.oop.third.domain.furniture.Table;
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
    private static Scene mainScene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        try {
            mainScene = new Scene(FXMLLoader.load(getClass().getResource("primary.fxml")));
            stage.setScene(mainScene);
        } catch (IOException exception) {
            System.out.println("UUps");
        }
        primaryStage.setTitle("Lab_3");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void setScene(String path, Class tClass) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(tClass.getResource(path))));
    }

    public static Scene getMainScene() {
        return mainScene;
    }

    public static Stage getStage() {
        return stage;
    }
}
