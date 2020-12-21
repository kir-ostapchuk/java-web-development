package com.epam.jwd.task.storage.impl;

import com.epam.jwd.task.model.factories.impl.line.Line;
import com.epam.jwd.task.model.factories.impl.triangle.Triangle;
import com.epam.jwd.task.specification.Specification;
import com.epam.jwd.task.storage.FigureStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class TriangleStorage implements FigureStorage<Triangle> {

    public static final List<Triangle> triangleStorage = new ArrayList<>();

    @Override
    public boolean removeAll(Triangle figure) {
        return triangleStorage.removeIf(triangle -> triangle.getPoints().equals(figure.getPoints()));
    }

    @Override
    public List<Triangle> find(Triangle figure) {
        return triangleStorage.stream()
                .filter(triangle -> triangle.getPoints().equals(figure.getPoints()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Triangle> findById(UUID id) {
        return triangleStorage.stream()
                .filter(triangle -> triangle.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Triangle> findBySpecification(Specification specification) {
        return triangleStorage.stream()
                .filter(specification::matches)
                .collect(Collectors.toList());
    }
}
