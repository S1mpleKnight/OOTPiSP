package by.bsuir.oop.fourth.starter;

import by.bsuir.oop.fourth.util.impl.Info;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage stage;
    private static Scene mainScene;

    public static void main(String[] args) throws IOException {
        try {
            Info.getInfo().loadPlugins();
        } catch (IOException e) {
            System.out.println("I/O Exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassLoader e: " + e.getMessage());
        }
//        FileWorker fileWorker = new EncryptionDecorator(SimpleFileWorker.getWorker(), new LFSR());
//        Info.setWorker(fileWorker);
//        SerializeStrategy strategy = CustomTablesSerializeStrategy.getCustomVersion();
//        Container<Table> tableContainer = strategy.read(new File("serialize/file.txt"));
//        System.out.println(tableContainer.toString());
        launch(args);
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

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        try {
            mainScene = new Scene(FXMLLoader.load(getClass().getResource("primary.fxml")));
            stage.setScene(mainScene);
        } catch (IOException exception) {
            System.out.println("Fatal error");
        }
        primaryStage.setTitle("Lab_4-5");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
