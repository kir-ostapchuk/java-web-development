package com.epam.jwd.task.storage.impl;

import com.epam.jwd.task.model.factories.impl.subfigures.MultiAngleFigure;
import com.epam.jwd.task.model.factories.impl.triangle.Triangle;
import com.epam.jwd.task.specification.Specification;
import com.epam.jwd.task.storage.FigureStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class MultiAngleFigureStorage implements FigureStorage<MultiAngleFigure> {

    public static final List<MultiAngleFigure> multiAngleFigureStorage = new ArrayList<>();

    @Override
    public boolean removeAll(MultiAngleFigure figure) {
        return multiAngleFigureStorage.removeIf(multiAngleFigure -> multiAngleFigure.getPoints().equals(figure.getPoints()));
    }

    @Override
    public List<MultiAngleFigure> find(MultiAngleFigure figure) {
        return multiAngleFigureStorage.stream()
                .filter(multiAngleFigure -> multiAngleFigure.getPoints().equals(figure.getPoints()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MultiAngleFigure> findById(UUID id) {
        return multiAngleFigureStorage.stream()
                .filter(multiAngleFigure -> multiAngleFigure.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<MultiAngleFigure> findBySpecification(Specification specification) {
        return multiAngleFigureStorage.stream()
                .filter(specification::matches)
                .collect(Collectors.toList());
    }
}
