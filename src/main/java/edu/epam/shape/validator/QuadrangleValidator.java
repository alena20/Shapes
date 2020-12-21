package edu.epam.shape.validator;

import edu.epam.shape.entity.EntryPoint;

import java.util.ArrayList;
import java.util.List;

public class QuadrangleValidator {
    public boolean isQuadrangle(EntryPoint point1, EntryPoint point2, EntryPoint point3, EntryPoint point4) {
        double x1 = point1.getX();
        double y1 = point1.getY();
        double x2 = point2.getX();
        double y2 = point2.getY();
        double x3 = point3.getX();
        double y3 = point3.getY();
        double x4 = point4.getX();
        double y4 = point4.getY();
        if(point1.equals(point2) || point1.equals(point3) || point1.equals(point4) || point2.equals(point3) || point2.equals(point4) || point3.equals(point4))
            return false;
        if (IsPointsOnLine(x2, y2, x3, y3, x4, y4) || IsPointsOnLine(x1, y1, x3, y3, x4, y4) || IsPointsOnLine(x1, y1, x2, y2, x4, y4) || IsPointsOnLine(x1, y1, x2, y2, x3, y3)) {
            return false;
        }

        return true;
    }

    public boolean IsPointsOnLine(double x1, double y1, double x2, double y2, double x3, double y3) {
        return (x3 * (y2 - y1) - y3 * (x2 - x1) == x1 * y2 - x2 * y1);
    }
}
