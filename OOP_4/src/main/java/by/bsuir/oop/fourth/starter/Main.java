package by.bsuir.oop.fourth.starter;

import by.bsuir.oop.fourth.compression.api.Compression;
import by.bsuir.oop.fourth.compression.impl.SimpleCompression;
import by.bsuir.oop.fourth.util.Info;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

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
        primaryStage.setTitle("Lab_4-5");
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
