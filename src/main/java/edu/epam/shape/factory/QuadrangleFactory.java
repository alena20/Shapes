package edu.epam.shape.factory;

import edu.epam.shape.entity.EntryPoint;
import edu.epam.shape.entity.Quadrangle;
import edu.epam.shape.entity.Shape;
import edu.epam.shape.exception.ShapeFactoryException;
import edu.epam.shape.validator.QuadrangleValidator;

public class QuadrangleFactory extends ShapeFactory{
    @Override
    public Shape createShape(EntryPoint... points) throws ShapeFactoryException {
        QuadrangleValidator quadrangleValidator = new QuadrangleValidator();
        if(!quadrangleValidator.isQuadrangle(points[0],points[1],points[2],points[3])){
            throw new ShapeFactoryException();
        }
        Quadrangle quadrangle = new Quadrangle(points[0],points[1],points[2],points[3]);
        return quadrangle;
    }
}
