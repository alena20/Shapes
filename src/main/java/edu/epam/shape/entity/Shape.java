package edu.epam.shape.entity;

import edu.epam.shape.util.IdGenerator;

public abstract class Shape {
    private long id = IdGenerator.generateId();

    public long getId() {
        return id;
    }

}
