package com.epam.jwd.task.storage.impl;

import com.epam.jwd.task.model.factories.impl.square.Square;
import com.epam.jwd.task.model.factories.impl.subfigures.MultiAngleFigure;
import com.epam.jwd.task.model.factories.impl.triangle.Triangle;
import com.epam.jwd.task.specification.Specification;
import com.epam.jwd.task.storage.FigureStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class SquareStorage implements FigureStorage<Square> {

    public static final List<Square> squareStorage = new ArrayList<>();

    @Override
    public boolean removeAll(Square figure) {
        return squareStorage.removeIf(square -> square.getPoints().equals(figure.getPoints()));
    }

    @Override
    public List<Square> find(Square figure) {
        return squareStorage.stream()
                .filter(square -> square.getPoints().equals(figure.getPoints()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Square> findById(UUID id) {
        return squareStorage.stream()
                .filter(square -> square.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Square> findBySpecification(Specification specification) {
        return squareStorage.stream()
                .filter(specification::matches)
                .collect(Collectors.toList());
    }
}
