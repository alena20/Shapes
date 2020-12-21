package edu.epam.shape.observer;

public interface Observable<T> {
    void attach(T observer);
    void detach(T observer);
    void notifyObserver();
}