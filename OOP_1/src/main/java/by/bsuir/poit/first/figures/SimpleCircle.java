package by.bsuir.poit.first.figures;

import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class SimpleCircle extends BaseFigure {
    private int x2;
    private int y2;

    public SimpleCircle(int x1, int y1, int x2, int y2) {
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
        Circle circle = new Circle();
        circle.setCenterX(this.getX1());
        circle.setCenterY(this.getY1());
        int radius = (int) Math.sqrt(Math.pow(Math.abs(this.getX1() - x2), 2)
                + Math.pow(Math.abs(this.getY1() - y2), 2));
        circle.setRadius(radius);
        circle.setFill(Paint.valueOf("grey"));
        circle.setStroke(Paint.valueOf("black"));
        group.getChildren().add(circle);
    }
}
