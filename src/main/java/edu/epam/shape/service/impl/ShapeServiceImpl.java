package edu.epam.shape.service.impl;

import edu.epam.shape.entity.EntryPoint;
import edu.epam.shape.entity.Quadrangle;
import edu.epam.shape.service.ShapeService;
import edu.epam.shape.validator.QuadrangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShapeServiceImpl implements ShapeService {
    private static final Logger logger = LogManager.getLogger(ShapeServiceImpl.class);
    private static final ShapeServiceImpl instance = new ShapeServiceImpl();

    private ShapeServiceImpl() {
    }

    public static ShapeServiceImpl getInstance() {
        return instance;
    }

    @Override
    public double area(Quadrangle quadrangle) {
        EntryPoint a = quadrangle.getA();
        EntryPoint b = quadrangle.getB();
        EntryPoint c = quadrangle.getC();
        EntryPoint d = quadrangle.getD();
        double ab = sideLength(a, b);
        double ac = sideLength(a, c);
        double bc = sideLength(b, c);
        double cd = sideLength(c, d);
        double halfPerimeter = perimeter(quadrangle)/2;
        double result = Math.sqrt((halfPerimeter-ab)*(halfPerimeter-ac)*(halfPerimeter-bc)*(halfPerimeter-cd));
        logger.info("area of {} = {}", quadrangle, result);
        return result;
    }

    @Override
    public double perimeter(Quadrangle quadrangle) {
        EntryPoint a = quadrangle.getA();
        EntryPoint b = quadrangle.getB();
        EntryPoint c = quadrangle.getC();
        EntryPoint d = quadrangle.getD();
        double ab = sideLength(a, b);
        double ac = sideLength(a, c);
        double bc = sideLength(b, c);
        double cd = sideLength(c, d);
        double result = ab + ac + bc + cd;
        logger.info("Perimeter of {} = {}", quadrangle, result);
        return result;
    }

    @Override
    public double sideLength(EntryPoint point1, EntryPoint point2) {
        double x1 = point1.getX();
        double y1 = point1.getY();
        double x2 = point2.getX();
        double y2 = point2.getY();
        double result = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        logger.info("Side length = ", result);
        return result;
    }

    @Override
    public boolean isQuadrangle(Quadrangle quadrangle) {
        QuadrangleValidator validator = new QuadrangleValidator();
        boolean flag = validator.isQuadrangle(quadrangle.getA(), quadrangle.getB(), quadrangle.getC(), quadrangle.getD());
        logger.info("Is quadrangle : {}",flag);
        return flag;
    }

    @Override
    public void isConvexQuadrangle(Quadrangle quadrangle) {
        EntryPoint a = quadrangle.getA();
        EntryPoint b = quadrangle.getB();
        EntryPoint c = quadrangle.getC();
        EntryPoint d = quadrangle.getD();
        if (isIntersection(a,b,c,d))
            logger.info("quadrangle is not convex");
        else
            logger.info("quadrangle is convex");
    }

    public boolean isIntersection (EntryPoint start1, EntryPoint start2, EntryPoint end1, EntryPoint end2){
        double dir1X = end1.getX() - start1.getX();
        double dir1Y = end1.getY() - start1.getY();
        double dir2X = end2.getX() - start2.getX();
        double dir2Y = end2.getY() - start2.getY();
        double a1 = -dir1Y;
        double b1 = +dir1X;
        double d1 = -(a1*start1.getX() + b1*start1.getY());
        double a2 = -dir2Y;
        double b2 = +dir2X;
        double d2 = -(a2*start2.getX() + b2*start2.getY());
        double seg1_line2_start = a2*start1.getX() + b2*start1.getY() + d2;
        double seg1_line2_end= a2*end1.getX() + b2*end1.getY() + d2;
        double seg2_line1_start= a1*start2.getX() + b1*start2.getY() + d1;
        double seg2_line1_end= a1*end2.getX() + b1*end2.getY() + d1;
        if (seg1_line2_start * seg1_line2_end >= 0 || seg2_line1_start * seg2_line1_end >= 0)
            return false;
        else
            return true;
    }

    @Override
    public void typeOfQuadrangle(Quadrangle quadrangle) {
        EntryPoint a = quadrangle.getA();
        EntryPoint b = quadrangle.getB();
        EntryPoint c = quadrangle.getC();
        EntryPoint d = quadrangle.getD();
        if (((c.getX() - b.getX()) * (d.getY() - a.getY()) == (d.getX() - a.getX()) * (c.getY() - b.getY())) ||
                ((b.getX() - a.getX()) * (c.getY() - d.getY()) == (c.getX() - d.getX()) * (b.getY() - a.getY()))) {
            if (((b.getX() - a.getX()) * (c.getY() - d.getY()) != (c.getX() - d.getX()) * (b.getY() - a.getY())) &&
                    ((c.getX() - b.getX()) * (d.getY() - a.getY()) != (d.getX() - a.getX()) * (c.getY() - b.getY())))
                logger.info("trapeziod");
        }
        else {
            logger.info("arbitrary quadrangle");
        }
        if((b.getY()-a.getY())*(b.getX()-a.getX())==(d.getY()-c.getY())*(d.getX()-c.getX()) && (c.getY()-b.getY())*(c.getX()-b.getX())==(a.getY()-d.getY())*(a.getX()-d.getX()))
            logger.info("figure is  rhombus");
        if((b.getY()-a.getY())*(b.getX()-a.getX())==(c.getY()-b.getY())*(c.getX()-b.getX()) && (c.getY()-b.getY())*(c.getX()-b.getX())==(d.getY()-c.getY())*(d.getX()-c.getX()) &&
                (d.getY()-c.getY())*(d.getX()-c.getX())==(a.getY()-d.getY())*(a.getX()-d.getX()))
            logger.info("figure is square");

    }
}