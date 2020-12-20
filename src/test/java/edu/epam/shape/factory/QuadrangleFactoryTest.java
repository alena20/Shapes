package edu.epam.shape.factory;

import edu.epam.shape.entity.EntryPoint;
import edu.epam.shape.entity.Quadrangle;
import edu.epam.shape.entity.Shape;
import edu.epam.shape.exception.ShapeFactoryException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QuadrangleFactoryTest {
    @Test
    public void createShapeTest() throws ShapeFactoryException {
        QuadrangleFactory quadrangleFactory = new QuadrangleFactory();
        EntryPoint p1 = new EntryPoint(1,3);
        EntryPoint p2 = new EntryPoint(1,6);
        EntryPoint p3 = new EntryPoint(4,8);
        EntryPoint p4 = new EntryPoint(4,5);
        Quadrangle actual =(Quadrangle) quadrangleFactory.createShape(p1,p2,p3,p4);
        Quadrangle expected = new Quadrangle(p1,p2,p3,p4);
        Assert.assertEquals(actual,expected);
    }

     @Test(expectedExceptions = ShapeFactoryException.class)
        public void createShapeErrorTest() throws ShapeFactoryException {
         QuadrangleFactory quadrangleFactory = new QuadrangleFactory();
         EntryPoint p1 = new EntryPoint(1,3);
         EntryPoint p2 = new EntryPoint(1,6);
         EntryPoint p3 = new EntryPoint(4,8);
         EntryPoint p4 = new EntryPoint(1,6);
         Shape quadrangle =(Quadrangle) quadrangleFactory.createShape(p1,p2,p3,p4);
    }

}