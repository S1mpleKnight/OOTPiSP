package by.bsuir.poit.first.figures;

import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class SimpleSquare extends BaseFigure {
    private int x2;
    private int y2;

    public SimpleSquare(int x1, int y1, int x2, int y2) {
        super(x1, y1);
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    @Override
    public void draw(Group group) {
        Rectangle rectangle = new Rectangle();
        rectangle.setX(Math.min(this.getX1(), x2));
        rectangle.setY(Math.min(this.getY1(), y2));
        calculateEdge(rectangle).setFill(Paint.valueOf("dimgrey"));
        rectangle.setStroke(Paint.valueOf("black"));
        group.getChildren().add(rectangle);
    }

    private Rectangle calculateEdge(Rectangle rectangle) {
        int width = Math.abs(this.getX1() - x2);
        int height = Math.abs(this.getY1() - y2);
        int edgeLength = Math.min(width, height);
        rectangle.setWidth(edgeLength);
        rectangle.setHeight(edgeLength);
        return rectangle;
    }
}
