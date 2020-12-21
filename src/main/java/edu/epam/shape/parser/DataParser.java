package edu.epam.shape.parser;

import edu.epam.shape.entity.EntryPoint;
import edu.epam.shape.validator.DataValidator;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    private static final String DELIMITER = "\\s+";

    public List<EntryPoint> parseQuadrangle(List<String> list) {
        List<EntryPoint> points = new ArrayList<>();
        DataValidator inputValidator = new DataValidator();
        for (String line: list) {
            if(inputValidator.validateInput(line)){
                String [] data = line.split(DELIMITER);
                EntryPoint p1 = new EntryPoint(Double.parseDouble(data[0]),Double.parseDouble(data[1]));
                EntryPoint p2 = new EntryPoint(Double.parseDouble(data[2]),Double.parseDouble(data[3]));
                EntryPoint p3 = new EntryPoint(Double.parseDouble(data[4]),Double.parseDouble(data[5]));
                EntryPoint p4 = new EntryPoint(Double.parseDouble(data[6]),Double.parseDouble(data[7]));
                points.add(p1);
                points.add(p2);
                points.add(p3);
                points.add(p4);
            }
        }
        return points;
    }
}
