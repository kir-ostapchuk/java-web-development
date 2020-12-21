package com.epam.jwd.task.storage.impl;

import com.epam.jwd.task.exception.FigureNotExistException;
import com.epam.jwd.task.model.factories.impl.line.Line;
import com.epam.jwd.task.specification.Specification;
import com.epam.jwd.task.storage.FigureStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class LineStorage implements FigureStorage<Line> {

    public static final List<Line> linesStorage = new ArrayList<>();

    @Override
    public boolean removeAll(Line figure) {
        return linesStorage.removeIf(line -> line.getPoints().equals(figure.getPoints()));
    }

    @Override
    public List<Line> find(Line figure) {
        return linesStorage.stream()
                .filter(line -> line.getPoints().equals(figure.getPoints()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Line> findById(UUID id) {
        return linesStorage.stream()
                .filter(line -> line.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Line> findBySpecification(Specification specification) {
        return linesStorage.stream()
                .filter(specification::matches)
                .collect(Collectors.toList());
    }
}