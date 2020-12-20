package edu.epam.shape.specification.impl;

import edu.epam.shape.entity.Quadrangle;
import edu.epam.shape.entity.QuadrangleParameters;
import edu.epam.shape.specification.ISpecification;
import edu.epam.shape.warehouse.QuadrangleWarehouse;

public class PerimeterSpecification implements ISpecification<Quadrangle> {
    private double perimeterFrom;
    private double perimeterTo;

    public PerimeterSpecification(double perimeterFrom, double perimeterTo){
        this.perimeterFrom = perimeterFrom;
        this.perimeterTo = perimeterTo;
    }

    @Override
    public boolean specify(Quadrangle quadrangle) {
        QuadrangleWarehouse warehouse = QuadrangleWarehouse.getInstance();
        long id = quadrangle.getId();
        QuadrangleParameters properties =  warehouse.get(id);
        double perimeter = properties.getPerimeter();
        boolean result = perimeter >= perimeterFrom && perimeter <= perimeterTo;
        return result;
    }
}
