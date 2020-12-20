package edu.epam.shape.specification.impl;

import edu.epam.shape.entity.Quadrangle;
import edu.epam.shape.specification.ISpecification;

public class IdSpecification implements ISpecification<Quadrangle> {
    private long idFrom;
    private long idTo;

    public IdSpecification(long idFrom, long idTo) {
        this.idFrom = idFrom;
        this.idTo = idTo;
    }

    @Override
    public boolean specify(Quadrangle quadrangle) {
        long rectangleId = quadrangle.getId();
        boolean result = rectangleId >= idFrom && rectangleId <= idTo;
        return result;
    }
}
