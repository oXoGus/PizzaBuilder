package model;

import javafx.scene.Node;

public interface Element {
    default boolean isBase(){
        return false;
    }

    default boolean isIngredient(){
        return false;
    }

    String label();

    // les 
    default Node shape(){
        return null;
    }

    double x();
    double y();


}
