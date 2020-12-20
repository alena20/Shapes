package edu.epam.shape.service;

import edu.epam.shape.entity.EntryPoint;
import edu.epam.shape.entity.Quadrangle;

public interface ShapeService {
    double area(Quadrangle quadrangle);
    double perimeter(Quadrangle quadrangle);
    double sideLength(EntryPoint p1, EntryPoint p2);
    void isConvexQuadrangle(Quadrangle quadrangle);
    boolean isQuadrangle(Quadrangle quadrangle);
    void typeOfQuadrangle(Quadrangle quadrangle);
}
