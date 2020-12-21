package edu.epam.shape.factory;

import edu.epam.shape.entity.EntryPoint;
import edu.epam.shape.entity.Shape;
import edu.epam.shape.exception.ShapeFactoryException;

public abstract class ShapeFactory {
    public abstract Shape createShape(EntryPoint...points) throws ShapeFactoryException;
}
