package edu.epam.shape.specification.impl;

import edu.epam.shape.entity.Quadrangle;
import edu.epam.shape.entity.QuadrangleParameters;
import edu.epam.shape.specification.ISpecification;
import edu.epam.shape.warehouse.QuadrangleWarehouse;

public class AreaSpecification implements ISpecification<Quadrangle> {
    private double areaFrom;
    private double areaTo;

    public AreaSpecification(double areaFrom, double areaTo){
        this.areaFrom = areaFrom;
        this.areaTo = areaTo;
    }

    @Override
    public boolean specify(Quadrangle quadrangle) {
        QuadrangleWarehouse warehouse = QuadrangleWarehouse.getInstance();
        long id = quadrangle.getId();
        QuadrangleParameters properties =  warehouse.get(id);
        double area = properties.getArea();
        boolean result = area >= areaFrom && area <= areaTo;
        return result;
    }
}
