package com.epam.jwd.task.model;

import com.epam.jwd.task.view.Figure;
import com.epam.jwd.task.specification.Specification;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class FigureStorage<T extends Figure> {

    private final List<T> figureStorage;

    public FigureStorage(List<T> figureStorage) {
        this.figureStorage = figureStorage;
    }

    public boolean removeAll(T figure) {
        return figureStorage.removeIf(f -> f.getPoints().equals(figure.getPoints()));
    }

    public List<T> find(T figure) {
        return figureStorage.stream()
                .filter(f -> f.getPoints().equals(figure.getPoints()))
                .collect(Collectors.toList());
    }

    public Optional<T> findById(UUID id) {
        return figureStorage.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst();
    }

    public List<T> findBySpecification(Specification specification) {
        return figureStorage.stream()
                .filter(specification::matches)
                .collect(Collectors.toList());
    }
}
