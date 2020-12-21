package edu.epam.shape.exception;

public class ShapeFactoryException extends Exception {
    public ShapeFactoryException() {
    }

    public ShapeFactoryException(String message) {
        super(message);
    }

    public ShapeFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShapeFactoryException(Throwable cause) {
        super(cause);
    }
}
