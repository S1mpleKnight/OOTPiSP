package by.bsuir.poit.first.controllers;

import by.bsuir.poit.first.figures.BaseFigure;
import by.bsuir.poit.first.figures.FigureType;
import by.bsuir.poit.first.starter.App;
import by.bsuir.poit.first.starter.FiguresList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.concurrent.atomic.AtomicInteger;

public class MainWindowController {

    FigureType type;
    @FXML
    private VBox menuPane;
    @FXML
    private Button compositionButton;
    @FXML
    private Button lineButton;
    @FXML
    private Button squareButton;
    @FXML
    private Button rectangleButton;
    @FXML
    private Button circleButton;
    @FXML
    private Button ellipseButton;

    @FXML
    void initialize() {
        IntegerProperty count = new SimpleIntegerProperty(0);
        final AtomicInteger x1 = new AtomicInteger();
        final AtomicInteger y1 = new AtomicInteger();
        final AtomicInteger x2 = new AtomicInteger();
        final AtomicInteger y2 = new AtomicInteger();
        Group group = App.getGroup();

        group.setOnMouseClicked(e -> {
            if (type != null && count.get() == 0){
                if (e.getSceneY() > menuPane.getHeight()){
                    x1.set((int) e.getSceneX());
                    y1.set((int) e.getSceneY());
                    count.set(1);
                }
            } else if (type != null && count.get() == 1){
                if (e.getSceneY() > menuPane.getHeight()){
                    x2.set((int) e.getSceneX());
                    y2.set((int) e.getSceneY());
                    count.set(1);
                    someChecks(x1, y1, x2, y2, group);
                    BaseFigure figure = type.getFigure(x1.get(), y1.get(), x2.get(), y2.get());
                    figure.draw(group);
                    count.set(0);
                }
            }
        });

        compositionButton.setOnMouseClicked(e -> {
            App.showFigures(FiguresList.getStaticList());
        });

        lineButton.setOnMouseClicked(e -> {
            type = FigureType.LINE;
        });

        circleButton.setOnMouseClicked(e -> {
            type = FigureType.CIRCLE;
        });

        rectangleButton.setOnMouseClicked(e -> {
            type = FigureType.RECTANGLE;
        });

        squareButton.setOnMouseClicked(e -> {
            type = FigureType.SQUARE;
        });

        ellipseButton.setOnMouseClicked(e -> {
            type = FigureType.ELLIPSE;
        });
    }

    private void someChecks(AtomicInteger x1, AtomicInteger y1, AtomicInteger x2, AtomicInteger y2, Group group) {
        if (type == FigureType.CIRCLE) {
            int hypot = (int) Math.hypot(x1.get() - x2.get(), y1.get() - y2.get());
            if (y1.get() - hypot < menuPane.getHeight()){
                x2.set(x1.get());
                y2.set((int) menuPane.getHeight() + 1);
            }
        } else if (type == FigureType.ELLIPSE){
            int height = Math.abs(y1.get() - y2.get());
            if (y1.get() - height < menuPane.getHeight()){
                y2.set((int) menuPane.getHeight() + 1);
            }
        }
    }
}
