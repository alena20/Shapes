package edu.epam.shape.repository.impl;

import edu.epam.shape.entity.EntryPoint;
import edu.epam.shape.entity.Quadrangle;
import edu.epam.shape.entity.QuadrangleParameters;
import edu.epam.shape.service.impl.ShapeServiceImpl;
import edu.epam.shape.specification.ISpecification;
import edu.epam.shape.specification.impl.AreaSpecification;
import edu.epam.shape.warehouse.QuadrangleWarehouse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RepositoryImplTest {
    public RepositoryImpl repository = RepositoryImpl.getInstance();
    public ShapeServiceImpl service = ShapeServiceImpl.getInstance();
    public QuadrangleWarehouse quadrangleWarehouse = QuadrangleWarehouse.getInstance();

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

    @Test
    public void queryAreaIntervalTest() {
        ISpecification specification = new AreaSpecification(1,1000);
        List<Quadrangle> actual = repository.query(specification);
        System.out.println("there "+repository.get(0).toString());
        List<Quadrangle> expected = new ArrayList<Quadrangle>();
        expected.add(repository.get(0));
        Assert.assertEquals(actual,expected);
    }

}