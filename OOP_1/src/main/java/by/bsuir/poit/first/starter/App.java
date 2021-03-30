package by.bsuir.poit.first.starter;

import by.bsuir.poit.first.controllers.MainWindowController;
import by.bsuir.poit.first.figures.BaseFigure;
import by.bsuir.poit.first.figures.SimpleCircle;
import by.bsuir.poit.first.figures.SimpleEllipse;
import by.bsuir.poit.first.figures.SimpleLine;
import by.bsuir.poit.first.figures.SimpleRectangle;
import by.bsuir.poit.first.figures.SimpleSquare;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class App extends Application {

    private static final Group group = new Group();
    private static final Scene scene = new Scene(group);

    @Override
    public void start(Stage stage) throws IOException {
        Parent parent = loadFXML("mainWindow");
        group.getChildren().add(parent);
        stage.setScene(scene);
        firstTask();
        stage.setTitle("Graphical application");
        stage.setResizable(false);
        stage.show();
    }

    private void firstTask() {
        initializeStaticList(FiguresList.getStaticList());
        showFigures(FiguresList.getStaticList());
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void showFigures(List<BaseFigure> list){
        list.add(new SimpleSquare(350, 300, 400, 350));
        for (BaseFigure figure: list){
            figure.draw(group);
        }
    }

    private static void initializeStaticList(List<BaseFigure> list) {
        list.add(new SimpleCircle(50, 300, 100, 350));
        list.add(new SimpleEllipse(190, 300, 70, 50));
        list.add(new SimpleLine(260, 280, 300, 320));
        list.add(new SimpleRectangle(300,280,340,300));
    }

    public static Group getGroup() {
        return group;
    }
}