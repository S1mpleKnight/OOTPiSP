package by.bsuir.poit.first.figures;

import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

public class SimpleLine extends BaseFigure {
    private int x2;
    private int y2;

    public SimpleLine(int x1, int y1, int x2, int y2) {
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
        Line line = new Line(this.getX1(), this.getY1(), x2, y2);
        line.setFill(Paint.valueOf("red"));
        group.getChildren().add(line);
    }
}
