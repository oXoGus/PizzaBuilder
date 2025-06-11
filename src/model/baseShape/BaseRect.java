package model.baseShape;

import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import model.BaseShape;

public record BaseRect(double x, double y) implements BaseShape {
    

    @Override
    public String label() {
        return "pâte en carré";
    }

    @Override
    public Node shape() {
    double size = 250; // côté du carré

    Rectangle square = new Rectangle();
    square.setWidth(size);
    square.setHeight(size);
    square.setX(x - size/2);
    square.setY(y - size/2);
    square.setFill(Paint.valueOf("#f0e5c9"));        
    return square;
    }
}
