package model;

public interface BaseShape extends Element {
    @Override
    default boolean isBase() {
        return true;
    }
}