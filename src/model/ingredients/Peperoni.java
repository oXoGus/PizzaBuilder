package model.ingredients;

import java.util.Random;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Ingredient;

public record Peperoni(double x, double y) implements Ingredient {
    @Override
    public String label() {
        return "Peperoni";
    }

    @Override
    public Node shape() {
        Image image = new Image("file:src/vue/img/tranche_pepperoni.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);
        
        imageView.setLayoutX(x - imageView.getFitWidth()/2);
        imageView.setLayoutY(y - imageView.getFitHeight()/2);
        imageView.setRotate(new Random().nextDouble(360));

        return imageView;
    }
}