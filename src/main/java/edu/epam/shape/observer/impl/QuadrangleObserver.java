package edu.epam.shape.observer.impl;

import edu.epam.shape.entity.Quadrangle;
import edu.epam.shape.entity.QuadrangleParameters;
import edu.epam.shape.observer.Observer;
import edu.epam.shape.service.ShapeService;
import edu.epam.shape.service.impl.ShapeServiceImpl;
import edu.epam.shape.warehouse.QuadrangleWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuadrangleObserver implements Observer<Quadrangle> {
    private static final Logger logger = LogManager.getLogger(QuadrangleObserver.class);
    @Override
    public void performedPerimeter(Quadrangle quadrangle) {
        Long id = quadrangle.getId();
        ShapeService shapeService = ShapeServiceImpl.getInstance();
        QuadrangleWarehouse quadrangleWarehouse = QuadrangleWarehouse.getInstance();
        double perimeter = shapeService.perimeter(quadrangle);
        QuadrangleParameters quadrangleParameters = quadrangleWarehouse.get(id);
        quadrangleParameters.setPerimeter(perimeter);
        logger.info("perimeter updated,new perimeter {}",perimeter);
    }

    @Override
    public void performedArea(Quadrangle quadrangle) {
        Long id = quadrangle.getId();
        ShapeService shapeService = ShapeServiceImpl.getInstance();
        QuadrangleWarehouse quadrangleWarehouse = QuadrangleWarehouse.getInstance();
        double area = shapeService.area(quadrangle);
        QuadrangleParameters quadrangleParameters = quadrangleWarehouse.get(id);
        quadrangleParameters.setArea(area);
        logger.info("area updated, new area {}",area);
    }
}
