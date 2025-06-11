package model;

import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public record TomatoSauce(double x, double y) implements Element{
    @Override
    public String label() {
        return "Sauce tomate";
    }

    @Override
    public Node shape() {
        Circle shape = new Circle(x, y, 50, Paint.valueOf("red"));
        return shape;
    }

} 
