package edu.epam.shape.parser;

import edu.epam.shape.entity.EntryPoint;
import edu.epam.shape.reader.FileReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DataParserTest {
    public static final String PATH = "file/data.txt";

    @Test
    public void pasreData(){
        List<EntryPoint> expected = new ArrayList<>();
        EntryPoint p1 = new EntryPoint(1,3);
        EntryPoint p2 = new EntryPoint(1,6);
        EntryPoint p3 = new EntryPoint(4,8);
        EntryPoint p4 = new EntryPoint(4,5);
        expected.add(p1);
        expected.add(p2);
        expected.add(p3);
        expected.add(p4);
        FileReader reader = new FileReader();
        List<String> list = reader.readFromFile(PATH);
        DataParser parser = new DataParser();
        List<EntryPoint> actual = parser.parseQuadrangle(list);;
        Assert.assertEquals(actual,expected);
    }

}