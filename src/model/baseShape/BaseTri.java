package model.baseShape;

import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import model.BaseShape;

public record BaseTri(double x, double y) implements BaseShape {
    

    @Override
    public String label() {
        return "pâte en triangle";
    }

    @Override
    public Node shape() {

        double size = 300;

        Polygon triangle = new Polygon();

        double h = Math.sqrt(3) / 2 * size;

        triangle.getPoints().addAll(
            x, y - (2.0/3.0)*h,             // sommet du haut
            x - size / 2, y + (1.0/3.0)*h,  // coin bas gauche
            x + size / 2, y + (1.0/3.0)*h   // coin bas droit
        );

        triangle.setFill(Paint.valueOf("#f0e5c9"));
        return triangle;
    }
}
