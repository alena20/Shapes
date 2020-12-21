package edu.epam.shape.observer;

import edu.epam.shape.entity.Shape;

public interface Observer<T extends Shape> {
    void performedPerimeter(T t);
    void performedArea(T t);
}
