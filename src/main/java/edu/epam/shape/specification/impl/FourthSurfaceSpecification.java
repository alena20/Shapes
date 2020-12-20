package edu.epam.shape.specification.impl;

import edu.epam.shape.entity.EntryPoint;
import edu.epam.shape.entity.Quadrangle;
import edu.epam.shape.specification.ISpecification;

public class FourthSurfaceSpecification implements ISpecification<Quadrangle> {
    @Override
    public boolean specify(Quadrangle quadrangle) {
        EntryPoint a = quadrangle.getA();
        EntryPoint b = quadrangle.getB();
        EntryPoint c = quadrangle.getC();
        EntryPoint d = quadrangle.getD();
        boolean result  = (a.getX() > 0 && a.getY() < 0)
                && (b.getX() > 0 && b.getY() < 0)
                && (c.getX() > 0 && c.getY() < 0)
                && (d.getX() > 0 && d.getY() < 0);
        return result;
    }
}
