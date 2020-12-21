package edu.epam.shape.observer.impl;

import edu.epam.shape.entity.EntryPoint;
import edu.epam.shape.entity.Quadrangle;
import edu.epam.shape.entity.QuadrangleParameters;
import edu.epam.shape.repository.IRepository;
import edu.epam.shape.repository.impl.RepositoryImpl;
import edu.epam.shape.service.impl.ShapeServiceImpl;
import edu.epam.shape.warehouse.QuadrangleWarehouse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class QuadrangleObserverTest {
    public IRepository<Quadrangle> repository = RepositoryImpl.getInstance();
    public QuadrangleWarehouse quadrangleWarehouse = QuadrangleWarehouse.getInstance();
    public ShapeServiceImpl service = ShapeServiceImpl.getInstance();

    @Test
    public void observerTest() {
        Quadrangle quadrangle = repository.get(0);
        QuadrangleObserver observer = new QuadrangleObserver();
        quadrangle.attach(observer);
        EntryPoint point = new EntryPoint(1,2);
        quadrangle.setA(point);
        double area = service.area(quadrangle);
        double perimeter = service.perimeter(quadrangle);
        long id = quadrangle.getId();
        QuadrangleParameters properties = quadrangleWarehouse.get(id);
        boolean actual = (area == properties.getArea()) && (perimeter == properties.getPerimeter());
        Assert.assertTrue(actual);
    }

    @BeforeClass
    public void quadrangleToRepository() {
        Quadrangle quadrangle = new Quadrangle(new EntryPoint(1,3), new EntryPoint(1,6),new EntryPoint(4,8),  new EntryPoint(4,5));
        double area = service.area(quadrangle);
        double perimeter = service.perimeter(quadrangle);
        long id = quadrangle.getId();
        QuadrangleParameters properties = new QuadrangleParameters(area,perimeter);
        repository.add(quadrangle);
        quadrangleWarehouse.put(id,properties);
    }
}