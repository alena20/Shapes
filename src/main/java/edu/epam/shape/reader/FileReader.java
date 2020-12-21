package edu.epam.shape.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
    private static final Logger logger = LogManager.getLogger(FileReader.class);

    public List<String> readFromFile(String path){
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            list = stream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("error reading file : {} ",e.getMessage());
        }
        System.out.println(list.toString());
        return list;
    }
}
