package model.baseShape;

import javafx.scene.Node;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import model.BaseShape;

public record BaseCircle(double x, double y) implements BaseShape {
    

    @Override
    public String label() {
        return "pâte en cercle";
    }

    @Override
    public Node shape() {
        Circle shape = new Circle(x, y, 250, Paint.valueOf("#f0e5c9"));
        return shape;
    }
}
