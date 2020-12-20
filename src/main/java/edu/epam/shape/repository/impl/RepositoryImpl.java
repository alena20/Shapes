package edu.epam.shape.repository.impl;

import edu.epam.shape.entity.Quadrangle;
import edu.epam.shape.repository.IRepository;
import edu.epam.shape.specification.ISpecification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RepositoryImpl implements IRepository<Quadrangle> {
    private static final RepositoryImpl instance = new RepositoryImpl();
    private List<Quadrangle> quadrangles = new ArrayList<>();

    private RepositoryImpl() {}

    public static RepositoryImpl getInstance() {
        return instance;
    }
    @Override
    public void add(Quadrangle quadrangle) {
        quadrangles.add(quadrangle);
    }

    @Override
    public void remove(Quadrangle quadrangle) {
        quadrangles.remove(quadrangle);
    }

    @Override
    public Quadrangle get(int index) {
        return quadrangles.get(index);
    }

    @Override
    public List<Quadrangle> sort(Comparator<? super Quadrangle> comparator) {
        List<Quadrangle> listResult = new ArrayList<>(quadrangles);
        listResult.sort(comparator);
        return listResult;
    }

    @Override
    public List<Quadrangle> query(ISpecification<Quadrangle> specification) {
        List<Quadrangle> listResult = quadrangles.stream().filter(o -> specification.specify(o)).collect(Collectors.toList());
        return listResult;
    }


}
