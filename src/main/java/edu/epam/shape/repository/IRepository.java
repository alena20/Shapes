package edu.epam.shape.repository;

import edu.epam.shape.specification.ISpecification;

import java.util.Comparator;
import java.util.List;

public interface IRepository<T> {
    void add(T t);
    void remove(T t);
    T get(int index);
    List<T> sort(Comparator<? super T> comparator);
    List<T> query(ISpecification<T> specification);
}