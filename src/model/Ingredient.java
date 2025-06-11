package model;

import java.util.List;

import javafx.scene.Node;
import model.ingredients.*;
import model.ingredients.Champignon;;

public interface Ingredient extends Element {
    public static List<Ingredient> INGREDIENTS_LST = List.of(new FromageRape(0, 0), new Tomate(0, 0), new Champignon(0, 0), new Jambon(0, 0), new Peperoni(0, 0), new Ananas(0, 0));


    @Override
    default boolean isIngredient() {
        return true;
    }

    default List<Node> shapes(){
        return null;
    }
    
}
