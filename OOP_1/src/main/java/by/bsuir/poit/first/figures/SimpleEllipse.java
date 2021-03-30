package by.bsuir.poit.first.figures;

import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;

public class SimpleEllipse extends BaseFigure {
    private int horizontalRadius;
    private int verticalRadius;

    public SimpleEllipse(int x1, int y1, int horizontalRadius, int verticalRadius) {
        super(x1, y1);
        this.horizontalRadius = horizontalRadius;
        this.verticalRadius = verticalRadius;
    }

    public int getHorizontalRadius() {
        return horizontalRadius;
    }

    public void setHorizontalRadius(int horizontalRadius) {
        this.horizontalRadius = horizontalRadius;
    }

    public int getVerticalRadius() {
        return verticalRadius;
    }

    public void setVerticalRadius(int verticalRadius) {
        this.verticalRadius = verticalRadius;
    }

    @Override
    public void draw(Group group) {
        Ellipse ellipse = new Ellipse(this.getX1(), this.getY1(), horizontalRadius, verticalRadius);
        ellipse.setFill(Paint.valueOf("silver"));
        ellipse.setStroke(Paint.valueOf("black"));
        group.getChildren().add(ellipse);
    }
}
